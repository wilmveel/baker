package com.ing.baker.runtime.javadsl

import com.ing.baker.runtime.common.LanguageDataStructures.JavaApi
import com.ing.baker.runtime.common.SensoryEventStatus
import com.ing.baker.runtime.{common, scaladsl}
import com.ing.baker.types.Value

import scala.annotation.nowarn
import scala.collection.JavaConverters._

case class SensoryEventResult(
                               sensoryEventStatus: SensoryEventStatus,
                               eventNames: java.util.List[String],
                               ingredients: java.util.Map[String, Value]
) extends common.SensoryEventResult with JavaApi {

  def getSensoryEventStatus: SensoryEventStatus = sensoryEventStatus

  def getEventNames: java.util.List[String] = eventNames

  def getIngredients: java.util.Map[String, Value] = ingredients

  @nowarn
  def asScala: scaladsl.SensoryEventResult =
    scaladsl.SensoryEventResult(sensoryEventStatus, eventNames.asScala.toIndexedSeq, ingredients.asScala.toMap)
}
