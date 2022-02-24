FROM gradle:7.3.3-jdk11-alpine

USER gradle

VOLUME . /home/gradle/project
WORKDIR /home/gradle/project

RUN gradle build
