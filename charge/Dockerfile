# define base docker image
FROM openjdk:11
LABEL maintainer="Mohamed S. El-Shall"
ADD target/charging-0.0.1-SNAPSHOT.jar charging.jar
ENTRYPOINT ["java", "-jar", "s charging.jar"]