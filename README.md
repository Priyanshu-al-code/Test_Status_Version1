
# TestStatusMapper

**TestStatusMapper** is a Java-based tool designed to parse a JSON file (extracted from `testdata.js`) and map the corresponding test statuses to a CSV file. It is particularly useful for updating test statuses in a CSV file based on the data provided in a JavaScript file containing test results.

## Features

- **JSON Parsing**: Utilizes Gson to parse JSON content from a `testdata.js` file.
- **CSV Manipulation**: Employs OpenCSV to read and write CSV files, enabling the update of test statuses based on parsed JSON data.
- **Flexible Mapping**: Supports mapping of test statuses to CSV rows by matching `testPuzzleTitle` and `testDescription` fields.

## Prerequisites

- **Java 8 or later**: Ensure that Java is installed on your system.
- **Maven**: The project uses Maven for dependency management.

## Setup

1. **Clone the repository**:

   \`\`\`bash
   git clone https://github.com/yourusername/TestStatusMapper.git
   cd TestStatusMapper
   \`\`\`

2. **Replace Hardcoded Paths**:
   After cloning the repository, replace the hardcoded paths for the JSON and CSV files in the \`TestStatusMapper.java\` file with your actual file paths.

   - Open \`src/main/java/com/example/TestStatusMapper.java\`.
   - Locate the following lines:

     \`\`\`java
     String jsFilePath = "C:\\Users\\PRINAUTS\\Desktop\\GandalfReport\\Test_Status_v1\\src\\main\\java\\resources\\testdata.js";
     String csvFilePath = "C:\\Users\\PRINAUTS\\Desktop\\GandalfReport\\Test_Status_v1\\src\\main\\java\\resources\\Status16.csv";
     \`\`\`

   - Replace these paths with the actual paths to your \`testdata.js\` and \`Status16.csv\` files on your system.

3. **Install Dependencies**:

   \`\`\`bash
   mvn clean install
   \`\`\`

## Usage

1. **Run the Program**:
   - Open the \`TestStatusMapper.java\` file in your IDE (such as IntelliJ IDEA).
   - Click on the green "Run" button next to the \`main\` method to execute the program.

2. **Check the Output**:
   - The console will display the mapping process, including any unmatched entries.
   - The \`Status16.csv\` file will be updated with the test statuses from the JSON file.

## Dependencies

This project relies on the following dependencies, managed via Maven:

- **Gson**: For JSON parsing.
- **OpenCSV**: For reading and writing CSV files.

The dependencies are specified in the \`pom.xml\` file.
