# AuthenticationApi

All URIs are relative to *https://rest.taxes.provider.com/api/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**validateCredentials**](AuthenticationApi.md#validateCredentials) | **POST** /credentials/validate | Validate credentials |


<a id="validateCredentials"></a>
# **validateCredentials**
> CredentialValidationResponse validateCredentials()

Validate credentials

This endpoint is used to validate the credentials used to call the Service Provider.

### Example
```java
// Import classes:
import org.chargebee.spi.location_validation.client.ApiClient;
import org.chargebee.spi.location_validation.client.ApiException;
import org.chargebee.spi.location_validation.client.Configuration;
import org.chargebee.spi.location_validation.client.auth.*;
import org.chargebee.spi.location_validation.client.models.*;
import org.chargebee.spi.location_validation.api.AuthenticationApi;

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

    AuthenticationApi apiInstance = new AuthenticationApi(defaultClient);
    try {
      CredentialValidationResponse result = apiInstance.validateCredentials();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#validateCredentials");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**CredentialValidationResponse**](CredentialValidationResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Authentication succeeded. |  -  |
| **401** | Authentication failed. |  -  |
| **429** | Too many requests. |  -  |
| **500** | Unexpected error while processing request. |  -  |
| **503** | Service is unhealthy. |  -  |

