FROM maven:3.3-jdk-8
ENV ARTIFACT_ID=micronaut-data
ENV ARTIFACT_VERSION=2.0.0
WORKDIR /artifact
COPY . /artifact
RUN mvn clean install
RUN ls -la

FROM openjdk:8
ENV ARTIFACT_ID=micronaut-data

RUN apt-get update \
	&& apt-get install -y ca-certificates \
	&& update-ca-certificates \
	&& apt-get install -y tzdata
	ENV TZ=America/Lima

WORKDIR /artifact
COPY --from=0 /artifact/target/${ARTIFACT_ID}-*.jar app.jar
COPY --from=0 /artifact/src/main/resources .
RUN ls -lF
RUN mkdir -p /${ARTIFACT_ID}/resources
COPY src/main/resources/* /${ARTIFACT_ID}/resources/
CMD ["sh","-c","java -jar app.jar -Duser.timezone=America/Lima ${JAVA_OPTS}"]
RUN du -sh /var/cache/apt