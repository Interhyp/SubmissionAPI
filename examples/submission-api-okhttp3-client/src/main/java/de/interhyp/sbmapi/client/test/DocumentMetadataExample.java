package de.interhyp.sbmapi.client.test;

import de.interhyp.submission.v2.ApiClient;
import de.interhyp.submission.v2.ApiException;
import de.interhyp.submission.v2.Configuration;
import de.interhyp.submission.v2.api.DocumentsApi;
import de.interhyp.submission.v2.model.Documents;

public class DocumentMetadataExample {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8089");

        // Configure HTTP bearer authorization: BearerAuth
        // HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
        //  BearerAuth.setBearerToken("BEARER TOKEN");

        DocumentsApi apiInstance = new DocumentsApi(defaultClient);
        String submissionId = "de-0000135-ms5ja4ulz"; // String | Id for the requested submission.
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
