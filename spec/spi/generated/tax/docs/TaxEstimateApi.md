# TaxEstimateApi

All URIs are relative to *https://rest.taxes.provider.com/api/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**estimateTaxes**](TaxEstimateApi.md#estimateTaxes) | **POST** /tax-estimate | Estimate tax |


<a id="estimateTaxes"></a>
# **estimateTaxes**
> TaxEstimationResponse estimateTaxes(taxEstimationRequest)

Estimate tax

This endpoint is used to estimate taxes for a set of line items being sold by the Merchant to a Customer.

### Example
```java
// Import classes:
import org.chargebee.spi.tax.client.ApiClient;
import org.chargebee.spi.tax.client.ApiException;
import org.chargebee.spi.tax.client.Configuration;
import org.chargebee.spi.tax.client.auth.*;
import org.chargebee.spi.tax.client.models.*;
import org.chargebee.spi.tax.api.TaxEstimateApi;

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

    TaxEstimateApi apiInstance = new TaxEstimateApi(defaultClient);
    TaxEstimationRequest taxEstimationRequest = new TaxEstimationRequest(); // TaxEstimationRequest | 
    try {
      TaxEstimationResponse result = apiInstance.estimateTaxes(taxEstimationRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TaxEstimateApi#estimateTaxes");
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
| **taxEstimationRequest** | [**TaxEstimationRequest**](TaxEstimationRequest.md)|  | [optional] |

### Return type

[**TaxEstimationResponse**](TaxEstimationResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Tax estimated successfully for given line items. |  -  |
| **400** | Bad request. |  -  |
| **401** | Unauthenticated request. |  -  |
| **403** | Unauthorized request. |  -  |
| **404** | Not found. |  -  |
| **429** | Too many requests. |  -  |
| **500** | Unexpected error while processing request. |  -  |
| **503** | Service is unhealthy. |  -  |

