
# eclipse-temurin is recommended for scala dev if i rememmber correctly. ill try to find that doc and link here.
FROM sbtscala/scala-sbt:eclipse-temurin-17.0.4_1.7.2_3.2.0

# this widely used image ^ uses java 17 (17.0.4) and is long term supported provided by eclipse-temurin
# sbt version: 1.7.2 # most recent as of this time
# scala version 3.2.0 # most recent as of this time
# format: <JDK-Base>-<JDK_VERSION>_<SBT-VERSION>_<SCALA_VERSION>
# https://github.com/sbt/docker-sbt
# https://hub.docker.com/r/sbtscala/scala-sbt/tags


WORKDIR /app

COPY . /app/

CMD sbt compile

# RUN "scala /app/src/main/scala/bballApp.scala"