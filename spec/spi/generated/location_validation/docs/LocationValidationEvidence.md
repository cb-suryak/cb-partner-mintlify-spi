

# LocationValidationEvidence

Contains the required properties for location validation response

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Name of the customer. |  [optional] |
|**customerCode** | **String** | Chargebee customer code. |  |
|**taxRegistrationNumber** | **String** | Tax registration number of the customer. |  [optional] |
|**ip** | **String** | IP address of the customer. |  [optional] |
|**bin** | **String** | BIN of primary card. |  [optional] |
|**phone** | **String** | Phone number of the customer. |  [optional] |
|**address** | [**Address**](Address.md) |  |  |
|**taxIdentifiers** | [**List&lt;FieldItem&gt;**](FieldItem.md) | The tax code fields of the product used for tax calculation. |  [optional] |



