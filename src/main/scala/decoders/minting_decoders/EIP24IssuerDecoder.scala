package org.guapswap.sigmabuilders.decoders.minting_decoders

import org.guapswap.sigmabuilders.encoders.BoxEncoder

import org.ergoplatform.appkit.{Address, ErgoId, ErgoValue, JavaHelpers, NetworkType}
import special.collection.Coll

import java.nio.charset.StandardCharsets

object EIP24IssuerDecoder extends BoxEncoder {

  def decodeArtworkStandardVersion(register4Hex: String): (ErgoValue[Int], Int) = {

    val ev = ErgoValue.fromHex(register4Hex).asInstanceOf[ErgoValue[Int]]
    val value = ev.getValue

    (ev, value)

  }

  def decodeRoyaltyInfo(register5Hex: String, networkType: NetworkType): (ErgoValue[Coll[(Coll[Byte], Int)]], Array[(Address, Int)]) = {

    val ev = ErgoValue.fromHex(register5Hex).asInstanceOf[ErgoValue[Coll[(Coll[Byte], Int)]]]
    val value = ev.getValue.toArray.map((r: (Coll[Byte], Int)) => (Address.fromPropositionBytes(networkType, JavaHelpers.collToByteArray(r._1)), r._2))

    (ev, value)

  }

  def decodeTraits(register6Hex: String): (ErgoValue[(Coll[(Coll[Byte], Coll[Byte])], (Coll[(Coll[Byte], (Int, Int))], Coll[(Coll[Byte], (Int, Int))]))], (Array[(String, String)], Array[(String, (Int, Int))], Array[(String, (Int, Int))])) = {

    val ev = ErgoValue.fromHex(register6Hex).asInstanceOf[ErgoValue[(Coll[(Coll[Byte], Coll[Byte])], (Coll[(Coll[Byte], (Int, Int))], Coll[(Coll[Byte], (Int, Int))]))]]

    val properties = ev.getValue._1.toArray
    val levels = ev.getValue._2._1.toArray
    val statistics = ev.getValue._2._2.toArray

    val props = properties.map(p => (new String(JavaHelpers.collToByteArray(p._1), StandardCharsets.UTF_8), new String(JavaHelpers.collToByteArray(p._2), StandardCharsets.UTF_8)))
    val levs = levels.map(l => (new String(JavaHelpers.collToByteArray(l._1)), l._2))
    val stats = statistics.map(s => (new String(JavaHelpers.collToByteArray(s._1)), s._2))

    val traits = (props, levs, stats)

    (ev, traits)

  }

  def decodeCollectionId(register7Hex: String): (ErgoValue[Coll[Byte]], ErgoId) = {

    val ev = ErgoValue.fromHex(register7Hex).asInstanceOf[ErgoValue[Coll[Byte]]]
    val value = ErgoId.create(JavaHelpers.collToByteArray(ev.getValue).map("%02x".format(_)).mkString)

    (ev, value)

  }

  def decodeAdditionalInformation(register8Hex: String): (ErgoValue[Coll[(Coll[Byte], Coll[Byte])]], Array[(String, String)]) = {

    val ev = ErgoValue.fromHex(register8Hex).asInstanceOf[ErgoValue[Coll[(Coll[Byte], Coll[Byte])]]]
    val info = ev.getValue.map(i => (new String(JavaHelpers.collToByteArray(i._1), StandardCharsets.UTF_8), new String(JavaHelpers.collToByteArray(i._2), StandardCharsets.UTF_8))).toArray

    (ev, info)

  }

}
