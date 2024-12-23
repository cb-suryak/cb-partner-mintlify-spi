## What is Partner SPIs?
Chargebee supports a wide range of third-party integrations to deliver enhanced functionalities to its customers. To facilitate this, Chargebee provides Service Provider Interfaces (SPIs), defined in the OpenAPI specification, for various capabilities.

Chargebee Partners can leverage these SPIs to develop adapters that seamlessly integrate with Chargebee, extending its core capabilities to meet diverse business needs.


## What are the available Chargebee Partner SPIs? 
Currently, Chargebee offer SPIs for the following capabilities:

- [Tax](https://chargebee.mintlify.app/api-reference/v2/docs/Overview) <!-- should we have a better name for this? -->
- [Tax Registration Number Validation](https://chargebee.mintlify.app/api-reference/v2/docs/Overview)

These SPIs allow partners to build custom adapters by implementing the SPI-defined endpoints. The detailed OpenAPI specifications for these SPIs can be found in the spec/spi folder of the repository:

- [Tax SPI](./spec/spi/openapi_tax.yml) <!-- should we have a better name for this? -->
- [Tax Registration Number Validation SPI](./spec/spi/openapi_trn.yml)
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

## Updating & Using Postman Collection (TO BE ADDED)

- Postman test suites comprising test cases for each SPI endpoint is available in the `postman/<capability_name>` directory.  
  **Example:** `postman/tax`.

- Any changes made to the OpenAPI specification **MUST** be accompanied by adding or updating the corresponding test cases in the Postman collection.

- To test the SPI endpoints, import the Postman collection into your Postman workspace or Chargebee workspace.([Attach link here - TBA]) 

## Chargebee Internal Usage Content

- [Local Setup](docs/localsetup.md)
- [Add or Update a SPI](docs/add_update_spi.md)
- [Update Mintlify Files](docs/mintlify_files.md)
- [Release](docs/release.md)