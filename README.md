## What is Partner SPIs?
Chargebee supports a wide range of third-party integrations to deliver enhanced functionalities to its customers. To facilitate this, Chargebee provides Service Provider Interfaces (SPIs), defined in the OpenAPI specification, for various capabilities.

Chargebee Partners can leverage these SPIs to develop adapters that seamlessly integrate with Chargebee, extending its core capabilities to meet diverse business needs.


## What are the available Chargebee Partner SPIs? 
Currently, Chargebee offer SPIs for the following capabilities:

- [Tax](https://chargebee.mintlify.app/api-reference/v2/docs/Overview) <!-- should we have a better name for this? -->
- [Tax Registration Number Validation](https://chargebee.mintlify.app/api-reference/v2/docs/Overview)

These SPIs allow partners to build custom adapters by implementing the SPI-defined endpoints. The detailed OpenAPI specifications for these SPIs can be found in the spec/spi folder of the repository.

## Setup with Mintlify

#### 1. Clone the repo
- Clone repository in local

```bash
    git clone git@github.com:chargebee/cb-provider-spi.git
```

#### 2. Install the Mintlify CLI
- Install the Mintlify CLI globally using npm:

```bash
    npm i -g mintlify
```

#### 3. Run Local Development Server
- For local preview of documentation run below command:

```bash
    mintlify dev
```


## Steps to Add or Update a SPI Using OpenAPI Specification

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


## Steps to update mintlify’s files for creating a SPI endpoint or new openAPISpec

#### Prerequisites

#### 1. Install Node.js and npm
- Node.js and npm are required to run the Mintlify CLI.    

#### 2. Install Mintlify CLI
- Install the Mintlify CLI globally to manage documentation and generate .mdx files:
  ```bash
  npm i -g mintlify
  ```

#### 1. Generate mdx files for SPI endpoint or new openAPISpec
- Use the following command to create mdx files for the endpoints from the openAPI spec file you have added or made changes to
  ```bash
  npx @mintlify/scraping@latest openapi-file <path-to-openapi-file> -o api-reference
  ```
  **Example:**
  ```bash
  npx @mintlify/scraping@latest openapi-file ./spec/spi/openapi_tax.yml -o api-reference
  ```

#### 2. Add reference to generated endpoint mdx files in navigation section of mint.json

#### 2.1 Locate Generated MDX Files
After running the mdx files generation command, check the api-reference directory for new MDX files.

#### 2.2 Update mint.json Navigation
```json
{
  "navigation": [
    {
      "group": "API Reference",
      "pages": [
        // Existing pages
        "api-reference/existing-endpoint",
        
        // Add your new endpoint MDX file here
        "api-reference/new-endpoint-file"
      ]
    }
  ]
}
```
#### Note
1. Don't use full file paths. Use relative paths.
2. Don't include the .mdx extension.

#### 3. Preview the changes locally
- Run the following command to preview the changes locally
  ```bash
  mintlify dev
  ```

<!--
## Getting Started

Please follow the installation instruction of generated readme to generate the jar of this project. Currently, this jar is used as a dependency in chargebee-app too to use APIs as well as models.

Add dependency
```maven
<dependency>
    <groupId>org.chargebee.spi</groupId>
    <artifactId>cb-provider-spi</artifactId>
    <version>${version}</version>
</dependency>
```

Following sample Java code demonstrates how to use the APIs and models from this project:

```java

/// Import classes:
import org.chargebee.spi.tax.client.ApiClient;
import org.chargebee.spi.tax.client.ApiException;
import org.chargebee.spi.tax.client.Configuration;
import org.chargebee.spi.tax.client.auth.*;
import org.chargebee.spi.tax.client.models.*;
import org.chargebee.spi.tax.api.AddressApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://rest.taxes.provider.com/api/v1");

    // Configure API key authorization: apiKey
    ApiKeyAuth apiKey = (ApiKeyAuth) defaultClient.getAuthentication("apiKey");
    apiKey.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //apiKey.setApiKeyPrefix("Token");

    // Configure HTTP bearer authorization: bearerAuth
    HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
    bearerAuth.setBearerToken("BEARER TOKEN");

    AddressApi apiInstance = new AddressApi(defaultClient);
    CheckAddressTaxabilityRequest checkAddressTaxabilityRequest = new CheckAddressTaxabilityRequest(); // CheckAddressTaxabilityRequest | 
    try {
      CheckAddressTaxabilityResponse result = apiInstance.checkAddressTaxability(checkAddressTaxabilityRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AddressApi#checkAddressTaxability");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```
-->

## JSON Schema validation
The capabilities of the built adapters will be validated against a constantly updating JSON Schema, to validate the correctness and completeness of configurations. JSON Schema can be referenced below.
- [TaxProviderCapabilities JSONSchema](spec/capabilities/tax-provider.schema.json)

Run the below script to perform json schema validation:
```shell
  sh json_schema_validation.sh <path to json file>
```
Example:
```shell
  sh json_schema_validation.sh spec/capabilities/tax-provider.file.json
```

## Steps to follow release(Chargebee owned)
1. Assume release is 0.0.9. (find release from git page release section)
2. create a new branch called release/<release> so this would be release/0.0.9
3. create new branch for ticket feat/<ticket-number>
4. commit to  feat/<ticket-number>
5. Raise PR from feat/<ticket-number> to release/0.0.9
6. After PR is approved and merged
7. Raise PR from release/0.0.9 to dev. Once PR is merged it will auto release the 0.0.9 version of SPI for dev code base
8. After that raise PR from release/0.0.9 to main. Once PR is merged it will auto release the 0.0.9 version of SPI for prod codebase

## Updating & Using Postman Collection (TO BE ADDED)

- Postman test suites comprising test cases for each SPI endpoint is available in the `postman/<capability_name>` directory.  
  **Example:** `postman/tax`.

- Any critical changes made to the OpenAPI specification **MUST** be accompanied by adding or updating the corresponding test cases in the Postman collection.

- To test the SPI endpoints, import the Postman collection into your Postman workspace or Chargebee workspace.([Attach link here - TBA])