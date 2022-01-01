# define base docker image
FROM openjdk:11
LABEL maintainer="Mohamed S. El-Shall"
ADD target/charge-cloud-gateway-0.0.1-SNAPSHOT.jar charge-cloud-gatewayy.jar
ENTRYPOINT ["java", "-jar", "charge-cloud-gateway.jar"]