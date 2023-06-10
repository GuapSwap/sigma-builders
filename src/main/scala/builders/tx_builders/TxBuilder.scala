package builders.tx_builders

import org.ergoplatform.appkit.{Address, UnsignedTransaction, UnsignedTransactionBuilder}

trait TxBuilder {

  val txFee: Long
  val changeAddress: Address

  def build(implicit txBuilder: UnsignedTransactionBuilder): UnsignedTransaction

}
