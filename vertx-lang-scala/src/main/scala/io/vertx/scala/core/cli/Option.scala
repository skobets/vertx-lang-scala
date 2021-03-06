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

package io.vertx.scala.core.cli

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.core.cli.{Option => JOption}

/**
  * Models command line options. Options are values passed to a command line interface using -x or --x. Supported
  * syntaxes depend on the parser.
  * <p/>
  * Short name is generally used with a single dash, while long name requires a double-dash.
  */
class Option(private val _asJava: JOption) {

  def asJava = _asJava

  /**
    * Sets te arg name for this option.
    */
  def setArgName(value: String) = {
    asJava.setArgName(value)
    this
  }
  def getArgName: String = {
    asJava.getArgName().asInstanceOf[String]
  }

  /**
    * Sets the list of values accepted by this option. If the value set by the user does not match once of these
    * values, a [[io.vertx.core.cli.InvalidValueException]] exception is thrown.
    */
  def addChoice(value: String) = {
    asJava.addChoice(value)
    this
  }
  def setChoices(value: Set[String]) = {
    asJava.setChoices(value.asJava)
    this
  }
  def getChoices: scala.collection.mutable.Set[String] = {
    asJava.getChoices().asScala.map(x => x.asInstanceOf[String])
  }

  /**
    * Sets the default value of this option
    */
  def setDefaultValue(value: String) = {
    asJava.setDefaultValue(value)
    this
  }
  def getDefaultValue: String = {
    asJava.getDefaultValue().asInstanceOf[String]
  }

  /**
    * Sets te description of this option.
    */
  def setDescription(value: String) = {
    asJava.setDescription(value)
    this
  }
  def getDescription: String = {
    asJava.getDescription().asInstanceOf[String]
  }

  /**
    * Configures the current <a href="../../../../../../../cheatsheet/Option.html">Option</a> to be a flag. It will be evaluated to `true` if it's found in
    * the command line. If you need a flag that may receive a value, use, in this order:
    * <code><pre>
    *   option.setFlag(true).setSingleValued(true)
    * </pre></code>
    */
  def setFlag(value: Boolean) = {
    asJava.setFlag(value)
    this
  }
  def isFlag: Boolean = {
    asJava.isFlag().asInstanceOf[Boolean]
  }

  /**
    * Sets whether or not this option is a "help" option
    */
  def setHelp(value: Boolean) = {
    asJava.setHelp(value)
    this
  }
  def isHelp: Boolean = {
    asJava.isHelp().asInstanceOf[Boolean]
  }

  /**
    * Sets whether or not this option should be hidden
    */
  def setHidden(value: Boolean) = {
    asJava.setHidden(value)
    this
  }
  def isHidden: Boolean = {
    asJava.isHidden().asInstanceOf[Boolean]
  }

  /**
    * Sets the long name of this option.
    */
  def setLongName(value: String) = {
    asJava.setLongName(value)
    this
  }
  def getLongName: String = {
    asJava.getLongName().asInstanceOf[String]
  }

  /**
    * Sets whether or not this option can receive several values.
    */
  def setMultiValued(value: Boolean) = {
    asJava.setMultiValued(value)
    this
  }
  def isMultiValued: Boolean = {
    asJava.isMultiValued().asInstanceOf[Boolean]
  }

  /**
    */

  /**
    * Sets whether or not this option is mandatory.
    */
  def setRequired(value: Boolean) = {
    asJava.setRequired(value)
    this
  }
  def isRequired: Boolean = {
    asJava.isRequired().asInstanceOf[Boolean]
  }

  /**
    * Sets the short name of this option.
    */
  def setShortName(value: String) = {
    asJava.setShortName(value)
    this
  }
  def getShortName: String = {
    asJava.getShortName().asInstanceOf[String]
  }

  /**
    * Sets whether or not this option can receive a value.
    */
  def setSingleValued(value: Boolean) = {
    asJava.setSingleValued(value)
    this
  }
  def isSingleValued: Boolean = {
    asJava.isSingleValued().asInstanceOf[Boolean]
  }
}

object Option {
  
  def apply() = {
    new Option(new JOption(emptyObj()))
  }
  
  def apply(t: JOption) = {
    if (t != null) {
      new Option(t)
    } else {
      null
    }
  }
  
  def fromJson(json: JsonObject): Option = {
    if (json != null) {
      new Option(new JOption(json))
    } else {
      null
    }
  }
}
