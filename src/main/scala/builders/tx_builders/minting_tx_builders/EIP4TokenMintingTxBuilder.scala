package org.guapswap.sigmabuilders.builders.tx_builders.minting_tx_builders

import org.guapswap.sigmabuilders.builders.tx_builders.TxBuilder

import org.ergoplatform.appkit.OutBox

abstract class EIP4TokenMintingTxBuilder extends TxBuilder {

  val eip4IssuanceBox: OutBox

}
