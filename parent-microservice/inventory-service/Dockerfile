#-------------------
# BUILD STAGE:
#-------------------

FROM gradle:8-jdk23-alpine AS builder

COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src

RUN gradle build -x test

#-------------------
# PACKAGE STAGE:
#-------------------

FROM openjdk:23-jdk

RUN mkdir /app

# untill here every micro service can have same code for Dockerfile but next line will change ( the name of jar file)
COPY --from=builder /home/gradle/src/build/libs/*.jar /app/inventory-service.jar

ENV POSTGRES_USER=admin \
    POSTGRES_PASSWORD=password

EXPOSE 8086
# Change here as well !
ENTRYPOINT ["java","-jar","/app/inventory-service.jar"]
