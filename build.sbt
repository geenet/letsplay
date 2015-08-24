name := """a2pi"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "com.datastax.cassandra" % "cassandra-driver-core" % "2.2.0-rc2",
  "io.spray" %%  "spray-json" % "1.3.2",
  "org.json4s" %% "json4s-native" % "3.2.11",
  "com.typesafe.play" %% "play-mailer" % "3.0.1",
  //val json4sNative = "org.json4s" %% "json4s-native" % "3.2.11"
  //For the Jackson support add the following dependency to your project description:
  //val json4sJackson = "org.json4s" %% "json4s-jackson" % "3.2.11"
  //"org.json4s" %% "json4s-jackson" % "3.2.11",
  specs2 % Test

)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
