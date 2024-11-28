import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JsonSchemaValidator {

    private static final String DEFAULT_SCHEMA_PATH = "schema.json";
    private static final String SCHEMA_ENV_VAR = "JSON_SCHEMA_PATH";
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java JsonSchemaValidator <json_file>");
            System.exit(1);
        }

        String jsonPath = args[0];
        String schemaPath = System.getenv(SCHEMA_ENV_VAR);
        if (schemaPath == null || schemaPath.isEmpty()) {
            schemaPath = DEFAULT_SCHEMA_PATH;
            System.out.println("Warning: JSON_SCHEMA_PATH not set. Using default schema path: " + DEFAULT_SCHEMA_PATH);
        }

        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get(jsonPath)));
            JSONObject jsonSchema = new JSONObject(new JSONTokener(new FileInputStream(schemaPath)));
            JSONObject jsonSubject = new JSONObject(jsonContent);

            Schema schema = SchemaLoader.load(jsonSchema);
            schema.validate(jsonSubject);

            System.out.println("Validation successful! The JSON is valid against the schema.");

        } catch (ValidationException ve) {
            System.out.println("JSON validation failed. Errors:");
            printValidationErrors(ve, jsonPath);
        } catch (JSONException je) {
            System.out.println("JSON parsing error:");
            printJSONParsingError(je, jsonPath);
        } catch (IOException e) {
            System.out.println("Error reading files: " + e.getMessage());
        }
    }

    private static void printValidationErrors(ValidationException ve, String jsonPath) {
        List<String> allMessages = ve.getAllMessages();
        for (int i = 0; i < allMessages.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, allMessages.get(i));
        }
        System.out.println("\nDetailed error information:");
        printValidationErrorDetails(ve, jsonPath, 0);
    }

    private static void printValidationErrorDetails(ValidationException ve, String jsonPath, int depth) {
        String indent = "  ".repeat(depth);
        System.out.printf("%sError: %s%n", indent, ve.getMessage());
        System.out.printf("%sJSON Path: %s%n", indent, ve.getPointerToViolation());

        try {
            List<String> lines = Files.readAllLines(Paths.get(jsonPath));
            String errorPath = ve.getPointerToViolation();
            int lineNumber = findLineNumber(lines, errorPath);
            if (lineNumber != -1) {
                System.out.printf("%sLine number: %d%n", indent, lineNumber);
                System.out.printf("%sLine content: %s%n", indent, lines.get(lineNumber - 1).trim());
            }
        } catch (IOException e) {
            System.out.printf("%sUnable to retrieve line information: %s%n", indent, e.getMessage());
        }

        List<ValidationException> causingExceptions = ve.getCausingExceptions();
        if (!causingExceptions.isEmpty()) {
            System.out.printf("%sNested errors:%n", indent);
            for (ValidationException cause : causingExceptions) {
                printValidationErrorDetails(cause, jsonPath, depth + 1);
            }
        }
    }

    private static void printJSONParsingError(JSONException je, String jsonPath) {
        System.out.println(je.getMessage());

        try {
            List<String> lines = Files.readAllLines(Paths.get(jsonPath));
            if (je.getMessage().contains("at character")) {
                int charPosition = Integer.parseInt(je.getMessage().replaceAll(".*at character (\\d+).*", "$1"));
                int lineNumber = 1;
                int currentPosition = 0;

                for (String line : lines) {
                    if (currentPosition + line.length() + 1 > charPosition) {
                        System.out.printf("Line number: %d%n", lineNumber);
                        System.out.printf("Line content: %s%n", line.trim());
                        System.out.printf("Error position: %s^%n", " ".repeat(charPosition - currentPosition - 1));
                        break;
                    }
                    currentPosition += line.length() + 1; // +1 for newline
                    lineNumber++;
                }
            }
        } catch (IOException e) {
            System.out.println("Unable to retrieve line information: " + e.getMessage());
        }
    }

    private static int findLineNumber(List<String> lines, String jsonPath) {
        String[] pathParts = jsonPath.split("/");
        StringBuilder currentPath = new StringBuilder();
        int nestingLevel = 0;

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            if (line.contains(":")) {
                String key = line.split(":")[0].trim().replace("\"", "");
                if (nestingLevel < pathParts.length && key.equals(pathParts[nestingLevel])) {
                    currentPath.append("/").append(key);
                    nestingLevel++;
                    if (currentPath.toString().equals(jsonPath)) {
                        return i + 1; // +1 because line numbers start at 1
                    }
                }
            }
            if (line.contains("{")) nestingLevel++;
            if (line.contains("}")) nestingLevel--;
        }
        return -1; // Path not found
    }
}
