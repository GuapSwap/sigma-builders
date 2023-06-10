package builders.box_builders

import org.ergoplatform.appkit.{ErgoContract, OutBox, OutBoxBuilder}

trait BoxBuilder {

  val value: Long
  val contract: ErgoContract

  def toOutBox(implicit outBoxBuilder: OutBoxBuilder): OutBox

}
