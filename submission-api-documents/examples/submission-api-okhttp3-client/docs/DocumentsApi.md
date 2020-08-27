# DocumentsApi

All URIs are relative to *https://api-test.interhyp.de/submission*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getDocumentBinary**](DocumentsApi.md#getDocumentBinary) | **GET** /v2/submissions/{submissionId}/documents/{documentId}/binaries | Delievers specific submission document in &#x60;pdf&#x60; format
[**getDocumentsBinary**](DocumentsApi.md#getDocumentsBinary) | **GET** /v2/submissions/{submissionId}/documents/binaries | Delievers all submission relevant documents as binary format.
[**getDocumentsMetadata**](DocumentsApi.md#getDocumentsMetadata) | **GET** /v2/submissions/{submissionId}/documents/metadata | Delievers all submission relevant documents metadata


<a name="getDocumentBinary"></a>
# **getDocumentBinary**
> File getDocumentBinary(submissionId, documentId, ifMatch)

Delievers specific submission document in &#x60;pdf&#x60; format

Retrieve specific submission document based on an identifier in &#x60;pdf&#x60; format&lt;p /&gt; Note: retries following a 202 *must* provide the If-Match header.

### Example
```java
// Import classes:
import de.interhyp.submission.v2.ApiClient;
import de.interhyp.submission.v2.ApiException;
import de.interhyp.submission.v2.Configuration;
import de.interhyp.submission.v2.auth.*;
import de.interhyp.submission.v2.models.*;
import de.interhyp.submission.v2.api.DocumentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api-test.interhyp.de/submission");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    DocumentsApi apiInstance = new DocumentsApi(defaultClient);
    String submissionId = "submissionId_example"; // String | Id for the requested submission.
    String documentId = "documentId_example"; // String | Id for the requested submission document.
    String ifMatch = "ifMatch_example"; // String | 
    try {
      File result = apiInstance.getDocumentBinary(submissionId, documentId, ifMatch);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DocumentsApi#getDocumentBinary");
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
 **submissionId** | **String**| Id for the requested submission. |
 **documentId** | **String**| Id for the requested submission document. |
 **ifMatch** | **String**|  | [optional]

### Return type

[**File**](File.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/pdf, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Requested submission document is returned |  -  |
**202** | Payload is being prepared, try again later |  * ETag - unique ID of payload creation request; use as If-Match in subsequent calls to retrieve payload <br>  * Retry-After - payload is expected to be ready after the specified amout of seconds <br>  |
**400** | Error indicates missing or wrong request parameters. |  -  |
**401** | Error indicates no access to the required resource. |  -  |
**404** | Error indicates that a requested resource was not found. |  -  |
**409** | Error indicates the document has a stale state. Maybe the document was modified or deleted. Please refresh the documents metadata of the submission. |  -  |
**500** | Unexpected error |  -  |

<a name="getDocumentsBinary"></a>
# **getDocumentsBinary**
> File getDocumentsBinary(submissionId, ifMatch, categoryName)

Delievers all submission relevant documents as binary format.

Retrieve all submission relevant documents in the requested format. &lt;p /&gt; *PossibleTypes* are &#x60;PDF&#x60; and &#x60;ZIP&#x60;&lt;p /&gt; Note: retries following a 202 *must* provide the If-Match header.

### Example
```java
// Import classes:
import de.interhyp.submission.v2.ApiClient;
import de.interhyp.submission.v2.ApiException;
import de.interhyp.submission.v2.Configuration;
import de.interhyp.submission.v2.auth.*;
import de.interhyp.submission.v2.models.*;
import de.interhyp.submission.v2.api.DocumentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api-test.interhyp.de/submission");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    DocumentsApi apiInstance = new DocumentsApi(defaultClient);
    String submissionId = "submissionId_example"; // String | Id for the requested submission.
    String ifMatch = "ifMatch_example"; // String | 
    String categoryName = "categoryName_example"; // String | query parameter to filter the selected documents based on the provided category.
    try {
      File result = apiInstance.getDocumentsBinary(submissionId, ifMatch, categoryName);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DocumentsApi#getDocumentsBinary");
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
 **submissionId** | **String**| Id for the requested submission. |
 **ifMatch** | **String**|  | [optional]
 **categoryName** | **String**| query parameter to filter the selected documents based on the provided category. | [optional]

### Return type

[**File**](File.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/pdf, application/zip, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Submission documents matching provided criteria in the requested format |  -  |
**202** | Payload is being prepared, try again later |  * ETag - unique ID of payload creation request; use as If-Match in subsequent calls to retrieve payload <br>  * Retry-After - payload is expected to be ready after the specified amout of seconds <br>  |
**400** | Error indicates missing or wrong request parameters. |  -  |
**401** | Error indicates no access to the required resource. |  -  |
**404** | Error indicates that a requested submission resource was not found. |  -  |
**500** | Unexpected error |  -  |

<a name="getDocumentsMetadata"></a>
# **getDocumentsMetadata**
> Documents getDocumentsMetadata(submissionId, embed)

Delievers all submission relevant documents metadata

Retrieve all submission relevant documents in the requested format. &lt;p&gt;

### Example
```java
// Import classes:
import de.interhyp.submission.v2.ApiClient;
import de.interhyp.submission.v2.ApiException;
import de.interhyp.submission.v2.Configuration;
import de.interhyp.submission.v2.auth.*;
import de.interhyp.submission.v2.models.*;
import de.interhyp.submission.v2.api.DocumentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api-test.interhyp.de/submission");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    DocumentsApi apiInstance = new DocumentsApi(defaultClient);
    String submissionId = "submissionId_example"; // String | Id for the requested submission.
    Boolean embed = true; // Boolean | Flag to expand or embed sub-resources in the response resource.<br> By default is set to `FALSE` where only a **ref** to the sub-resources will be returned.<br> By set it to `TRUE` the sub-resources content will be embedded in the response which might affect the payload size
    try {
      Documents result = apiInstance.getDocumentsMetadata(submissionId, embed);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DocumentsApi#getDocumentsMetadata");
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
 **submissionId** | **String**| Id for the requested submission. |
 **embed** | **Boolean**| Flag to expand or embed sub-resources in the response resource.&lt;br&gt; By default is set to &#x60;FALSE&#x60; where only a **ref** to the sub-resources will be returned.&lt;br&gt; By set it to &#x60;TRUE&#x60; the sub-resources content will be embedded in the response which might affect the payload size | [optional]

### Return type

[**Documents**](Documents.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Submission documents matching provided criteria in the requested format |  -  |
**202** | Documents metadata are being prepared, try again later, please refer to Retry-After Header |  * Retry-After - metadata is expected to be ready after the specified amout of seconds <br>  |
**400** | Error indicates missing or wrong request parameters. |  -  |
**401** | Error indicates no access to the required resource. |  -  |
**404** | Error indicates that a requested submission resource was not found. |  -  |
**500** | Unexpected error |  -  |

