name := "test_scala"

version := "0.1"

scalaVersion := "2.12.4"

//// https://mvnrepository.com/artifact/commons-io/commons-io
//libraryDependencies += "commons-io" % "commons-io" % "2.6"
libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.2.0",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "org.apache.pdfbox" % "pdfbox" % "2.0.8"
)
