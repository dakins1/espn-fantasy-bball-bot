scalaVersion := "2.13.10"
version := "1.0"

lazy val fanbot = (project in file("."))
    .settings(
        name := "fan-bot",
        libraryDependencies ++= Seq() //for future reference
    )