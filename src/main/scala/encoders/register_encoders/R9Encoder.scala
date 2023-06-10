package encoders.register_encoders

import org.ergoplatform.appkit.ErgoValue

trait R9Encoder[T, U] {

  def encodeR9(data: T): ErgoValue[U]

}
