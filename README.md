# TestStatusMapper

TestStatusMapper is a Java-based tool that parses a JSON file (extracted from `testdata.js`) and maps the test statuses to a corresponding CSV file. This tool is useful for updating the test statuses in a CSV file based on the data available in a JavaScript file containing test results.

## Features

- **JSON Parsing**: Uses Gson to parse JSON content from a `testdata.js` file.
- **CSV Manipulation**: Uses OpenCSV to read and write CSV files, allowing you to update test statuses based on the parsed JSON data.
- **Flexible Mapping**: Maps test statuses to CSV rows based on matching `testPuzzleTitle` and `testDescription` fields.

## Prerequisites

- **Java 8 or later**: Make sure you have Java installed on your system.
- **Maven**: This project uses Maven for dependency management.

## Setup

1. **Clone the repository**:

   ```bash
   git clone https://github.com/yourusername/TestStatusMapper.git
   cd TestStatusMapper
   
2.Replace Hardcoded Paths:
 After cloning the repository, replace the hardcoded paths for the JSON and CSV files in the TestStatusMapper.java file with your actual file paths.
->Open src/main/java/com/example/TestStatusMapper.java.
->Locate the following lines:

```java
String jsFilePath = "C:\\Users\\PRINAUTS\\Desktop\\GandalfReport\\Test_Status_v1\\src\\main\\java\\resources\\testdata.js";
String csvFilePath = "C:\\Users\\PRINAUTS\\Desktop\\GandalfReport\\Test_Status_v1\\src\\main\\java\\resources\\Status16.csv";
```
-> Replace these paths with the actual paths to your testdata.js and Status16.csv files on your system

3.  **Install dependencies**:
   ```bash
  mvn clean install
```  
## Usage
1. Run the program:
To run the TestStatusMapper program, open the TestStatusMapper.java file in your IDE (such as IntelliJ IDEA), then click on the green "Run" button next to the main method.
2. Check output:
-> The console will show the mapping process, including any unmatched entries.
-> The Status16.csv file will be updated with the test statuses from the JSON file.

## Dependencies
This project uses the following dependencies:

-> Gson: For JSON parsing.
-> OpenCSV: For reading and writing CSV files.
These dependencies are managed via Maven and can be found in the pom.xml file.
