#### 1. Modify the OpenAPI Specification

#### 1.1 Update an Existing SPI
- Edit the corresponding OpenAPI specification file to update the SPI.  
  **Example:** Modify a parameter in the `tax-estimate` endpoint located in `spec/spi/open_tax.yml`.

#### 1.2 Add a New SPI to an Existing OpenAPI Specification
- Append the new SPI endpoint to the relevant OpenAPI specification file.  
  **Example:** Add a new endpoint `check/taxability` in `spec/spi/open_tax.yml`.

#### 1.3 Add a New SPI in a New OpenAPI Specification
- Create a new OpenAPI specification file named `openapi_<capability_name>.yml` inside the `spec/spi/` directory.  
  **Example:** `spec/spi/openapi_tax.yml`.
- Update the [spec.config](spec.config) file to include the new file configuration.


#### 2. Validate the OpenAPI Specification
- Use the following command to validate a **specific** OpenAPI specification
  ```bash
  sh gradlew validateSpec_tax --warning-mode all --stacktrace
  ```

- Use the following command to validate all the OpenAPI specs:
  ```bash
  sh gradlew validateSpec  --warning-mode all --stacktrace  
  ```

#### 3. Generate the Bundled OpenAPI spec & related files
- Each OpenAPI specification file in the spec/spi directory may reference other specification files (e.g., credentials.yml).
  To generate a single bundled OpenAPI specification, use the following commands:
  - for a specific openAPI spec:
  ```bash
  sh gradlew generateSpec_tax --warning-mode all --stacktrace
  ```

  - for all openAPI specs:
  ```bash
  sh gradlew generateSpec  --warning-mode all --stacktrace
  ```

- The generated output will include:
  - Java Models
  - Clients
  - Markdown files

- These files will be located in the `generated/<capability_name>` folder. **Example:** `generated/tax`

#### 4. Generate SPI jar
- To build the SPI jar for Java, use the following command:
  ```bash
  sh gradlew build
  ```
- The generated SPI jar will be located in the `./build/libs/` directory.

#### 5. Update postman collection
- Refer to the [Updating & Using Postman Collection (TO BE ADDED)](#updating--using-postman-collection-to-be-added) section to follow the steps to update the Postman collection.