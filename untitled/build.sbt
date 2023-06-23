ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.11"

lazy val root = (project in file("."))
  .settings(
    name := "FSTEC"
  )

scalacOptions ++= Seq("-unchecked", "-deprecation")

libraryDependencies ++= Seq(
  "io.cequence" %% "openai-scala-client" % "0.4.0"
)
