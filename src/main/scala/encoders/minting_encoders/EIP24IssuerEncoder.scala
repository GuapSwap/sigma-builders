package encoders.minting_encoders

import encoders.BoxEncoder

import org.ergoplatform.appkit.{Address, ErgoId, ErgoType, ErgoValue}
import special.collection.Coll

import java.nio.charset.StandardCharsets

object EIP24IssuerEncoder extends BoxEncoder {

  def encodeR4(artworkStandardVersion: Int): ErgoValue[java.lang.Integer] = {

    ErgoValue.of(artworkStandardVersion)

  }

  def encodeR5(royaltyInfo: Array[(Address, Int)]): ErgoValue[Coll[(Coll[java.lang.Byte], java.lang.Integer)]] = {

    val recs: Array[(Array[Byte], Int)] = royaltyInfo.map((r: (Address, Int)) => (r._1.toPropositionBytes, r._2))
    val recs1: Array[(Coll[java.lang.Byte], Integer)] = recs.map((r: (Array[Byte], Int)) => ErgoValue.pairOf(ErgoValue.of(r._1), ErgoValue.of(r._2)).getValue)

    ErgoValue.of(recs1, ErgoType.pairType(ErgoType.collType(ErgoType.byteType()), ErgoType.integerType()))

  }

  def encodeR6(properties: Array[(String, String)], levels: Array[(String, (Int, Int))], statistics: Array[(String, (Int, Int))]): ErgoValue[(Coll[(Coll[java.lang.Byte], Coll[java.lang.Byte])], ((Coll[java.lang.Byte], (Integer, Integer)), (Coll[java.lang.Byte], (Integer, Integer))))] = {

    val props: Array[(Array[Byte], Array[Byte])] = properties.map((p: (String, String)) => (p._1.getBytes(StandardCharsets.UTF_8), p._2.getBytes(StandardCharsets.UTF_8)))
    val props1: Array[(Coll[java.lang.Byte], Coll[java.lang.Byte])] = props.map((p: (Array[Byte], Array[Byte])) => ErgoValue.pairOf(ErgoValue.of(p._1), ErgoValue.of(p._2)).getValue)
    val processedProperties: ErgoValue[Coll[(Coll[java.lang.Byte], Coll[java.lang.Byte])]] = ErgoValue.of(props1, ErgoType.pairType(ErgoType.collType(ErgoType.byteType()), ErgoType.collType(ErgoType.byteType())))

    val levs: Array[(Array[Byte], (Int, Int))] = levels.map((l: (String, (Int, Int))) => (l._1.getBytes(StandardCharsets.UTF_8), l._2))
    val levs1: Array[(Coll[java.lang.Byte], (Integer, Integer))] = levs.map((l: (Array[Byte], (Int, Int))) => ErgoValue.pairOf(ErgoValue.of(l._1), ErgoValue.pairOf(ErgoValue.of(l._2._1), ErgoValue.of(l._2._1))).getValue)
    val processedLevels: ErgoValue[Coll[(Coll[java.lang.Byte], (Integer, Integer))]] = ErgoValue.of(levs1, ErgoType.pairType(ErgoType.collType(ErgoType.byteType()), ErgoType.pairType(ErgoType.integerType(), ErgoType.integerType())))

    val stats: Array[(Array[Byte], (Int, Int))] = statistics.map((s: (String, (Int, Int))) => (s._1.getBytes(StandardCharsets.UTF_8), s._2))
    val stats1: Array[(Coll[java.lang.Byte], (Integer, Integer))] = stats.map((s: (Array[Byte], (Int, Int))) => ErgoValue.pairOf(ErgoValue.of(s._1), ErgoValue.pairOf(ErgoValue.of(s._2._1), ErgoValue.of(s._2._1))).getValue)
    val processedStatistics: ErgoValue[Coll[(Coll[java.lang.Byte], (Integer, Integer))]] = ErgoValue.of(stats1, ErgoType.pairType(ErgoType.collType(ErgoType.byteType()), ErgoType.pairType(ErgoType.integerType(), ErgoType.integerType())))

    ErgoValue.pairOf(processedProperties, ErgoValue.pairOf(processedLevels, processedStatistics))

  }

  def encodeR7(collectionTokenId: ErgoId): ErgoValue[Coll[java.lang.Byte]] = {

    ErgoValue.of(collectionTokenId.getBytes)

  }

  def encodeR8(additionalInformation: Array[(String, String)]): ErgoValue[Coll[(Coll[java.lang.Byte], Coll[java.lang.Byte])]] = {

    assert(additionalInformation(0)._1.equals("explicit"))
    val infos: Array[(Array[Byte], Array[Byte])] = additionalInformation.map((i: (String, String)) => (i._1.getBytes(StandardCharsets.UTF_8), i._2.getBytes(StandardCharsets.UTF_8)))
    val infos1: Array[(Coll[java.lang.Byte], Coll[java.lang.Byte])] = infos.map((i: (Array[Byte], Array[Byte])) => ErgoValue.pairOf(ErgoValue.of(i._1), ErgoValue.of(i._2)).getValue)

    ErgoValue.of(infos1, ErgoType.pairType(ErgoType.collType(ErgoType.byteType()), ErgoType.collType(ErgoType.byteType())))

  }

}
