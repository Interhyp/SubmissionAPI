# Api with proper polymorphism guide
## Required settings

To generate interfaces from openapi, openapi-generator-maven-plugin or openapi-generator-gradle-plugin needs to be upgraded to version 6.6.0 or higher.

2 additional properties needs to be added to the generators settings.

Gradle:
configOptions = [
    ...
    useOneOfInterfaces: "true",
]
additionalProperties = [
    ...
    supportUrlQuery: 'false'
]

Maven:
<configOptions>
  ...
  <useOneOfInterfaces>true</useOneOfInterfaces>
  <supportUrlQuery>false</supportUrlQuery>
</configOptions>
