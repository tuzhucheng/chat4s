package com.tuzhucheng.chat4s

import scala.concurrent.ExecutionContext
import scalaz.stream._
import scalaz.stream.text
import scalaz.concurrent.Task

import java.io._

import org.http4s._
import org.http4s.dsl._
import org.http4s.server._

object ChatService {
  def fahrenheightToCelsius(f: Double) = 5 * (f - 32) / 9

  def service(implicit executionContext: ExecutionContext = ExecutionContext.global) = HttpService {
    case req @ GET -> Root =>
      Ok(
        <html>
          <body>
            <h1>Welcome to chat4s</h1>
          </body>
        </html>
      )

    case req @ GET -> Root / "stream" =>
      val converter: Task[Unit] =
        io.linesR("data/fahrenheit.txt")
          .filter(s => !s.trim.isEmpty && !s.startsWith("//"))
          .map(line => fahrenheightToCelsius(line.toDouble).toString)
          .intersperse("\n")
          .pipe(text.utf8Encode)
          .to(io.fileChunkW("data/celsius.txt"))
          .run

      val u: Unit = converter.run
      Ok(
        <html>
          <head>
            <title>chat4s streaming</title>
          </head>
          <body>
            <h1>chat4s streaming</h1>
          </body>
        </html>
      )
  }
}
