name := "HHCache"

organization:="com.hhcache"

version := "1.0.0-M1-SNAPSHOT"

scalaVersion := "2.10.5"

ivyScala := ivyScala.value map {
  _.copy(overrideScalaVersion = true)
}

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.7"

libraryDependencies += "com.typesafe.akka" %% "akka-remote" % "2.3.7"

libraryDependencies += "com.typesafe.akka" %% "akka-file-mailbox" % "2.3.7"

libraryDependencies += "com.typesafe.akka" %% "akka-agent" % "2.3.7"

libraryDependencies += "com.typesafe.akka" %% "akka-transactor" % "2.3.7"

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.2.2" % "test"

libraryDependencies +="com.typesafe.akka" %% "akka-persistence-experimental" % "2.3.7"