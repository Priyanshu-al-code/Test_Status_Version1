package com.example;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestStatusMapper {

    public static void main(String[] args) {
        // Define file paths
        String jsFilePath = "C:\\Users\\PRINAUTS\\Desktop\\GandalfReport\\Test_Status_v1\\src\\main\\java\\resources\\testdata.js";
        String csvFilePath = "C:\\Users\\PRINAUTS\\Desktop\\GandalfReport\\Test_Status_v1\\src\\main\\java\\resources\\Status12.csv";

        // Check if CSV file exists and is accessible
        if (!Files.exists(Paths.get(csvFilePath))) {
            System.err.println("CSV file does not exist at: " + csvFilePath);
            return;
        }

        // Load and parse the testdata.js file
        String jsonContent;
        try {
            jsonContent = new String(Files.readAllBytes(Paths.get(jsFilePath)));
        } catch (IOException e) {
            System.err.println("Failed to read the testdata.js file: " + e.getMessage());
            return;
        }

        // Remove the variable declaration from the JS content to parse the JSON
        int jsonStartIndex = jsonContent.indexOf("{");
        if (jsonStartIndex == -1) {
            System.err.println("Invalid JSON format in testdata.js");
            return;
        }
        jsonContent = jsonContent.substring(jsonStartIndex);

        // Parse the JSON content using Gson
        Gson gson = new Gson();
        JsonObject jsonObject;
        Map<String, Map<String, String>> testStatusMap = new HashMap<>();

        try {
            jsonObject = JsonParser.parseString(jsonContent).getAsJsonObject();
            JsonArray categories = jsonObject.getAsJsonArray("categories");

            // Iterate over all categories and tests to build the testStatusMap
            for (int i = 0; i < categories.size(); i++) {
                JsonObject category = categories.get(i).getAsJsonObject();
                List<Map<String, Object>> tests = gson.fromJson(
                        category.get("tests"),
                        new TypeToken<List<Map<String, Object>>>() {}.getType()
                );

                for (Map<String, Object> test : tests) {
                    String testPuzzleTitle = normalizeString((String) test.get("testPuzzleTitle"));
                    String testDescription = normalizeString((String) test.get("testDescription"));
                    String testStatus = (String) test.get("testStatus");

                    testStatusMap.computeIfAbsent(testPuzzleTitle, _ -> new HashMap<>())
                            .put(testDescription, testStatus);
                }
            }

            System.out.println("Parsed testStatusMap: " + testStatusMap);
        } catch (Exception e) {
            System.err.println("Failed to parse JSON content: " + e.getMessage());
            return;
        }

        // Read the CSV file
        List<String[]> csvLines;
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            csvLines = reader.readAll();
            if (csvLines.isEmpty()) {
                System.out.println("CSV file is empty.");
            } else {
                System.out.println("CSV Lines before update:");
                for (String[] line : csvLines) {
                    System.out.println(String.join(", ", line));
                }
            }
        } catch (IOException | CsvException e) {
            System.err.println("Failed to read the CSV file: " + e.getMessage());
            return;
        }

        // Update the CSV content based on testPuzzleTitle and testDescription
        for (String[] line : csvLines) {
            if (line.length < 5) {
                System.out.println("Skipping malformed CSV line: " + String.join(", ", line));
                continue;
            }

            String csvTestPuzzleTitle = normalizeString(line[1]); // Assuming testPuzzleTitle is in the second column
            String csvTestDescription = normalizeString(line[3]); // Assuming testDescription is in the fourth column

            if (testStatusMap.containsKey(csvTestPuzzleTitle) &&
                    testStatusMap.get(csvTestPuzzleTitle).containsKey(csvTestDescription)) {
                line[4] = testStatusMap.get(csvTestPuzzleTitle).get(csvTestDescription); // Assuming status should go in the fifth column
            } else {
                System.out.println("No matching test data found for: " + csvTestPuzzleTitle + " - " + csvTestDescription);
            }
        }

        // Write the updated content back to the CSV file
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {
            writer.writeAll(csvLines);
            System.out.println("CSV Lines after update:");
            for (String[] line : csvLines) {
                System.out.println(String.join(", ", line));
            }
        } catch (IOException e) {
            System.err.println("Failed to write to CSV file: " + e.getMessage());
        }
    }

    /**
     * Normalizes a string by trimming, replacing multiple whitespace characters with a single space,
     * and removing line breaks.
     *
     * @param input The input string to normalize.
     * @return The normalized string.
     */
    private static String normalizeString(String input) {
        if (input == null) {
            return "";
        }
        // Replace all types of whitespace (spaces, tabs, line breaks) with a single space
        return input.trim().replaceAll("\\s+", " ");
    }
}