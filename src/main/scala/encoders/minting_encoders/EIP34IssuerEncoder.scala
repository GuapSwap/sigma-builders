package encoders.minting_encoders

import encoders.BoxEncoder
import org.ergoplatform.appkit.{Address, ErgoId, ErgoType, ErgoValue}
import special.collection.Coll

import java.nio.charset.StandardCharsets

object EIP34IssuerEncoder extends BoxEncoder {

  def encodeR4(collectionStandardVersion: Int): ErgoValue[java.lang.Integer] = {

    ErgoValue.of(collectionStandardVersion)

  }

  def encodeR5(collectionInfo: Array[String]): ErgoValue[Coll[Coll[java.lang.Byte]]] = {

    assert(collectionInfo.length == 4)

    val infos: Array[Array[Byte]] = collectionInfo.map((i: String) => i.getBytes(StandardCharsets.UTF_8))
    val infos1: Array[Coll[java.lang.Byte]] = infos.map((i: Array[Byte]) => ErgoValue.of(i).getValue)

    ErgoValue.of(infos1, ErgoType.collType(ErgoType.byteType()))

  }

  def encodeR6(socials: Array[(String, String)]): ErgoValue[Coll[(Coll[java.lang.Byte], Coll[java.lang.Byte])]] = {

    val socs: Array[(Array[Byte], Array[Byte])] = socials.map((s: (String, String)) => (s._1.toLowerCase().getBytes(StandardCharsets.UTF_8), s._2.getBytes(StandardCharsets.UTF_8)))
    val socs1: Array[(Coll[java.lang.Byte], Coll[java.lang.Byte])] = socs.map((s: (Array[Byte], Array[Byte])) => ErgoValue.pairOf(ErgoValue.of(s._1), ErgoValue.of(s._2)).getValue)

    ErgoValue.of(socs1, ErgoType.pairType(ErgoType.collType(ErgoType.byteType()), ErgoType.collType(ErgoType.byteType())))

  }

  def encodeR7(mintingExpiry: Long): ErgoValue[java.lang.Long] = {

    assert(mintingExpiry == -1 || mintingExpiry > 0)

    ErgoValue.of(mintingExpiry)

  }

  def encodeR8(additionalInformation: Array[(String, String)]): ErgoValue[Coll[(Coll[java.lang.Byte], Coll[java.lang.Byte])]] = {

    val infos: Array[(Array[Byte], Array[Byte])] = additionalInformation.map((i: (String, String)) => (i._1.getBytes(StandardCharsets.UTF_8), i._2.getBytes(StandardCharsets.UTF_8)))
    val infos1: Array[(Coll[java.lang.Byte], Coll[java.lang.Byte])] = infos.map((i: (Array[Byte], Array[Byte])) => ErgoValue.pairOf(ErgoValue.of(i._1), ErgoValue.of(i._2)).getValue)

    ErgoValue.of(infos1, ErgoType.pairType(ErgoType.collType(ErgoType.byteType()), ErgoType.collType(ErgoType.byteType())))

  }

}
