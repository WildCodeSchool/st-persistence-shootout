# Persistence Shootout: When to use which persistence: SQL vs. NoSQL vs. NewSQL

This repository contains all sources and slides to replay the Tutoring-Session *Persistence Shootout: when to use which persistence: SQL vs. NoSQL vs. NewSQL*.

## Project Structure

The project is based on Spring Boot and Spring Data subpackages for each database.  
Each project is structured by packages, eg.

```
- dev.wcs.tutoring.persistenceshootout.sql
      + [...]repository
          CustomerRepository
      + [...]entity
          CustomerEntity
- dev.wcs.tutoring.persistenceshootout.nosql
  [...]
```

## Prerequisites

* Unrestricted Internet Access for Maven usage
* Local IDE installation, eg. IntelliJ or Eclipse (optional). You can download IntelliJ CE here: https://www.jetbrains.com/idea/download/
* Java 11+ (might be included in IDE)
* Maven 3+ (might be included in IDE)

## Setup Databases

### SQL Databases

#### PostgreSQL

`docker run -p5432:5432 --name tutoring-postgres -e POSTGRES_PASSWORD=q -d postgres`

#### PostgreSQL Database Client Installation

* IntelliJ Plugin in Ultimate
* pgAdmin or DBeaver

### NoSQL Databases

#### MongoDB

`docker run -d --name mongo-tutoring -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=secret -p 27017:27017 mongo`

#### MongoDB Database Client Installation

* Install [Robot 3T](https://robomongo.org/)

#### Neo4j

`docker run --name neo4j-tutoring -p7474:7474 -p7687:7687 -d -v data:/data -v logs:/logs -v import:/var/lib/neo4j/import -v plugins:/plugins --env NEO4J_AUTH=neo4j/q neo4j:latest`

#### Neo4j Desktop Client Installation

* Install [Neo4j Desktop](https://neo4j.com/download-neo4j-now/)

#### ElasticSearch

* Run `docker-compose up` in `docker-compose-playground`

#### ElasticSearch Client Installation

* [Chrome Browser Plugin](https://elasticvue.com/)
* Kibana: http://localhost:5601

## Setup Tests

* In your IDE or with `git clone` clone this project by using the Repository URL.
* Run `PersistenceShootoutApplication`
