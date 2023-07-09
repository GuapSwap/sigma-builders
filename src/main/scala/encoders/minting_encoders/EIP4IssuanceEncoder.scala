package encoders.minting_encoders

import encoders.BoxEncoder

import org.ergoplatform.appkit.ErgoValue
import special.collection.Coll

import java.nio.charset.StandardCharsets

import scala.language.higherKinds

trait EIP4IssuanceEncoder extends BoxEncoder {

  def encodeR4(tokenName: String): ErgoValue[Coll[java.lang.Byte]] = {

    val nameByteArray: Array[Byte] = tokenName.getBytes(StandardCharsets.UTF_8)
    ErgoValue.of(nameByteArray)

  }

  def encodeR5(tokenDescription: String): ErgoValue[Coll[java.lang.Byte]] = {

    val descriptionByteArray: Array[Byte] = tokenDescription.getBytes(StandardCharsets.UTF_8)
    ErgoValue.of(descriptionByteArray)

  }

  def encodeR6(tokenDecimals: String): ErgoValue[Coll[java.lang.Byte]] = {

    val decimalsByteArray: Array[Byte] = tokenDecimals.getBytes(StandardCharsets.UTF_8)
    ErgoValue.of(decimalsByteArray)

  }

  def encodeR7(assetType: Array[Byte]): ErgoValue[Coll[java.lang.Byte]] = {

    assert(assetType.length == 2)
    ErgoValue.of(assetType)

  }

}
