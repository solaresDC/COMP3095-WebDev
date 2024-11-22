#-----------------
# Build Stage
#-----------------

FROM gradle:8-jdk23-alpine AS builder

COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src

RUN gradle build -x test

#-----------------------
# Package Stage
#-----------------------

FROM openjdk:23-jdk

RUN mkdir /app

#Until here every micro service can have same code for Dockerfile but next line change (the name of the jar file)
COPY --from=builder /home/gradle/src/build/libs/*.jar /app/api-gateway.jar


EXPOSE 9000

#we also have to change it here: api-gateway
ENTRYPOINT ["java","-jar","/app/api-gateway.jar"]
