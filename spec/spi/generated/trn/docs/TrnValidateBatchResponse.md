

# TrnValidateBatchResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**batchId** | **String** | Id of the batch request. |  |
|**batchName** | **String** | Name of the batch request. |  [optional] |
|**status** | **Status** |  |  |
|**limit** | **Integer** | Use for the pagination for batch request, limit indicates the maximum number of records to be returned in the response. |  |
|**offset** | **Integer** | Use for the pagination for batch request, offset indicates the starting point of records to be returned in the response. |  |
|**completionPercentage** | **Integer** | Percentage of batch request processing. |  [optional] |
|**externalId** | **String** | The externalId passed in request. |  [optional] |
|**trns** | [**List&lt;TrnValidateResponse&gt;**](TrnValidateResponse.md) | List of tax registration numbers |  |



