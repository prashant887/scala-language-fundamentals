ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .settings(
    name := "scala-language-fundamentals"
  )

libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "2.2.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.17" % Test
libraryDependencies += "org.scalamock" %% "scalamock" % "5.2.0" % Test
