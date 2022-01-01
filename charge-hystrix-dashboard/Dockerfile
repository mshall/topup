# define base docker image
FROM openjdk:11
LABEL maintainer="Mohamed S. El-Shall"
ADD target/charge-hystrix-dashboard-0.0.1-SNAPSHOT.jar charge-hystrix-dashboar.jar
ENTRYPOINT ["java", "-jar", "charge-hystrix-dashboar.jar"]