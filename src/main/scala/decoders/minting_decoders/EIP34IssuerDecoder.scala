package decoders.minting_decoders

import encoders.BoxEncoder
import org.ergoplatform.appkit.{ErgoType, ErgoValue, JavaHelpers}
import special.collection.Coll

import java.nio.charset.StandardCharsets

object EIP34IssuerDecoder extends BoxEncoder {

  def collectionStandardVersionDecoder(register4Hex: String): (ErgoValue[Int], Int) = {

    val ev = ErgoValue.fromHex(register4Hex).asInstanceOf[ErgoValue[Int]]
    val value = ev.getValue

    (ev, value)

  }

  def decodeCollectionInfo(register5Hex: String): (ErgoValue[Coll[Coll[Byte]]], Array[String]) = {

    val ev = ErgoValue.fromHex(register5Hex).asInstanceOf[ErgoValue[Coll[Coll[Byte]]]]
    val value = ev.getValue.map(v => new String(JavaHelpers.collToByteArray(v), StandardCharsets.UTF_8)).toArray

    (ev, value)

  }

  def decodeSocials(register6Hex: String): (ErgoValue[Coll[(Coll[Byte], Coll[Byte])]], Array[(String, String)]) = {

    val ev = ErgoValue.fromHex(register6Hex).asInstanceOf[ErgoValue[Coll[(Coll[Byte], Coll[Byte])]]]
    val socials = ev.getValue.map(s => (new String(JavaHelpers.collToByteArray(s._1), StandardCharsets.UTF_8), new String(JavaHelpers.collToByteArray(s._2), StandardCharsets.UTF_8))).toArray

    (ev, socials)

  }

  def decodeMintExpiry(register7Hex: String): (ErgoValue[Long], Long) = {

    val ev = ErgoValue.fromHex(register7Hex).asInstanceOf[ErgoValue[Long]]
    val value = ev.getValue

    (ev, value)

  }

  def decodeAdditionalInformation(register8Hex: String): (ErgoValue[Coll[(Coll[Byte], Coll[Byte])]], Array[(String, String)]) = {

    val ev = ErgoValue.fromHex(register8Hex).asInstanceOf[ErgoValue[Coll[(Coll[Byte], Coll[Byte])]]]
    val info = ev.getValue.map(i => (new String(JavaHelpers.collToByteArray(i._1), StandardCharsets.UTF_8), new String(JavaHelpers.collToByteArray(i._2), StandardCharsets.UTF_8))).toArray

    (ev, info)

  }

}
