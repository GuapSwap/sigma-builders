package org.guapswap.sigmabuilders.builders.box_builders.minting_box_builders

import org.guapswap.sigmabuilders.builders.box_builders.BoxBuilder

import org.ergoplatform.appkit.Eip4Token

abstract class EIP4TokenIssuanceBoxBuilder extends BoxBuilder {

  val eip4Token: Eip4Token

}
