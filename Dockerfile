FROM openjdk:8-jre
MAINTAINER Wouter Habets <wouterhabets@gmail.com>

RUN mkdir -p /opt/sjtekfood/config
ADD build/libs/sjtekfood*.jar /opt/sjtekfood/server.jar

EXPOSE 8080
VOLUME ["/opt/sjtekfood/config"]

WORKDIR /opt/sjtekfood/config

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/opt/sjtekfood/server.jar"]
