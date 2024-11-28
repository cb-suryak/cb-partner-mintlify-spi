# LocationValidateApi

All URIs are relative to *https://rest.taxes.provider.com/api/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**locationValidate**](LocationValidateApi.md#locationValidate) | **POST** /validate-location | Validate the location of customer with given evidences |


<a id="locationValidate"></a>
# **locationValidate**
> LocationValidateResponse locationValidate(locationValidationEvidence)

Validate the location of customer with given evidences

This endpoint validates the location of a customer using the evidences like ip, bin, address, etc. to determine if a customer is taxable or not.

### Example
```java
// Import classes:
import org.chargebee.spi.location_validation.client.ApiClient;
import org.chargebee.spi.location_validation.client.ApiException;
import org.chargebee.spi.location_validation.client.Configuration;
import org.chargebee.spi.location_validation.client.auth.*;
import org.chargebee.spi.location_validation.client.models.*;
import org.chargebee.spi.location_validation.api.LocationValidateApi;

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

    LocationValidateApi apiInstance = new LocationValidateApi(defaultClient);
    LocationValidationEvidence locationValidationEvidence = new LocationValidationEvidence(); // LocationValidationEvidence | 
    try {
      LocationValidateResponse result = apiInstance.locationValidate(locationValidationEvidence);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling LocationValidateApi#locationValidate");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **locationValidationEvidence** | [**LocationValidationEvidence**](LocationValidationEvidence.md)|  | [optional] |

### Return type

[**LocationValidateResponse**](LocationValidateResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Response to validate the location submitted successfully. |  -  |
| **400** | Bad request. |  -  |
| **401** | Unauthenticated request. |  -  |
| **403** | Unauthorized request. |  -  |
| **429** | Too many requests. |  -  |
| **500** | Unexpected error while processing request. |  -  |
| **503** | Service is unhealthy. |  -  |

