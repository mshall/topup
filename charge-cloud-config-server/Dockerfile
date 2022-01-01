# define base docker image
FROM openjdk:11
LABEL maintainer="Mohamed S. El-Shall"
ADD target/charge-cloud-config-server-0.0.1-SNAPSHOT.jar charge-cloud-config-server.jar
ENTRYPOINT ["java", "-jar", "charge-cloud-config-server.jar"]