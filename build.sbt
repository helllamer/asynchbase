import sbtprotobuf.{ProtobufPlugin=>PB}


organization := "org.hbase"

name := "asynchbase"

version := "1.5.0-SNAPSHOT"


crossPaths := false

autoScalaLibrary := false


// Activate sbt-protobuf plugin
seq(PB.protobufSettings: _*)

version in PB.protobufConfig := "2.5.0"


libraryDependencies ++= {
  val slf4jVsn      = "1.7.5"
  val powermockVsn  = "1.5"
  Seq(
    // Compile deps
    "com.google.guava" % "guava" % "14.0.1",
    //"com.google.protobuf" % "protobuf-java" % "2.5.0",
    "io.netty" % "netty" % "3.8.0.Final",
    "com.stumbleupon" % "async" % "1.4.0",
    "org.apache.zookeeper" % "zookeeper" % "3.3.6"
      exclude("log4j", "log4j")
      exclude("org.slf4j", "slf4j-log4j12")
      exclude("jline","jline")
      exclude("junit", "junit"),
    "org.slf4j" % "slf4j-api" % slf4jVsn,
    // Runtime deps
    "org.slf4j" % "log4j-over-slf4j" % slf4jVsn,
    // Test deps
    "org.hamcrest" % "hamcrest-core" % "1.3" % "test",
    "junit" % "junit" % "4.11" % "test",
    "org.javassist" % "javassist" % "3.17.1-GA" % "test",
    "org.mockito" % "mockito-all" % "1.9.5" % "test",
    "org.objenesis" % "objenesis" % "1.3" % "test",
    "org.powermock" % "powermock-module-junit4" % powermockVsn % "test",
    "org.powermock" % "powermock-api-mockito" % powermockVsn % "test"
  )
}


// Copypasted as-is from pom.xml.in
pomExtra :=
  <organization>
    <name>The Async HBase Authors</name>
    <url>http://opentsdb.net</url>
  </organization>
  <description>
    An alternative HBase client library for applications requiring fully
    asynchronous, non-blocking and thread-safe HBase connectivity.
  </description>
  <url>https://github.com/OpenTSDB/asynchbase</url>
  <licenses>
    <license>
      <name>BSD</name>
      <url>http://www.opensource.org/licenses/BSD-3-Clause</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <connection>scm:git:git@github.com:OpenTSDB/asynchbase.git</connection>
    <url>https://github.com/OpenTSDB/asynchbase</url>
  </scm>
  <issueManagement>
    <system>GitHub</system>
    <url>https://github.com/OpenTSDB/asynchbase/issues</url>
  </issueManagement>
  <mailingLists>
    <mailingList>
      <name>User List</name>
      <post>asynchbase@googlegroups.com</post>
      <subscribe>asynchbase+subscribe@googlegroups.com</subscribe>
      <unsubscribe>asynchbase+unsubscribe@googlegroups.com</unsubscribe>
      <archive>https://groups.google.com/group/asynchbase</archive>
    </mailingList>
  </mailingLists>
  <developers>
    <developer>
      <id>tsuna</id>
      <name>Benoit "tsuna" Sigoure</name>
      <email>tsunanet@gmail.com</email>
      <roles>
        <role>developer</role>
      </roles>
      <timezone>-8</timezone>
    </developer>
  </developers>
  <inceptionYear>2010</inceptionYear>


