# DocumentCategoriesApi

All URIs are relative to *https://api-test.interhyp.de/submission*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getDocumentCategories**](DocumentCategoriesApi.md#getDocumentCategories) | **GET** /v2/documents/categories | Delievers document categories


<a name="getDocumentCategories"></a>
# **getDocumentCategories**
> DocumentCategoriesDefinition getDocumentCategories(categoryName)

Delievers document categories

Retrieve information about possible document categories associated with submission process.

### Example
```java
// Import classes:
import de.interhyp.submission.v2.ApiClient;
import de.interhyp.submission.v2.ApiException;
import de.interhyp.submission.v2.Configuration;
import de.interhyp.submission.v2.auth.*;
import de.interhyp.submission.v2.models.*;
import de.interhyp.submission.v2.api.DocumentCategoriesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api-test.interhyp.de/submission");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    DocumentCategoriesApi apiInstance = new DocumentCategoriesApi(defaultClient);
    String categoryName = "categoryName_example"; // String | query parameter to filter the selected documents based on the provided category.
    try {
      DocumentCategoriesDefinition result = apiInstance.getDocumentCategories(categoryName);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DocumentCategoriesApi#getDocumentCategories");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **categoryName** | **String**| query parameter to filter the selected documents based on the provided category. | [optional]

### Return type

[**DocumentCategoriesDefinition**](DocumentCategoriesDefinition.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Document categories associated with submission process are returned |  -  |
**400** | Error indicates missing or wrong request parameters. |  -  |
**401** | Error indicates no access to the required resource. |  -  |
**500** | Unexpected error |  -  |

