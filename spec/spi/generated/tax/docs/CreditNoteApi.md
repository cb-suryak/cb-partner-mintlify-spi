# CreditNoteApi

All URIs are relative to *https://rest.taxes.provider.com/api/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**commitCreditNote**](CreditNoteApi.md#commitCreditNote) | **POST** /credit-notes/{creditNoteId}/commit | Commit credit note |
| [**createCreditNote**](CreditNoteApi.md#createCreditNote) | **POST** /credit-notes | Create credit note |
| [**fetchCreditNote**](CreditNoteApi.md#fetchCreditNote) | **GET** /credit-notes/{creditNoteId} | Retrieve credit note |
| [**voidCreditNote**](CreditNoteApi.md#voidCreditNote) | **POST** /credit-notes/{creditNoteId}/void | Void credit note |


<a id="commitCreditNote"></a>
# **commitCreditNote**
> commitCreditNote(creditNoteId, invoiceId)

Commit credit note

This endpoint is used to mark a credit note as committed. Once committed, the credit note is considered as finalized.

### Example
```java
// Import classes:
import org.chargebee.spi.tax.client.ApiClient;
import org.chargebee.spi.tax.client.ApiException;
import org.chargebee.spi.tax.client.Configuration;
import org.chargebee.spi.tax.client.auth.*;
import org.chargebee.spi.tax.client.models.*;
import org.chargebee.spi.tax.api.CreditNoteApi;

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

    CreditNoteApi apiInstance = new CreditNoteApi(defaultClient);
    String creditNoteId = "creditNoteId_example"; // String | The unique identifier of the credit note at the Tax Service Adapter or Tax Service Provider.
    String invoiceId = "invoiceId_example"; // String | The unique identifier of the invoice at the Tax Service Adapter or Tax Service Provider.
    try {
      apiInstance.commitCreditNote(creditNoteId, invoiceId);
    } catch (ApiException e) {
      System.err.println("Exception when calling CreditNoteApi#commitCreditNote");
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
| **creditNoteId** | **String**| The unique identifier of the credit note at the Tax Service Adapter or Tax Service Provider. | |
| **invoiceId** | **String**| The unique identifier of the invoice at the Tax Service Adapter or Tax Service Provider. | [optional] |

### Return type

null (empty response body)

### Authorization

[apiKey](../README.md#apiKey), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Credit note committed successfully. |  -  |
| **401** | Unauthenticated request. |  -  |
| **403** | Unauthorized request. |  -  |
| **404** | Not found. |  -  |
| **429** | Too many requests. |  -  |
| **500** | Unexpected error while processing request. |  -  |
| **503** | Service is unhealthy. |  -  |

<a id="createCreditNote"></a>
# **createCreditNote**
> CreditNote createCreditNote(creditNoteRequest)

Create credit note

This endpoint is used to send a credit note to the Tax Service Adapter. A credit note is used to reduce the amount due on an invoice. If the credit note is issued after payments have been made for the invoice, refunds can be issued to the Customer.

### Example
```java
// Import classes:
import org.chargebee.spi.tax.client.ApiClient;
import org.chargebee.spi.tax.client.ApiException;
import org.chargebee.spi.tax.client.Configuration;
import org.chargebee.spi.tax.client.auth.*;
import org.chargebee.spi.tax.client.models.*;
import org.chargebee.spi.tax.api.CreditNoteApi;

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

    CreditNoteApi apiInstance = new CreditNoteApi(defaultClient);
    CreditNoteRequest creditNoteRequest = new CreditNoteRequest(); // CreditNoteRequest | 
    try {
      CreditNote result = apiInstance.createCreditNote(creditNoteRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CreditNoteApi#createCreditNote");
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
| **creditNoteRequest** | [**CreditNoteRequest**](CreditNoteRequest.md)|  | [optional] |

### Return type

[**CreditNote**](CreditNote.md)

### Authorization

[apiKey](../README.md#apiKey), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Credit note created successfully. |  -  |
| **400** | Bad request. |  -  |
| **401** | Unauthenticated request. |  -  |
| **403** | Unauthorized request. |  -  |
| **429** | Too many requests. |  -  |
| **500** | Unexpected error while processing request. |  -  |
| **503** | Service is unhealthy. |  -  |

<a id="fetchCreditNote"></a>
# **fetchCreditNote**
> CreditNote fetchCreditNote(creditNoteId, invoiceId)

Retrieve credit note

This endpoint is used to retrieve a specific credit note using the unique credit note id.

### Example
```java
// Import classes:
import org.chargebee.spi.tax.client.ApiClient;
import org.chargebee.spi.tax.client.ApiException;
import org.chargebee.spi.tax.client.Configuration;
import org.chargebee.spi.tax.client.auth.*;
import org.chargebee.spi.tax.client.models.*;
import org.chargebee.spi.tax.api.CreditNoteApi;

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

    CreditNoteApi apiInstance = new CreditNoteApi(defaultClient);
    String creditNoteId = "creditNoteId_example"; // String | The unique identifier of the credit note at the Tax Service Adapter or Tax Service Provider.
    String invoiceId = "invoiceId_example"; // String | The unique identifier of the invoice at the Tax Service Adapter or Tax Service Provider.
    try {
      CreditNote result = apiInstance.fetchCreditNote(creditNoteId, invoiceId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CreditNoteApi#fetchCreditNote");
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
| **creditNoteId** | **String**| The unique identifier of the credit note at the Tax Service Adapter or Tax Service Provider. | |
| **invoiceId** | **String**| The unique identifier of the invoice at the Tax Service Adapter or Tax Service Provider. | [optional] |

### Return type

[**CreditNote**](CreditNote.md)

### Authorization

[apiKey](../README.md#apiKey), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Credit note retrieved successfully. |  -  |
| **401** | Unauthenticated request. |  -  |
| **403** | Unauthorized request. |  -  |
| **404** | Not found. |  -  |
| **429** | Too many requests. |  -  |
| **500** | Unexpected error while processing request. |  -  |
| **503** | Service is unhealthy. |  -  |

<a id="voidCreditNote"></a>
# **voidCreditNote**
> voidCreditNote(creditNoteId, invoiceId)

Void credit note

This endpoint is used to void the credit note for a specific credit note id. Voiding reverses the credit note, thereby restoring the amount due on the invoice.

### Example
```java
// Import classes:
import org.chargebee.spi.tax.client.ApiClient;
import org.chargebee.spi.tax.client.ApiException;
import org.chargebee.spi.tax.client.Configuration;
import org.chargebee.spi.tax.client.auth.*;
import org.chargebee.spi.tax.client.models.*;
import org.chargebee.spi.tax.api.CreditNoteApi;

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

    CreditNoteApi apiInstance = new CreditNoteApi(defaultClient);
    String creditNoteId = "creditNoteId_example"; // String | The unique identifier of the credit note at the Tax Service Adapter or Tax Service Provider.
    String invoiceId = "invoiceId_example"; // String | The unique identifier of the invoice at the Tax Service Adapter or Tax Service Provider.
    try {
      apiInstance.voidCreditNote(creditNoteId, invoiceId);
    } catch (ApiException e) {
      System.err.println("Exception when calling CreditNoteApi#voidCreditNote");
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
| **creditNoteId** | **String**| The unique identifier of the credit note at the Tax Service Adapter or Tax Service Provider. | |
| **invoiceId** | **String**| The unique identifier of the invoice at the Tax Service Adapter or Tax Service Provider. | [optional] |

### Return type

null (empty response body)

### Authorization

[apiKey](../README.md#apiKey), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Credit note voided successfully. |  -  |
| **401** | Unauthenticated request. |  -  |
| **403** | Unauthorized request. |  -  |
| **404** | Not found. |  -  |
| **429** | Too many requests. |  -  |
| **500** | Unexpected error while processing request. |  -  |
| **503** | Service is unhealthy. |  -  |

