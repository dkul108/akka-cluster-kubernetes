

name := "foo"

version := "0.0.1"

scalaVersion := "2.12.6"

//lazy val common = RootProject(file("../common"))
//val main = Project(id = "foo", base = file(".")).dependsOn(common)


libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5.13",
  "com.typesafe.akka" %% "akka-stream" % "2.5.13",
  "com.typesafe.akka" %% "akka-http" % "10.1.3"
)

//def route = path("hello") {
//  get {
//    complete("Hello, World!")
//  }
//}