resolvers += Resolver.url("heroku-sbt-plugin-releases", url("http://dl.bintray.com/heroku/sbt-plugins/"))(Resolver.ivyStylePatterns)

addSbtPlugin("com.heroku" % "sbt-heroku" % "0.2.1")

addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "0.7.6")
