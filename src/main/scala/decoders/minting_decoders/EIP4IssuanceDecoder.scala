package decoders.minting_decoders

import encoders.BoxEncoder
import org.ergoplatform.appkit.{ErgoValue, JavaHelpers}
import special.collection.Coll

import java.nio.charset.StandardCharsets

abstract class EIP4IssuanceDecoder extends BoxEncoder {

  def decodeTokenName(register4Hex: String): (ErgoValue[Coll[Byte]], String) = {

    val ev = ErgoValue.fromHex(register4Hex).asInstanceOf[ErgoValue[Coll[Byte]]]
    val str = new String(JavaHelpers.collToByteArray(ev.getValue), StandardCharsets.UTF_8)

    (ev, str)

  }

  def decodeTokenDescription(register5Hex: String): (ErgoValue[Coll[Byte]], String) = {

    val ev = ErgoValue.fromHex(register5Hex).asInstanceOf[ErgoValue[Coll[Byte]]]
    val str = new String(JavaHelpers.collToByteArray(ev.getValue), StandardCharsets.UTF_8)

    (ev, str)

  }

  def decodeTokenDecimals(register6Hex: String): (ErgoValue[Coll[Byte]], String) = {

    val ev = ErgoValue.fromHex(register6Hex).asInstanceOf[ErgoValue[Coll[Byte]]]
    val str = new String(JavaHelpers.collToByteArray(ev.getValue), StandardCharsets.UTF_8)

    (ev, str)

  }

  def decodeAssetType(register7Hex: String): (ErgoValue[Coll[Byte]], Array[Byte]) = {

    val ev = ErgoValue.fromHex(register7Hex).asInstanceOf[ErgoValue[Coll[Byte]]]
    val value = ev.getValue.toArray

    (ev, value)

  }

}
