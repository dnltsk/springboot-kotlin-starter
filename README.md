[![Build Status](https://travis-ci.org/dnltsk/springboot-kotlin-starter.svg?branch=master)](https://travis-ci.org/dnltsk/springboot-kotlin-starter)
[![CodeBeat](https://codebeat.co/badges/6fb20abc-6142-406d-97af-6314ac5972f6)](https://codebeat.co/projects/github-com-dnltsk-springboot-kotlin-starter-master)
[![CodeCov](https://codecov.io/gh/dnltsk/springboot-kotlin-starter/branch/master/graph/badge.svg)](https://codecov.io/gh/dnltsk/springboot-kotlin-starter)
[![Heroku](https://heroku-badge.herokuapp.com/?app=springboot-kotlin-starter&root=index.html&svg=1)](https://springboot-kotlin-starter.herokuapp.com/)


# springboot-kotlin-starter

starting point for a new spring boot micro service, written in Kotlin

## features

* [x] Travis CI integration
* [x] CodeBeat integration
* [x] CodeCov integration
* [x] Swagger UI
* [x] Sentry integration
* [x] Dockerization
* [x] Heroku deployment
* [ ] Monitoring
* [ ] Central logging

## test

`./gradlew clean test`

## build

`./gradlew clean bootJar`

## start

`java -jar build/libs/*.jar --sentry.enabled=true --sentry.dsn=${YOUR_SENTRY_DSN}`

## build docker

`docker build --build-arg SENTRY_ENABLED=true --build-arg SENTRY_DSN=${YOUR_SENTRY_DSN} . -t springboot-kotlin-starter`

## start docker

`docker run -it -p 8080:8080 -e PORT=8080 springboot-kotlin-starter`

## access

http://localhost:8080/
