package encoders

import org.ergoplatform.appkit.ErgoValue
import special.collection.Coll
import encoders.register_encoders.{R4Encoder, R5Encoder, R6Encoder, R7Encoder}

trait EIP4IssuanceEncoder extends R4Encoder[String, Coll[java.lang.Byte]]
    with R5Encoder[String, Coll[java.lang.Byte]]
    with R6Encoder[String, Coll[java.lang.Byte]]
    with R7Encoder[Array[Byte], Coll[java.lang.Byte]] {

  override def encodeR4(tokenName: String): ErgoValue[Coll[java.lang.Byte]] = {

    val nameByteArray: Array[Byte] = tokenName.getBytes("UTF-8")
    ErgoValue.of(nameByteArray)

  }

  override def encodeR5(tokenDescription: String): ErgoValue[Coll[java.lang.Byte]] = {

    val descriptionByteArray: Array[Byte] = tokenDescription.getBytes("UTF-8")
    ErgoValue.of(descriptionByteArray)

  }

  override def encodeR6(tokenDecimals: String): ErgoValue[Coll[java.lang.Byte]] = {

    val decimalsByteArray: Array[Byte] = tokenDecimals.getBytes("UTF-8")
    ErgoValue.of(decimalsByteArray)

  }

  override def encodeR7(assetType: Array[Byte]): ErgoValue[Coll[java.lang.Byte]] = {

    assert(assetType.length == 2)
    ErgoValue.of(assetType)

  }

}
