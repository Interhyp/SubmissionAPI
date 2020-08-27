# Submission Management Service Playbook
## Abstract
This document provides needed information that enables the integration with RESTful API and resources provided by Interhyp AG.<p>
The RESTful API provides access to resources associated to submission process via *URI* paths, a client application will make an HTTP request using standard HTTP methods like *GET, PUT, PATCH, POST and DELETE* and parse the response in *JSON* format.<p>
## API Audience 
The API is intended to be consumed by clients who want to integrate Interhyp submission process in their own workflow.
## API Design Principles
During API design a set of principles were taken into consideration.
#### API First
API First is a cornerstone in our design principles, which requires two aspects:
- Define APIs first, before coding its implementation, using a standard specification language. 
- Get early review feedback from peers and client developers

By defining API outside of the code, gives un the following advantages:  
- Clear separation of *What* and *How* concerns through abstraction from implementation aspects.
- Having the client as a primary focus while creating the API.  
- Promotes better understanding of the specified domain and focus only the required functionality.
- Facilitates early client feedback.

#### Mobile First
As Interhyp promotes to Mobile First products, this affects not only the User Interface but API must also reflect this fact during design and implementation phases.

Several techniques are used in conjunction to Mobile First (but not limited to)
- Reducing bandwidth based on client needs
- Optimize network traffic
- Pagination for incremental access of larger collections of data items
- Caching
## API client
As an API client you should adhere to the following robustness principle
- Tolerant Reader; Be tolerant with unknown fields in the payload. This is required to avoid new API versions if new fields 
were added, *i.e.* ignore new fields but do not eliminate them from payload if needed for subsequent *PUT* requests
- Be prepared to handle HTTP status codes not explicitly specified in endpoint definitions.
## Version and URI
This documentation is for **version 2** of submission REST API, which is the latest version.<p>
The URIs for resources have the following structure:
```
https://<interhyp-url>/submission/v2/<resource-name> 
```  
For Example
```
https://api-test.interhyp.de/submission/v2/documents/categories
```

## Security
### Authentication
In order to grant access to the API resources, every client has to declare his identity using a `JWT` based Token.

`OAuth 2.0` is used to secure all the API endpoints, See [Authentication Concept](docs/partners_authentication.pdf) for more details.
### Authorization and Permissions
Access to the API resources is restricted to the target client, where a client may access only the resources that belong to him.
Resources belonging to a specific client are by no mean accessible by any other client with different identity. 

![API Authentication and Authorization](docs/sbm-api-security-diagram.png "API Authentication and Authorization")  

## Pagination, Expansion, and Deferred Processing
Promoting Mobile First design principle requires employing a set of concepts as described below     
### Pagination
This API uses *Cursor-based* pagination to improve performance and minimize networks traffic, Pagination is enforced for operations that potentially could return a large collection of items.
When a client makes a request to a paginated resource, the response wraps the returned array of values in a JSON object with paging metadata. For example:
```json
{
  "data": [
    "_comment: here goes the actual resource collection ..."
  ],
  "paging": {
    "cursor": {
      "before": "string",
      "after": "string"
    },
    "previous": "string",
    "next": "string",
    "first": "string",
    "last": "string",
    "self": "string"
  }
}
```
A cursor refers to a random string of characters which marks a specific item in a collection of data. <p>
The cursor will always point to the item, however it will be invalidated if the item is deleted or removed. 
> Therefore, as a client you shouldn't store cursors or assume that they will be valid in the future.

A cursor-paginated resource supports the following parameters:
* **_before_** : This is the cursor that points to the start of the page of data that has been returned.
* **_after_** : This is the cursor that points to the end of the page of data that has been returned.
* **_limit_** : This is the maximum number of objects that may be returned. A query may return fewer than the value of limit due to filtering. Do not depend on the number of results being fewer than the limit value to indicate that your query reached the end of the list of data, use the absence of `next` instead as described below.
* **_previous_** : A Hyperlink that will return the previous page of data. If not included, this is the first page of data.
* **_next_** : A Hyperlink that will return the next page of data. If not included, this is the last page of data.
* **_first_** : A Hyperlink that will return the first page of data.
* **_last_** : A Hyperlink that will return the last page of data at this point of time.
* **_self_** : A Hyperlink that will return the current page of data.
> The Absence of *next* hyperlink indicates that a query reached the end of the available result.

### Expansion
This API uses *resource expansion*, which means that some parts of a resource are not returned unless specified in the request. 
This is useful for endpoints that return large resources in order to minimizes network traffic.<p>
The expansion is controlled in two ways:
##### Query Parameter
**_embed_** query parameter controllers which information the endpoint will deliver.
> **By default:** *embed* query parameter is set to *False*, which means only basic information and a link for details and sub-resources will be returned.

Setting *embed* query parameter to *True* guide the API to deliver all details and sub-resources associated to the requested resource.
> **Tip:** Doing so will have a direct impact on the payload size and might affect response time as well. 
            
We encourage following the provided links to access each specific resource, instead of providing all sub-resources for the returned collection.<p>
**<details>
     <summary>Sample Response</summary>**
```json
{
  "data": [
    {
      "resource": {
        "href": "http://some-domain/some/link/to/somewhere",
        "embedded": {
          "resource": [
            {
              "detailed-attribute-1": "string",
              "detailed-attribute-2": "string",
              "detailed-attribute-3": "2019-11-29T18:24:49.777Z",
              "detailed-attribute-n": "string"
            }
          ]
        }
      }
    }
  ]
}
``` 
</details>

##### Header
[**_Prefer Header_**](https://tools.ietf.org/html/rfc7240) anticipates certain behaviors to be employed by a server while processing a request of clients.<p>
Currently following values are supported:
- **_return=full_** returns a full set of data which might affect the payload size.
- **_return=essential_** returns a basic set of data which provide a basic overview of the required resource.

> **_Note_** This header is considered only when query parameter `embed` is set to *True*

### Deferred Processing
Some API endpoints may trigger long-running or computationally expensive tasks. In these cases, the endpoint will schedule an asynchronous task 
in order not to block the client for the whole processing time and return an appropriate *HTTP Status Code* indicates the asynchronous processing.<p>
> **Tip:** More details will be provided in the respective endpoint.

### Headers
##### Request Headers
- Prefer
- If-Match

##### Response Headers
- ETag 
- Retry-After
