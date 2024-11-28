

# TrnValidateResponse

Contains the required properties for tax registration number validation response

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**requestId** | **String** | Unique id of the request, this is to refer later to fetch the response. |  [optional] |
|**trn** | **String** | Tax registration number |  |
|**country** | [**Country**](Country.md) |  |  |
|**name** | **String** | Name of the entity(may be an individual or a business company) who owns the tax registration number |  [optional] |
|**address** | **String** | Address of the entity(may be an individual or a business company) who owns the tax registration number |  [optional] |
|**trnStatus** | **TrnStatus** |  |  [optional] |
|**isBusiness** | **Boolean** | Indicates that tax registration number belong to a business entity or not. |  [optional] |
|**isRegistered** | **Boolean** | Indicates that tax registration number is registered or not |  [optional] |
|**businessStatus** | **BusinessStatus** |  |  [optional] |
|**validationDataSource** | **String** | Indicates name of the source of tax registration number validation (like database, vies) |  [optional] |
|**externalId** | **String** | The externalId passed in the request |  [optional] |
|**message** | **String** | Any message about tax registration number validation request |  [optional] |



