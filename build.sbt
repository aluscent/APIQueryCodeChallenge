ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.11"

lazy val root = (project in file("."))
  .settings(
    name := "PrewaveChallenge"
  )

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core" % "0.14.5",
  "io.circe" %% "circe-generic" % "0.14.5",
  "io.circe" %% "circe-parser" % "0.14.5",
  "com.softwaremill.sttp.client" %% "core" % "2.3.0",
  "com.github.pathikrit" %% "better-files" % "3.9.2"
)
