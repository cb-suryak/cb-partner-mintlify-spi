## What is Partner SPIs?
Chargebee supports a wide range of third-party integrations to deliver enhanced functionalities to its customers. To facilitate this, Chargebee provides Service Provider Interfaces (SPIs), defined in the OpenAPI specification, for various capabilities.

Chargebee Partners can leverage these SPIs to develop adapters that seamlessly integrate with Chargebee, extending its core capabilities to meet diverse business needs.


## What are the available Chargebee Partner SPIs? 
Currently, Chargebee offer SPIs for the following capabilities:

- [Tax](https://chargebee.mintlify.app/api-reference/v2/docs/Overview) <!-- should we have a better name for this? -->
- [Tax Registration Number Validation](https://chargebee.mintlify.app/api-reference/v2/docs/Overview)

These SPIs allow partners to build custom adapters by implementing the SPI-defined endpoints. The detailed OpenAPI specifications for these SPIs can be found in the spec/spi folder of the repository.

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
  **Example:** `spec/spi/openapi_tax_reg_number_validation.yml`.
- Update the [spec.config](spec.config) file to include the new file configuration.


#### 2. Validate the OpenAPI Specification
- Use the following command to validate a **specific** OpenAPI specification
  ```bash
  sh gradlew validateSpec_<capability_name> --warning-mode all --stacktrace
  ```

- Use the following command to validate all the OpenAPI specs:
  ```bash
  sh gradlew validateSpec  --warning-mode all --stacktrace
  ```

#### 3. Generate the Bundled OpenAPI spec & Models
- Each OpenAPI specification file in the spec/spi directory may reference other specification files (e.g., credentials.yml).
  To generate a single bundled OpenAPI specification, use the following commands:
  - for a specific openAPI spec:
  ```bash
  sh gradlew generateSpec_<capability_name> --warning-mode all --stacktrace
  ```  
  - **Ex:**  `sh gradlew generateSpec_tax --warning-mode all --stacktrace`

  - for all openAPI specs:
  ```bash
  sh gradlew generateSpec  --warning-mode all --stacktrace
```
  
#### 4. Use Java Models, clients and docs
- For Java, Model, clients and docs files will be generated under `generated/<capability_name>` folder. Ex: `generated/tax`

## General Commands
- Validate the open api spec `sh gradlew validateSpec --warning-mode all --stacktrace`
- Generate models, api client, docs etc `sh gradlew generateSpec --warning-mode all --stacktrace`
  - New folder `generated` will be created which will have all models, clients, docs etc
- Build `sh gradlew build` spi jar will be generated to ./build/libs/cb-provider-spi.jar

## Commands for Chargebee internal usage:



<!--
## Chargebee's Open API Spec
Service Provider Interfaces for Chargebee's capabilities
- [Open api tax_spec](spec/spi/openapi_tax.yml)
- [Open api trn_validation_spec](spec/spi/openapi_trn.yml)
- To view open api spec visit https://editor.swagger.io/ and place generated yaml content

## Add new open api spec
- Add **openapi.yml** file under `spec/spi/` folder, like spec/spi/**abc**
- Add config details in [spec.config](spec.config) file
- Command to validate open api spec `sh gradlew validateSpec_abc --warning-mode all --stacktrace`
- Command to generate open api spec `sh gradlew generateSpec_abc --warning-mode all --stacktrace`
- Java models, clients and doc will be generated under `generated/abc` folder
- 

## Commands
- Validate the open api spec `sh gradlew validateSpec --warning-mode all --stacktrace`
- Generate models, api client, docs etc `sh gradlew generateSpec --warning-mode all --stacktrace`
    - New folder `generated` will be created which will have all models, clients, docs etc
- Build `sh gradlew build` spi jar will be generated to ./build/libs/cb-provider-spi.jar
- Publish jar to local maven repo `sh gradlew build publishToMavenLocal`

## Working on Service Adapter SPI for first time

Follow the below steps for generating jar

Clone repository in local
```shell
  git clone git@github.com:chargebee/cb-provider-spi.git
```

Validate open api specs using below command
```shell
sh gradlew validateSpec  --warning-mode all --stacktrace
```

Validate specific open api spec using below command
```shell
 sh gradlew validateSpec_tax  --warning-mode all --stacktrace
```

Generate models of all open api specs using below command
```shell
sh gradlew generateSpec  --warning-mode all --stacktrace
```

Generate models specific open api spec using below command
```shell
sh gradlew generateSpec_tax  --warning-mode all --stacktrace
```

When models are generated successfully, generate jar using below command
```shell
sh gradlew clean build
```
If no build issue, and if jar is successfully created, go to **./build/libs/cb-provider-spi.jar**


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
Tax provider capabilities for new tax providers will be validated against a constantly updating JSON Schema, to validate the correctness and completeness of configurations. JSON Schema can be referenced below.
- [TaxProviderCapabilities JSONSchema](spec/capabilities/tax-provider.schema.json)

## Steps to follow release


1. Assume release is 0.0.9. (find release from git page release section)
2. create a new branch called release/<release> so this would be release/0.0.9
3. create new branch for ticket feat/<ticket-number>
4. commit to  feat/<ticket-number>
5. Raise PR from feat/<ticket-number> to release/0.0.9
6. After PR is approved and merged
7. Raise PR from release/0.0.9 to dev. Once PR is merged it will auto release the 0.0.9 version of SPI for dev code base
8. After that raise PR from release/0.0.9 to main. Once PR is merged it will auto release the 0.0.9 version of SPI for prod codebase
