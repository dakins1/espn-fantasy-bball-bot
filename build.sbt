name := "fan-bot"
scalaVersion := "2.13.10"
version := "1.0"

val sttpVersion = "3.8.3"

libraryDependencies ++= Seq (
    "com.softwaremill.sttp.client3" %% "core" % sttpVersion
)