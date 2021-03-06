/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.scala.ext.web.handler

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.core.Handler
import io.vertx.ext.web.handler.{ResponseTimeHandler => JResponseTimeHandler}

/**
  * Handler which adds a header `x-response-time` in the response of matching requests containing the time taken
  * in ms to process the request.
  */
class ResponseTimeHandler(private val _asJava: Object)
    extends io.vertx.core.Handler[RoutingContext] {

  def asJava = _asJava

  override def handle(arg0: RoutingContext): Unit = {
    asJava.asInstanceOf[JResponseTimeHandler].handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }

}

object ResponseTimeHandler {
  def apply(asJava: JResponseTimeHandler) = new ResponseTimeHandler(asJava)  
  /**
    * Create a handler
    * @return the handler
    */
  def create(): ResponseTimeHandler = {
    ResponseTimeHandler(JResponseTimeHandler.create())
  }

}
