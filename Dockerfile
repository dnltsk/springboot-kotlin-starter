#
# inspired by https://hub.docker.com/_/java/
# Alpine Linux
# JRE 8
#
#
# BUILD
#   docker build --build-arg SENTRY_ENABLED=true --build-arg SENTRY_DSN=${YOUR_SENTRY_DSN} . -t springboot-kotlin-starter
#
# RUN
#   docker run -it -p 8080:8080 -e PORT=8080 springboot-kotlin-starter
#

FROM openjdk:8u191-jdk-alpine3.8 as builder
WORKDIR /project
COPY . /project
RUN ./gradlew bootJar

FROM openjdk:8u191-jre-alpine3.8
ARG SENTRY_ENABLED=false
ENV ENV_SENTRY_ENABLED=$SENTRY_ENABLED
ARG SENTRY_DSN="dsn-not-set"
ENV ENV_SENTRY_DSN=$SENTRY_DSN
COPY --from=builder /project/build/libs/springbootkotlinstarter-0.0.1-SNAPSHOT.jar /app/app.jar
WORKDIR /app
EXPOSE $PORT
CMD java -jar app.jar --server.port=$PORT --sentry.enabled=$ENV_SENTRY_ENABLED --sentry.dsn=$ENV_SENTRY_DSN