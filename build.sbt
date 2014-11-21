val http4sVersion = "0.4.0"

lazy val root = (project in file(".")).
  settings(
    name := "chat4s",
    description := "Prototype web socket chat application using http4s",
    version := "0.10",
    scalaVersion := "2.11.4",
    libraryDependencies ++= Seq(
      "org.http4s" %% "http4s-core" % http4sVersion,
      "org.http4s" %% "http4s-dsl" % http4sVersion,
      "org.http4s" %% "http4s-server" % http4sVersion,
      "org.http4s" %% "http4s-jetty" % http4sVersion
    ),
    resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"
  )
