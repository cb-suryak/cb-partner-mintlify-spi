# TrnValidateApi

All URIs are relative to *https://rest.taxes.provider.com/api/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**deleteTrnValidateBatch**](TrnValidateApi.md#deleteTrnValidateBatch) | **DELETE** /trn/validate/batch/{batchId} | Delete the request of batch of tax registration numbers validation |
| [**fetchTrnValidate**](TrnValidateApi.md#fetchTrnValidate) | **GET** /trn/validate/{requestId} | Get the response of tax registration number validate request |
| [**fetchTrnValidateBatch**](TrnValidateApi.md#fetchTrnValidateBatch) | **GET** /trn/validate/batch/{batchId} | Get the response of batch of tax registration numbers |
| [**trnValidate**](TrnValidateApi.md#trnValidate) | **POST** /trn/validate | Validate the tax registration number |
| [**trnValidateBatch**](TrnValidateApi.md#trnValidateBatch) | **POST** /trn/validate/batch | Validate the tax registration numbers in batch |


<a id="deleteTrnValidateBatch"></a>
# **deleteTrnValidateBatch**
> TrnValidateBatchDeleteResponse deleteTrnValidateBatch(batchId)

Delete the request of batch of tax registration numbers validation

This endpoint takes the batch id and delete the running batch of tax registration numbers validation request at server side.

### Example
```java
// Import classes:
import org.chargebee.spi.trn.client.ApiClient;
import org.chargebee.spi.trn.client.ApiException;
import org.chargebee.spi.trn.client.Configuration;
import org.chargebee.spi.trn.client.auth.*;
import org.chargebee.spi.trn.client.models.*;
import org.chargebee.spi.trn.api.TrnValidateApi;

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

    TrnValidateApi apiInstance = new TrnValidateApi(defaultClient);
    String batchId = "batchId_example"; // String | The unique batch request identifier.
    try {
      TrnValidateBatchDeleteResponse result = apiInstance.deleteTrnValidateBatch(batchId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TrnValidateApi#deleteTrnValidateBatch");
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
| **batchId** | **String**| The unique batch request identifier. | |

### Return type

[**TrnValidateBatchDeleteResponse**](TrnValidateBatchDeleteResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully deleted the request of batch of tax registration numbers validation. |  -  |
| **401** | Unauthenticated request. |  -  |
| **403** | Unauthorized request. |  -  |
| **404** | Not found. |  -  |
| **429** | Too many requests. |  -  |
| **500** | Unexpected error while processing request. |  -  |
| **503** | Service is unhealthy. |  -  |

<a id="fetchTrnValidate"></a>
# **fetchTrnValidate**
> TrnValidateResponse fetchTrnValidate(requestId)

Get the response of tax registration number validate request

This endpoint takes the request id and returns the response of the tax registration number

### Example
```java
// Import classes:
import org.chargebee.spi.trn.client.ApiClient;
import org.chargebee.spi.trn.client.ApiException;
import org.chargebee.spi.trn.client.Configuration;
import org.chargebee.spi.trn.client.auth.*;
import org.chargebee.spi.trn.client.models.*;
import org.chargebee.spi.trn.api.TrnValidateApi;

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

    TrnValidateApi apiInstance = new TrnValidateApi(defaultClient);
    String requestId = "requestId_example"; // String | The unique request identifier.
    try {
      TrnValidateResponse result = apiInstance.fetchTrnValidate(requestId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TrnValidateApi#fetchTrnValidate");
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
| **requestId** | **String**| The unique request identifier. | |

### Return type

[**TrnValidateResponse**](TrnValidateResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Response of tax registration number validation. |  -  |
| **401** | Unauthenticated request. |  -  |
| **403** | Unauthorized request. |  -  |
| **404** | Not found. |  -  |
| **429** | Too many requests. |  -  |
| **500** | Unexpected error while processing request. |  -  |
| **503** | Service is unhealthy. |  -  |

<a id="fetchTrnValidateBatch"></a>
# **fetchTrnValidateBatch**
> TrnValidateBatchResponse fetchTrnValidateBatch(batchId, offset, limit)

Get the response of batch of tax registration numbers

This endpoint takes the batch id and returns the response of batch of tax registration numbers.

### Example
```java
// Import classes:
import org.chargebee.spi.trn.client.ApiClient;
import org.chargebee.spi.trn.client.ApiException;
import org.chargebee.spi.trn.client.Configuration;
import org.chargebee.spi.trn.client.auth.*;
import org.chargebee.spi.trn.client.models.*;
import org.chargebee.spi.trn.api.TrnValidateApi;

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

    TrnValidateApi apiInstance = new TrnValidateApi(defaultClient);
    String batchId = "batchId_example"; // String | The unique batch request identifier.
    Integer offset = 0; // Integer | The starting index of records to be returned.
    Integer limit = 100; // Integer | The limit number of records to be returned.
    try {
      TrnValidateBatchResponse result = apiInstance.fetchTrnValidateBatch(batchId, offset, limit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TrnValidateApi#fetchTrnValidateBatch");
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
| **batchId** | **String**| The unique batch request identifier. | |
| **offset** | **Integer**| The starting index of records to be returned. | [default to 0] |
| **limit** | **Integer**| The limit number of records to be returned. | [default to 100] |

### Return type

[**TrnValidateBatchResponse**](TrnValidateBatchResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Response of the batch of tax registration numbers validation. |  -  |
| **401** | Unauthenticated request. |  -  |
| **403** | Unauthorized request. |  -  |
| **404** | Not found. |  -  |
| **429** | Too many requests. |  -  |
| **500** | Unexpected error while processing request. |  -  |
| **503** | Service is unhealthy. |  -  |

<a id="trnValidate"></a>
# **trnValidate**
> TrnValidateResponse trnValidate(trnValidateRequest)

Validate the tax registration number

This endpoint takes the details of tax registration number and validate.

### Example
```java
// Import classes:
import org.chargebee.spi.trn.client.ApiClient;
import org.chargebee.spi.trn.client.ApiException;
import org.chargebee.spi.trn.client.Configuration;
import org.chargebee.spi.trn.client.auth.*;
import org.chargebee.spi.trn.client.models.*;
import org.chargebee.spi.trn.api.TrnValidateApi;

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

    TrnValidateApi apiInstance = new TrnValidateApi(defaultClient);
    TrnValidateRequest trnValidateRequest = new TrnValidateRequest(); // TrnValidateRequest | 
    try {
      TrnValidateResponse result = apiInstance.trnValidate(trnValidateRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TrnValidateApi#trnValidate");
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
| **trnValidateRequest** | [**TrnValidateRequest**](TrnValidateRequest.md)|  | [optional] |

### Return type

[**TrnValidateResponse**](TrnValidateResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Request to validate the tax registration number submitted successfully. |  -  |
| **400** | Bad request. |  -  |
| **401** | Unauthenticated request. |  -  |
| **403** | Unauthorized request. |  -  |
| **429** | Too many requests. |  -  |
| **500** | Unexpected error while processing request. |  -  |
| **503** | Service is unhealthy. |  -  |

<a id="trnValidateBatch"></a>
# **trnValidateBatch**
> TrnValidateBatchResponse trnValidateBatch(trnValidateBatchRequest)

Validate the tax registration numbers in batch

This endpoint takes the batch of tax registration numbers and validate.

### Example
```java
// Import classes:
import org.chargebee.spi.trn.client.ApiClient;
import org.chargebee.spi.trn.client.ApiException;
import org.chargebee.spi.trn.client.Configuration;
import org.chargebee.spi.trn.client.auth.*;
import org.chargebee.spi.trn.client.models.*;
import org.chargebee.spi.trn.api.TrnValidateApi;

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

    TrnValidateApi apiInstance = new TrnValidateApi(defaultClient);
    TrnValidateBatchRequest trnValidateBatchRequest = new TrnValidateBatchRequest(); // TrnValidateBatchRequest | 
    try {
      TrnValidateBatchResponse result = apiInstance.trnValidateBatch(trnValidateBatchRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TrnValidateApi#trnValidateBatch");
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
| **trnValidateBatchRequest** | [**TrnValidateBatchRequest**](TrnValidateBatchRequest.md)|  | [optional] |

### Return type

[**TrnValidateBatchResponse**](TrnValidateBatchResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Request to validate the batch of tax registration numbers being processed. |  -  |
| **400** | Bad request. |  -  |
| **401** | Unauthenticated request. |  -  |
| **403** | Unauthorized request. |  -  |
| **429** | Too many requests. |  -  |
| **500** | Unexpected error while processing request. |  -  |
| **503** | Service is unhealthy. |  -  |

