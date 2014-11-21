package com.tuzhucheng.chat4s

import scala.concurrent.ExecutionContext

import org.http4s._
import org.http4s.dsl._
import org.http4s.server._

object ChatService {
  def service(implicit executionContext: ExecutionContext = ExecutionContext.global) = HttpService {
    case req @ GET -> Root =>
      Ok(
        <html>
          <body>
            <h1>Welcome to chat4s</h1>
          </body>
        </html>
      )
  }
}
