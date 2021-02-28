## Feature http-client documentation

- [Micronaut Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)

## Feature jdbc-tomcat documentation

- [Micronaut Tomcat JDBC Connection Pool documentation](https://micronaut-projects.github.io/micronaut-sql/latest/guide/index.html#jdbc)

## Feature hibernate-validator documentation

- [Micronaut Hibernate Validator documentation](https://micronaut-projects.github.io/micronaut-hibernate-validator/latest/guide/index.html)

## Feature lombok documentation

- [Micronaut Project Lombok documentation](https://docs.micronaut.io/latest/guide/index.html#lombok)

- [https://projectlombok.org/features/all](https://projectlombok.org/features/all)

## install Sdk Micronaut


```shell script
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk version
sdk install micronaut
```

## generated project micronaut

```bash
mn create-app org.app.walavo.micronaut-data  --features=jdbc-tomcat,logback,h2,data-jpa,hibernate-validator,lombok --lang=java  --build=maven
```

## Compile project micronaut

```maven
mvn clean install
```

###Build images Docker

```bash
export ARTIFACT_VERSION=1.0.0
export ARTIFACT_ID=micronaut-data
```

```docker
docker build --build-arg ARTIFACT_ID,ARTIFACT_VERSION . -t micronaut-starter
docker tag micronaut-starter gcr.io/[PROJECT ID]//micronaut-starter:VERSION

#Push Containet Registry GCP
gcloud docker --  push gcr.io/[PROJECT ID]//micronaut-starter
# Run Deploy Service API
gcloud beta run deploy --image gcr.io/[PROJECT ID]/micronaut-starter:VERSION
```

## Client HTTP

#### Save Person

```bash
curl --location --request POST 'https://walavo-persons-gzn4kc6qva-uc.a.run.app/api/v1/persons' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Alvaro Aguinaga",
    "age": 28,
    "telephone": "986809252"
}'
```

#### Update  Person

```bash
curl --location --request PUT 'https://walavo-persons-gzn4kc6qva-uc.a.run.app/api/v1/persons' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 1,
    "name": "Alvaro Aguinagas",
    "age": 28,
    "telephone": "986809252"
}'
```

#### Get ALL Person

```bash
curl --location --request GET 'https://walavo-persons-gzn4kc6qva-uc.a.run.app/api/v1/persons'
```

#### Find By ID Person

```bash
curl --location --request GET 'https://walavo-persons-gzn4kc6qva-uc.a.run.app/api/v1/persons/1'
```

#### Api Swagger

```bash
curl https://walavo-persons-gzn4kc6qva-uc.a.run.app/swagger/views/rapidoc/index.html
curl https://walavo-persons-gzn4kc6qva-uc.a.run.app/swagger/views/swagger-ui/index.html
```

## References

[Example Micronaut](https://medium.com/danieldiasjava/creating-a-rest-application-with-micronaut-30a001b3c38b)

[Install Sdk](https://sdkman.io/install)

[Started Micronaut](https://micronaut-projects.github.io/micronaut-starter/latest/guide/#installation)

[Micronaut Data](https://altkomsoftware.pl/en/blog/micronaut-data/)

[Api Swagger](https://micronaut-projects.github.io/micronaut-openapi/latest/guide/index.html)