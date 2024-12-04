#!/bin/bash

# Make this script executable
chmod +x "$0"

# Check if Gradle wrapper is available
if ! command -v ./gradlew &> /dev/null
then
    echo "Gradle wrapper not found. Please ensure you're in the correct directory."
    exit 1
fi

# Check if a JSON file is provided
if [ "$#" -ne 1 ]; then
    echo "Usage: $0 <path_to_json_file>"
    exit 1
fi

# Automatically detect the schema file
SCHEMA_FILE=$(find . -name "*schema.json" | head -n 1)

if [ -z "$SCHEMA_FILE" ]; then
    echo "Error: Could not find a schema file in the current directory or its subdirectories."
    exit 1
fi

# Export the schema path as an environment variable
export JSON_SCHEMA_PATH="$SCHEMA_FILE"

echo "Using schema file: $JSON_SCHEMA_PATH"

# Clean and build the JSON Schema Validator
./gradlew clean buildJsonSchemaValidator

# Find the JAR file
JAR_FILE=$(find build/libs -name "json-schema-validator-1.0.jar" | head -n 1)

if [ -z "$JAR_FILE" ]; then
    echo "Error: Could not find the JSON Schema Validator JAR file. Build may have failed."
    exit 1
fi

# Run the Java application using the generated JAR file
java -jar "$JAR_FILE" "$1"

# Check the exit status
if [ $? -eq 0 ]; then
    echo "Validation completed successfully."
else
    echo "Validation failed. Please check the output above for details."
fi