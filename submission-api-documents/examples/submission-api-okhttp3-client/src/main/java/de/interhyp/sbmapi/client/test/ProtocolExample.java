package de.interhyp.sbmapi.client.test;

import de.interhyp.submission.v2.ApiClient;
import de.interhyp.submission.v2.ApiException;
import de.interhyp.submission.v2.Configuration;
import de.interhyp.submission.v2.api.ProtocolApi;
import de.interhyp.submission.v2.auth.HttpBearerAuth;
import de.interhyp.submission.v2.model.SubmissionProtocol;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class ProtocolExample {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8089");

        // Configure HTTP bearer authorization: BearerAuth
       // HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
      //  BearerAuth.setBearerToken("BEARER TOKEN");

        ProtocolApi apiInstance = new ProtocolApi(defaultClient);
        OffsetDateTime since = OffsetDateTime.ofInstant(Instant.now().minus(24, ChronoUnit.DAYS), ZoneId.systemDefault()); // OffsetDateTime | A UTC date-time value that points to the start of the range of time-based data. <br> Defined by date-time - [RFC3339](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14).
        OffsetDateTime until = null; // OffsetDateTime | A UTC date-time value that points to the end of the range of time-based data. <br> If not provided, current date-time is used. Defined by date-time - [RFC3339](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14).
        String protocolType = null; // String | query parameter to restrict submissions associated to the provided protocol type.
        Integer limit = 20; // Integer | Specifies how many items to return at one time (max 40). <br> A query may return fewer than the value of limit due to filtering.
        String after = null; // String | Cursor that points to the end of the page of data that has been returned.
        String before = null; // String | Cursor that points to the start of the page of data that has been returned.
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
