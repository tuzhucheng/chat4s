lazy val root = (project in file(".")).
  settings(
    name := "chat4s",
    description := "Prototype web socket chat application using http4s",
    version := "0.10",
    scalaVersion := "2.11.4",
    libraryDependencies += "org.http4s" %% "http4s-core" % "0.4.0",
    resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"
  )
