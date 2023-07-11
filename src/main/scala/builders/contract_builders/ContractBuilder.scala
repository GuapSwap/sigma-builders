package org.guapswap.sigmabuilders.builders.contract_builders

import org.ergoplatform.appkit.{BlockchainContext, ErgoContract}

trait ContractBuilder {

  val script: String

  def toErgoContract(implicit ctx: BlockchainContext): ErgoContract

}
