#
# inspired by https://hub.docker.com/_/java/
# Alpine Linux
# JRE 8
#
#
# BUILD
#   docker build . -t springboot-kotlin-starter
#
# RUN
#   docker run -it -p 8080:8080 -e PORT=8080 springboot-kotlin-starter
#

FROM alpine:3.8

ENV LANG C.UTF-8
ENV PORT 8080

RUN { \
		echo '#!/bin/sh'; \
		echo 'set -e'; \
		echo; \
		echo 'dirname "$(dirname "$(readlink -f "$(which javac || which java)")")"'; \
	} > /usr/local/bin/docker-java-home \
	&& chmod +x /usr/local/bin/docker-java-home
ENV JAVA_HOME /usr/lib/jvm/java-1.8-openjdk
ENV PATH $PATH:/usr/lib/jvm/java-1.8-openjdk/jre/bin:/usr/lib/jvm/java-1.8-openjdk/bin

ENV JAVA_VERSION 8u191
ENV JAVA_ALPINE_VERSION 8.191.12-r0

RUN set -x \
	&& apk add --no-cache \
		openjdk8="$JAVA_ALPINE_VERSION" \
	&& [ "$JAVA_HOME" = "$(docker-java-home)" ]


#
# APP
#
RUN mkdir /app
COPY build/libs/*.jar /app/app.jar

WORKDIR /app

EXPOSE $PORT

CMD java -jar app.jar --server.port=$PORT