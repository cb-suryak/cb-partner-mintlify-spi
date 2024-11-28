

# TrnValidateRequest

Contains the required properties for tax registration number validation request

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**trn** | **String** | Tax registration number |  |
|**country** | [**Country**](Country.md) |  |  |
|**trnType** | **TrnType** |  |  [optional] |
|**name** | **String** | Name of the tag registration number owner |  [optional] |
|**validOn** | **String** | Validate tax registration number on given date |  [optional] |
|**requesterTrn** | **String** | Tax registration number of the entity or person who is requesting validation |  [optional] |
|**taxOfficeCode** | **String** | Code of the tax office, some country need it to validate tax registration number |  [optional] |
|**externalId** | **String** | Way to relate the request and response, if passed then the same value should be returned in response |  [optional] |



