# define base docker image
FROM openjdk:11
LABEL maintainer="Mohamed S. El-Shall"
ADD target/charge-service-registry-0.0.1-SNAPSHOT.jar charge-service-registry.jar
ENTRYPOINT ["java", "-jar", "charge-service-registry.jar"]