name := "DocumentManager"

version := "0.1"

scalaVersion := "2.11.8"

ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }

lazy val Versions = new {
  val phantom = "2.1.3"
  val util = "0.30.1"
  val scalatest = "3.0.4"
}

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.typesafeRepo("releases"),
  Resolver.bintrayRepo("websudos", "oss-releases")
)


libraryDependencies ++= Seq(
  "com.outworkers"  %%  "phantom-dsl"       % Versions.phantom,
  "com.outworkers"  %%  "phantom-streams"   % Versions.phantom,
  "com.outworkers"  %%  "util-testing"      % Versions.util % Test,
  "org.scalatest"   %%  "scalatest"         % Versions.scalatest % Test,
  "com.typesafe" % "config" % "1.2.1",
  "com.outworkers" %% "util-testing" % Versions.util
)

