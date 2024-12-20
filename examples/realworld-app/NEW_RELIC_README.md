# Elasticsearch Native OpenTelemetry Instrumentation With New Relic Hybrid OpenTelemetry Agent

Demo application illustrating how the [elasticsearch native OpenTelemetry instrumentation](https://www.elastic.co/guide/en/elasticsearch/client/java-api-client/current/opentelemetry.html) can be leveraged by the New Relic Java agent. The result is that the elasticsearch spans will be included in New Relic distributed traces and elasticsearch calls will be shown in the New Relic APM Databases UI.

The only modifications that were necessary to this application were the addition of the `io.opentelemetry` gradle dependencies, updating the `elasticsearch.api.key` in `application.properties`, and the following line in the `ElasticClient` class:

```java
    private static final OpenTelemetry openTelemetry = AutoConfiguredOpenTelemetrySdk.initialize().getOpenTelemetrySdk();
```

## Requirements

- Java 21
- Docker

## Start Elasticsearch Instance

You can start an elasticsearch instance by running:

```shell
docker-compose up
``` 
or
```shell
curl -fsSL https://elastic.co/start-local | sh
```

## Run SpringBootApp

To use the New Relic OpenTelemetry hybrid agent you need and agent build off of the [saxon/replace-otel-spans2](https://github.com/newrelic/newrelic-java-agent/tree/saxon/replace-otel-spans2) branch (see related [PR](https://github.com/newrelic/newrelic-java-agent/pull/1886)).

Either in IntelliJ or elsewhere, run the `SpringBootApp` service with the following system properties set as VM options to configure the New Relic Java agent and OpenTelemetry features:

```
-javaagent:/path/to/newrelic/newrelic.jar
-Dnewrelic.config.lite_mode=false
-Dnewrelic.config.class_transformer.com.newrelic.instrumentation.opentelemetry-sdk-extension-autoconfigure-1.28.0.enabled=true
-Dnewrelic.config.app_name=elasticsearch-realworld-otel
-Dnewrelic.config.log_file_name=elasticsearch-realworld-otel.log
-Dopentelemetry.sdk.spans.enabled=true
-Dopentelemetry.sdk.autoconfigure.enabled=true
-Dotel.instrumentation.elasticsearch.enabled=true
-Dotel.instrumentation.elasticsearch.capture-search-query=true
```

## API Usage

### `UserController`

#### Create User [POST]

```shell
curl --location 'http://localhost:8080/api/users' \
--header 'Content-Type: application/json' \
--data-raw '{
    "user": {
        "username": "username",
        "email": "username@mail.com",
        "password": "password"
    }
}'
```

This will return a payload containing a `token` for the newly created user (see below example). This `token` value will be needed for authorizing requests to some of the other endpoints for this specific user.
```json
{"user":{"username":"username","email":"username@mail.com","token":"eyJhbGciOiJIUzI1NiJ9.......","bio":"","image":""}}
```

#### Login User [POST]

```shell
curl --location 'http://localhost:8080/api/users/login' \
--header 'Content-Type: application/json' \
--data-raw '{
    "user": {
        "email": "username@mail.com",
        "password": "password"
    }
}'
```

#### Find User [GET]

Using the `token` for a specific user:
```shell
curl --location 'http://localhost:8080/api/user' \
--header 'Authorization: Token eyJhbGciOiJIUzI1NiJ9.......'
```

#### Update User [PUT]

Using the `token` for a specific user:
```shell
curl --location --request PUT 'http://localhost:8080/api/user' \
--header 'Content-Type: application/json' \
--header 'Authorization: Token eyJhbGciOiJIUzI1NiJ9.......' \
--data-raw '{
    "user": {
        "username": "username",
        "email": "username@mail.com",
        "token": "Token eyJhbGciOiJIUzI1NiJ9.......",
        "bio": "bio",
        "image": ""
    }
}'
```

### `ProfileController`

#### Find User Profile [GET]

Using the `token` for a specific user:
```shell
curl --location 'http://localhost:8080/api/profiles/username' \
--header 'Authorization: Token eyJhbGciOiJIUzI1NiJ9.......'
```

#### Follow User Profile [POST]

Using the `token` for a specific user and a request parameter (i.e. `username2`) for a different user:
```shell
curl --location --request POST 'http://localhost:8080/api/profiles/username2/follow' \
--header 'Authorization: Token eyJhbGciOiJIUzI1NiJ9.......' \
--data ''
```
#### Unfollow User Profile [DELETE]

Using the `token` for a specific user and a request parameter (i.e. `username2`) for a different user:
```shell
curl --location --request DELETE 'http://localhost:8080/api/profiles/username2/follow' \
--header 'Authorization: Token eyJhbGciOiJIUzI1NiJ9.......' \
--data ''
```

### `TagsController`

### Find All Tags [GET]

```shell
curl --location 'http://localhost:8080/api/tags'
```

### `ArticleController`

### Create New Article For A Specific User [POST]

```shell
curl --location 'http://localhost:8080/api/articles' \
--header 'Content-Type: application/json' \
--header 'Authorization: Token eyJhbGciOiJIUzI1NiJ9.......' \
--data '{
    "article": {
        "title": "title",
        "description": "description",
        "body": "body",
        "tagList": [
            "foo",
            "bar",
            "baz"
        ]
    }
}'
```

