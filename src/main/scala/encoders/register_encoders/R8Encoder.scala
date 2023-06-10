package encoders.register_encoders

import org.ergoplatform.appkit.ErgoValue

trait R8Encoder[T, U] {

  def encodeR8(data: T): ErgoValue[U]

}
