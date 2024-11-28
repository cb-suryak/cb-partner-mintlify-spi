# HealthApi

All URIs are relative to *https://rest.taxes.provider.com/api/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**fetchHealth**](HealthApi.md#fetchHealth) | **GET** /health | Fetch the health status of the Service Provider. |


<a id="fetchHealth"></a>
# **fetchHealth**
> HealthCheckResponse fetchHealth()

Fetch the health status of the Service Provider.

This endpoint is used to fetch the health status of the Service Provider.

### Example
```java
// Import classes:
import org.chargebee.spi.location_validation.client.ApiClient;
import org.chargebee.spi.location_validation.client.ApiException;
import org.chargebee.spi.location_validation.client.Configuration;
import org.chargebee.spi.location_validation.client.auth.*;
import org.chargebee.spi.location_validation.client.models.*;
import org.chargebee.spi.location_validation.api.HealthApi;

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

    HealthApi apiInstance = new HealthApi(defaultClient);
    try {
      HealthCheckResponse result = apiInstance.fetchHealth();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling HealthApi#fetchHealth");
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

[**HealthCheckResponse**](HealthCheckResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Service is healthy. |  -  |
| **429** | Too many requests. |  -  |
| **500** | Unexpected error while processing request. |  -  |
| **503** | Service is unhealthy. |  -  |

