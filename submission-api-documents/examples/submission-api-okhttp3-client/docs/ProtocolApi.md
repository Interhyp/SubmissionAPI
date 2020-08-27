# ProtocolApi

All URIs are relative to *https://api-test.interhyp.de/submission*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getProtocolBySubmissionId**](ProtocolApi.md#getProtocolBySubmissionId) | **GET** /v2/submissions/{submissionId}/protocol | Get protocol for a specific submission
[**getSubmissionsProtocol**](ProtocolApi.md#getSubmissionsProtocol) | **GET** /v2/submissions/protocol | Delivers all submissions protocol for a provider


<a name="getProtocolBySubmissionId"></a>
# **getProtocolBySubmissionId**
> Protocol getProtocolBySubmissionId(submissionId, protocolType, sort)

Get protocol for a specific submission

Delivers detailed information about protocol associated with a specific submission. By default the result will be sorted based on createdAt ascending.

### Example
```java
// Import classes:
import de.interhyp.submission.v2.ApiClient;
import de.interhyp.submission.v2.ApiException;
import de.interhyp.submission.v2.Configuration;
import de.interhyp.submission.v2.auth.*;
import de.interhyp.submission.v2.models.*;
import de.interhyp.submission.v2.api.ProtocolApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api-test.interhyp.de/submission");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    ProtocolApi apiInstance = new ProtocolApi(defaultClient);
    String submissionId = "submissionId_example"; // String | Id for the requested submission.
    String protocolType = "protocolType_example"; // String | query parameter to restrict submissions associated to the provided protocol type.
    List<String> sort = sort=+createdAt; // List<String> | Comma-separated list of fields to define the sort order.<br> To indicate sorting direction, fields may be prefixed with `+` ascending or `-` descending. <br> **e.g.** /protocol?sort=+createdAt <br> ***Note*** sorting applies only within a single result page when multiple pages are returned. <br>
    try {
      Protocol result = apiInstance.getProtocolBySubmissionId(submissionId, protocolType, sort);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProtocolApi#getProtocolBySubmissionId");
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
 **protocolType** | **String**| query parameter to restrict submissions associated to the provided protocol type. | [optional] [enum: document, data, status, new_submission]
 **sort** | [**List&lt;String&gt;**](String.md)| Comma-separated list of fields to define the sort order.&lt;br&gt; To indicate sorting direction, fields may be prefixed with &#x60;+&#x60; ascending or &#x60;-&#x60; descending. &lt;br&gt; **e.g.** /protocol?sort&#x3D;+createdAt &lt;br&gt; ***Note*** sorting applies only within a single result page when multiple pages are returned. &lt;br&gt; | [optional] [enum: +createdAt, -createdAt]

### Return type

[**Protocol**](Protocol.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Submission protocol are returned |  -  |
**400** | Error indicates missing or wrong request parameters. |  -  |
**401** | Error indicates no access to the required resource. |  -  |
**404** | Error indicates that a requested submission resource was not found. |  -  |
**500** | Unexpected Error |  -  |

<a name="getSubmissionsProtocol"></a>
# **getSubmissionsProtocol**
> SubmissionProtocol getSubmissionsProtocol(since, until, protocolType, limit, after, before, embed)

Delivers all submissions protocol for a provider

Delivers a collection of submission protocol for a specific provider filtered by the date of protocol.&lt;p&gt; *By Default*, we will return the first *20* matching records. However, this is not a hard limitation! a parameter called &#x60;limit&#x60; can be used to tell the API how many records you want to return all at once *(max 40)*.&lt;p&gt; To get further matching records, a parameter called &#x60;after&#x60; or &#x60;before&#x60; can be used to tell the API the start of each page using specified cursor.&lt;p&gt; To navigate through the query result, a reference to the following navigations are included in the response *(next, prev, first, last, self)*.

### Example
```java
// Import classes:
import de.interhyp.submission.v2.ApiClient;
import de.interhyp.submission.v2.ApiException;
import de.interhyp.submission.v2.Configuration;
import de.interhyp.submission.v2.auth.*;
import de.interhyp.submission.v2.models.*;
import de.interhyp.submission.v2.api.ProtocolApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api-test.interhyp.de/submission");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    ProtocolApi apiInstance = new ProtocolApi(defaultClient);
    OffsetDateTime since = 2019-12-29T10:22:50Z; // OffsetDateTime | A UTC date-time value that points to the start of the range of time-based data. <br> Defined by date-time - [RFC3339](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14).
    OffsetDateTime until = 2019-12-29T10:22:50Z; // OffsetDateTime | A UTC date-time value that points to the end of the range of time-based data. <br> If not provided, current date-time is used. Defined by date-time - [RFC3339](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14).
    String protocolType = "protocolType_example"; // String | query parameter to restrict submissions associated to the provided protocol type.
    Integer limit = 20; // Integer | Specifies how many items to return at one time (max 40). <br> A query may return fewer than the value of limit due to filtering.
    String after = "after_example"; // String | Cursor that points to the end of the page of data that has been returned.
    String before = "before_example"; // String | Cursor that points to the start of the page of data that has been returned.
    Boolean embed = true; // Boolean | Flag to expand or embed sub-resources in the response resource.<br> By default is set to `FALSE` where only a **ref** to the sub-resources will be returned.<br> By set it to `TRUE` the sub-resources content will be embedded in the response which might affect the payload size
    try {
      SubmissionProtocol result = apiInstance.getSubmissionsProtocol(since, until, protocolType, limit, after, before, embed);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProtocolApi#getSubmissionsProtocol");
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
 **since** | **OffsetDateTime**| A UTC date-time value that points to the start of the range of time-based data. &lt;br&gt; Defined by date-time - [RFC3339](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14). |
 **until** | **OffsetDateTime**| A UTC date-time value that points to the end of the range of time-based data. &lt;br&gt; If not provided, current date-time is used. Defined by date-time - [RFC3339](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14). | [optional]
 **protocolType** | **String**| query parameter to restrict submissions associated to the provided protocol type. | [optional] [enum: document, data, status, new_submission]
 **limit** | **Integer**| Specifies how many items to return at one time (max 40). &lt;br&gt; A query may return fewer than the value of limit due to filtering. | [optional] [default to 20]
 **after** | **String**| Cursor that points to the end of the page of data that has been returned. | [optional]
 **before** | **String**| Cursor that points to the start of the page of data that has been returned. | [optional]
 **embed** | **Boolean**| Flag to expand or embed sub-resources in the response resource.&lt;br&gt; By default is set to &#x60;FALSE&#x60; where only a **ref** to the sub-resources will be returned.&lt;br&gt; By set it to &#x60;TRUE&#x60; the sub-resources content will be embedded in the response which might affect the payload size | [optional]

### Return type

[**SubmissionProtocol**](SubmissionProtocol.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | A paged array of submissions protocol |  -  |
**400** | Error indicates missing or wrong request parameters. |  -  |
**401** | Error indicates no access to the required resource. |  -  |
**500** | Unexpected error |  -  |

