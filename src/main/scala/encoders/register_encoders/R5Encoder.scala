package encoders.register_encoders

import org.ergoplatform.appkit.ErgoValue

trait R5Encoder[T, U] {

  def encodeR5(data: T): ErgoValue[U]

}
