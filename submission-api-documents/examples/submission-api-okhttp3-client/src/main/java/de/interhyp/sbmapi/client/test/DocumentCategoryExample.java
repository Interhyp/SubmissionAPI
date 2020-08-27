package de.interhyp.sbmapi.client.test;

import de.interhyp.submission.v2.ApiClient;
import de.interhyp.submission.v2.ApiException;
import de.interhyp.submission.v2.Configuration;
import de.interhyp.submission.v2.api.DocumentCategoriesApi;
import de.interhyp.submission.v2.model.DocumentCategoriesDefinition;

public class DocumentCategoryExample {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8089");

        // Configure HTTP bearer authorization: BearerAuth
        // HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
        //  BearerAuth.setBearerToken("BEARER TOKEN");

        DocumentCategoriesApi apiInstance = new DocumentCategoriesApi(defaultClient);
        String categoryName = null; // String | query parameter to filter the selected documents based on the provided category.
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
