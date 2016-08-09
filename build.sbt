name := "play-with-quill-jdbc"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "com.h2database" % "h2" % "1.4.192",
  "org.slf4j" % "slf4j-simple" % "1.7.21",
  "mysql" % "mysql-connector-java" % "5.1.38",
  "io.getquill" %% "quill-jdbc" % "0.8.0",
  "org.scalatest" % "scalatest_2.11" % "3.0.0"
)
