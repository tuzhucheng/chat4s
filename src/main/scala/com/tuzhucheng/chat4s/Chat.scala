package com.tuzhucheng.chat4s

import util.Properties
import org.http4s.server.jetty.JettyBuilder

object Chat extends App {
  val port = Properties.envOrElse("PORT", "8080").toInt
  println("Starting on port " + port)
  JettyBuilder.bindHttp(port)
    .mountService(ChatService.service, "/chat4s")
    .run
    .awaitShutdown()
}
