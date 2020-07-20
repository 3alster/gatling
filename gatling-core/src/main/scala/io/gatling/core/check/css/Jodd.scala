/*
 * Copyright 2011-2020 GatlingCorp (https://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.gatling.core.check.css

import jodd.lagarto.LagartoParser
import jodd.lagarto.dom.{ LagartoDOMBuilder, LagartoDomBuilderConfig }
import jodd.log.LoggerFactory
import jodd.log.impl.Slf4jLogger

object Jodd {

  LoggerFactory.setLoggerProvider(Slf4jLogger.PROVIDER)

  private val JoddConfig =
    new LagartoDomBuilderConfig()
      .setParsingErrorLogLevelName("INFO")
      .setCaseSensitive(false)
      .setEnableConditionalComments(false)

  def newLagartoDomBuilder: LagartoDOMBuilder = {
    val domBuilder = new LagartoDOMBuilder
    domBuilder.setConfig(JoddConfig)
    domBuilder
  }

  def newLagartoParser(chars: Array[Char]): LagartoParser = {
    val lagartoParser = new LagartoParser(chars)
    lagartoParser.setConfig(JoddConfig)
    lagartoParser
  }
}
