# SubmissionsApi

All URIs are relative to *https://api-test.interhyp.de/submission*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getHandoverReportByName**](SubmissionsApi.md#getHandoverReportByName) | **GET** /v2/submissions/{submissionId}/handover-reports/{handoverReportName} | Get a specific handover report
[**getHandoverReports**](SubmissionsApi.md#getHandoverReports) | **GET** /v2/submissions/{submissionId}/handover-reports | Get handover reports


<a name="getHandoverReportByName"></a>
# **getHandoverReportByName**
> File getHandoverReportByName(submissionId, handoverReportName)

Get a specific handover report

Delivers detailed information about a specific handover report.

### Example
```java
// Import classes:
import de.interhyp.submission.v2.ApiClient;
import de.interhyp.submission.v2.ApiException;
import de.interhyp.submission.v2.Configuration;
import de.interhyp.submission.v2.auth.*;
import de.interhyp.submission.v2.models.*;
import de.interhyp.submission.v2.api.SubmissionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api-test.interhyp.de/submission");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    SubmissionsApi apiInstance = new SubmissionsApi(defaultClient);
    String submissionId = "submissionId_example"; // String | Id for the requested submission.
    String handoverReportName = "handoverReportName_example"; // String | Name for the requested handover report.
    try {
      File result = apiInstance.getHandoverReportByName(submissionId, handoverReportName);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SubmissionsApi#getHandoverReportByName");
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
 **handoverReportName** | **String**| Name for the requested handover report. |

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
**200** | Requested handover report is returned |  -  |
**400** | Error indicates missing or wrong request parameters. |  -  |
**401** | Error indicates no access to the required resource. |  -  |
**404** | Error indicates that a requested submission resource was not found |  -  |
**500** | Unexpected error |  -  |

<a name="getHandoverReports"></a>
# **getHandoverReports**
> HandoverReports getHandoverReports(submissionId)

Get handover reports

Delivers the handover reports for a specific submission

### Example
```java
// Import classes:
import de.interhyp.submission.v2.ApiClient;
import de.interhyp.submission.v2.ApiException;
import de.interhyp.submission.v2.Configuration;
import de.interhyp.submission.v2.auth.*;
import de.interhyp.submission.v2.models.*;
import de.interhyp.submission.v2.api.SubmissionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api-test.interhyp.de/submission");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    SubmissionsApi apiInstance = new SubmissionsApi(defaultClient);
    String submissionId = "submissionId_example"; // String | Id for the requested submission.
    try {
      HandoverReports result = apiInstance.getHandoverReports(submissionId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SubmissionsApi#getHandoverReports");
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

### Return type

[**HandoverReports**](HandoverReports.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Requested handover reports are returned |  -  |
**202** | Payload is being prepared, try again later |  * Retry-After - payload is expected to be ready after the specified amout of seconds <br>  |
**400** | Error indicates missing or wrong request parameters. |  -  |
**401** | Error indicates no access to the required resource. |  -  |
**404** | Error indicates that a requested submission resource was not found |  -  |
**500** | Unexpected error |  -  |

