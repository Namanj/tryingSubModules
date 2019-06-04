name := "RecA"

version := "0.1"

scalaVersion := "2.11.8"

resolvers += "Cloudera Repo" at "https://repository.cloudera.com/artifactory/cloudera-repos/"

libraryDependencies ++= Seq (
  "org.apache.spark" %% "spark-sql" % "2.3.0.cloudera2" % "provided",
  "org.apache.spark" %% "spark-core" % "2.3.0.cloudera2" % "provided",
  "com.typesafe" % "config" % "1.3.1",
  "org.scalatest" % "scalatest_2.10" % "1.9.1" % "test"
)

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}