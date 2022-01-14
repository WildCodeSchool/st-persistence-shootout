# Software Developer Tutoring: Persistence Shootout

This repository contains all sources and slides to replay the Tutoring-Session "Persistence Shootout".

## Persistence Shootout

The project is based on Spring Boot and Spring Data subpackages for each database.  
Each project is structured by packages, eg.

```
- dev.wcs.tutoring.sql.mysql
    StarterClassForDatabaseSample
    + repository
      DatabaseRepository
    + service
      SampleService
- dev.wcs.tutoring.nosql.redis
  [...]
```

## Prerequisites

* Unrestricted Internet Access for Maven usage
* Local IDE installation, eg. IntelliJ or Eclipse (optional). You can download IntelliJ CE here: https://www.jetbrains.com/idea/download/
* Java 11+ (might be included in IDE)
* Maven 3+ (might be included in IDE)

## Setup

* In your IDE or with `git clone` clone this project by using the Repository URL.
* Run the samples for the database you are interested in.