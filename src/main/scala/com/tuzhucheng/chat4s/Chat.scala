package com.tuzhucheng.chat4s

import org.http4s.server.jetty.JettyBuilder

object Chat extends App {
  JettyBuilder.bindHttp(8080)
    .mountService(ChatService.service, "/chat4s")
    .run
    .awaitShutdown()
}
