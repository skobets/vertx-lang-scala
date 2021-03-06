package io.vertx.lang.scala

import java.util.concurrent.{CountDownLatch, TimeUnit}

import io.vertx.scala.core.Vertx
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}

import scala.concurrent.{Future, Promise}

@RunWith(classOf[JUnitRunner])
class VertxExecutionContextTest extends FlatSpec with Matchers {
  val vertx = Vertx
  "Using Promise to complete a Vertx-Future" should "work with a VertxExecutionContext" in {
    val cl = new CountDownLatch(1)
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx.getOrCreateContext())
    vertx.deployVerticleFuture(s"scala:${classOf[PromiseTestVerticle].getName}").foreach(r => cl.countDown())
    val delay = cl.await(10000, TimeUnit.MILLISECONDS)
    assert(delay, "Deploy took longer than 10000 ms")
  }
}

class PromiseTestVerticle extends ScalaVerticle {

  override def start(): Future[Unit] = {
    val promise = Promise[Unit]()
    val f1 = vertx.eventBus().consumer[String]("asd").handler(a => println(a)).completionFuture()
    val f2 = vertx.eventBus().consumer[String]("asd2").handler(a => println(a)).completionFuture()
    val res = for {
      a1 <- f1
      a2 <- f2
    } yield (a1 + " " + a2)
    res.map(a => promise.success(()))
    promise.future
  }
}
