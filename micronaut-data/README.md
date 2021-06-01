
## Install SDK Micronaut


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
export ARTIFACT_VERSION=2.0.0
export ARTIFACT_ID=micronaut-data
```

```docker

#Docker images multi-stage build
docker build --build-arg ARTIFACT_ID,ARTIFACT_VERSION . -t us-persons

#Create local images 
docker run -d --name us-persons -e APP_PORT=8080 -p 9080:8080 us-persons:1.0.0

#Create tag container registry 
docker tag us-persons gcr.io/[PROJECT ID]/us-persons:VERSION

#GCloud login
gcloud auth login

#Push Containet Registry GCP
gcloud docker --  push gcr.io/[PROJECT ID]//us-persons

# Run Deploy Service API
gcloud beta run deploy us-persons --image gcr.io/[PROJECT ID]/us-persons:VERSION --set-env-vars APP_PORT=8080
--platform managed --allow-unauthenticated --cpu=1 --memory=512Mi --region=us-central1
```

## Deploy Cloud Run
![deploy](../images/cloudrun-service.png)

![deploy](../images/cloud-run.png)
## Client HTTP

#### Save Person

```bash
curl --location --request POST 'https://us-persons-wcyidxth5q-uc.a.run.app/api/v1/persons' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Alvaro DAniel",
    "lastName": "Aguinaga",
    "document": "47082903",
    "age": "29",
    "telephone": 986809252,
    "birthDate": "1992-03-27",
    "gender": "M",
    "email": "alvaro92a18@gmail.com",
    "address": "CALLE SAN MIGUEL 488"
}'
```

#### Update Person

```bash
curl --location --request PUT 'https://us-persons-wcyidxth5q-uc.a.run.app/api/v1/persons' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 1,
    "name": "Alvaro Daniel",
    "lastName": "Aguinaga",
    "document": "47082903",
    "age": "29",
    "telephone": 986809252,
    "birthDate": "1992-03-27",
    "gender": "M",
    "email": "alvaro92a18@gmail.com",
    "address": "CALLE SAN MIGUEL 488"
}'
```
#### Delete Person

```bash
curl --location --request DELETE 'https://us-persons-wcyidxth5q-uc.a.run.app/api/v1/persons/1'
```

#### Get ALL Person

```bash
curl --location --request GET 'https://us-persons-wcyidxth5q-uc.a.run.app/api/v1/persons'
```

#### Find By ID Person

```bash
curl --location --request GET 'https://us-persons-wcyidxth5q-uc.a.run.app/api/v1/persons/1'
```

#### Api Swagger

```bash
curl https://us-persons-wcyidxth5q-uc.a.run.app/swagger/views/rapidoc/index.html
curl https://us-persons-wcyidxth5q-uc.a.run.app/swagger/views/swagger-ui/index.html
```

#### Endpoint Monitoring

```bash
curl --location --request GET 'https://us-persons-wcyidxth5q-uc.a.run.app/health'
curl --location --request GET 'https://us-persons-wcyidxth5q-uc.a.run.app/metrics'
curl --location --request GET 'https://us-persons-wcyidxth5q-uc.a.run.app/routes'
```

## References

[Example Micronaut](https://medium.com/danieldiasjava/creating-a-rest-application-with-micronaut-30a001b3c38b)

[Install Sdk](https://sdkman.io/install)

[Started Micronaut](https://micronaut-projects.github.io/micronaut-starter/latest/guide/#installation)

[Micronaut Data](https://altkomsoftware.pl/en/blog/micronaut-data/)

[Api Swagger](https://micronaut-projects.github.io/micronaut-openapi/latest/guide/index.html)

[Cloud Run Deploy](https://cloud.google.com/sdk/gcloud/reference/beta/run/deploy)

## Feature http-client documentation

- [Micronaut Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)

## Feature jdbc-tomcat documentation

- [Micronaut Tomcat JDBC Connection Pool documentation](https://micronaut-projects.github.io/micronaut-sql/latest/guide/index.html#jdbc)

## Feature hibernate-validator documentation

- [Micronaut Hibernate Validator documentation](https://micronaut-projects.github.io/micronaut-hibernate-validator/latest/guide/index.html)

## Feature lombok documentation

- [Micronaut Project Lombok documentation](https://docs.micronaut.io/latest/guide/index.html#lombok)

- [https://projectlombok.org/features/all](https://projectlombok.org/features/all)

## Feature Micrometer Prometheus documentation

- [https://micronaut-projects.github.io/micronaut-micrometer/latest/guide/#metricsEndpoint)](https://micronaut-projects.github.io/micronaut-micrometer/latest/guide/#metricsEndpoint)