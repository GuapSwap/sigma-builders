package builders.tx_builders

import org.ergoplatform.appkit.OutBox

abstract class EIP4TokenMintingTxBuilder extends TxBuilder {

  val eip4IssuanceBox: OutBox

}
