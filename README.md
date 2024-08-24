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
Install dependencies:

Ensure that Maven is installed, then run:

bash
Copy code
mvn clean install
Prepare the files:

Place your testdata.js JSON file at src/main/resources/testdata.js.
Place your CSV file at src/main/resources/Status16.csv.
Usage
Run the program:

You can run the TestStatusMapper program using the following command:

bash
Copy code
mvn exec:java -Dexec.mainClass="com.example.TestStatusMapper"
Check output:

The console will show the mapping process, including any unmatched entries.
The Status16.csv file will be updated with the test statuses from the JSON file.
File Structure
css
Copy code
TestStatusMapper/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── TestStatusMapper.java
│   │   └── resources/
│   │       ├── testdata.js
│   │       └── Status16.csv
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── TestStatusMapperTest.java
├── pom.xml
└── README.md
Dependencies
This project uses the following dependencies:

Gson: For JSON parsing.
OpenCSV: For reading and writing CSV files.
These dependencies are managed via Maven and can be found in the pom.xml file.

License
This project is licensed under the MIT License - see the LICENSE file for details.

Contributing
Feel free to fork the repository and submit pull requests. For major changes, please open an issue first to discuss what you would like to change.

Contact
For any questions or suggestions, please contact yourname@domain.com.

markdown
Copy code

### Notes:

- Update `yourusername`, `yourname@domain.com`, and the repository link in the README with your actual information.
- Ensure that the `testdata.js` and `Status16.csv` files are placed in the correct directory as specified in the setup sec
