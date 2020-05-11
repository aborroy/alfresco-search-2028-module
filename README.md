# Alfresco SEARCH-2028 Module

This is an ACS Repository module for Alfresco Community 6.0+

The feature [SEARCH-2028](https://issues.alfresco.com/jira/browse/SEARCH-2028) provides the ability to skip long periods of time with no transactions to be indexed on them for Metadata Tracker. This could save lot of time for Alfresco Search Services to catch up with the Repository, specially when indexing repositories with several years of history.

This feature is available from [Search Services 1.4.2](https://github.com/Alfresco/SearchServices/tree/1.4.2), but the Repository part is only available from ACS 6.2.1. This project provides a module to be deployed in Alfresco Repository (alfresco.war) in order to enable the new Web Script required by the Search Services feature.

This module can be deployed from Alfresco Community 6.0+ together with Search Services 1.4.2.

## Back-porting repository features

This feature, on the Repository part, includes a new database query and a new Web Script. Both have been back-ported using default Alfresco extension mechanisms.

## Installing the module

Copy [alfresco-search-2028-module-1.0.0.jar]() to your deployment folder by using default [Simple Module instructions](https://docs.alfresco.com/community/concepts/dev-extensions-packaging-techniques-jar-files.html). It's just only required to copy this JAR to `alfresco/WEB-INF/lib` folder.

## Verifying the module

Once the module it's deployed, repository will provide a new Web Script from SOLR family, available from following URL:

http://localhost:8080/alfresco/s/api/solr/nextTransaction?fromCommitTime=0

SOLR 1.4.2 will use this URL in order to skip large time periods with no transactions inside.

## Building the module

You can build the module with standard Maven command:

```
$ mvn clean package
```
