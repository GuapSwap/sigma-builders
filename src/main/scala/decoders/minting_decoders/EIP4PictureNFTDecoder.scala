package decoders.minting_decoders

import org.ergoplatform.appkit.{ErgoValue, JavaHelpers}
import special.collection.Coll

import java.nio.charset.StandardCharsets

object EIP4PictureNFTDecoder extends EIP4IssuanceDecoder {

  def decodePictureContent(register8Hex: String): (ErgoValue[Coll[Byte]], String) = {

    val ev = ErgoValue.fromHex(register8Hex).asInstanceOf[ErgoValue[Coll[Byte]]]
    val str = JavaHelpers.collToByteArray(ev.getValue).map("%02x".format(_)).mkString

    (ev, str)

  }

  def decodePictureLink(register9Hex: String): (ErgoValue[Coll[Byte]], String) = {

    val ev = ErgoValue.fromHex(register9Hex).asInstanceOf[ErgoValue[Coll[Byte]]]
    val str = new String(JavaHelpers.collToByteArray(ev.getValue), StandardCharsets.UTF_8)

    (ev, str)

  }

}
