package org.guapswap.sigmabuilders.encoders.minting_encoders

import org.ergoplatform.appkit.ErgoValue
import scorex.crypto.hash.Sha256
import special.collection.Coll

import java.nio.charset.StandardCharsets

object EIP4PictureNFTEncoder extends EIP4IssuanceEncoder {

  def encodeR8(pictureContent: String): ErgoValue[Coll[java.lang.Byte]] = {

    val pictureHash: Array[Byte] = Sha256.hash(pictureContent)
    ErgoValue.of(pictureHash)

  }

  def encodeR9(pictureLink: String): ErgoValue[Coll[java.lang.Byte]] = {

    val pictureLinkByteArray: Array[Byte] = pictureLink.getBytes(StandardCharsets.UTF_8)
    ErgoValue.of(pictureLinkByteArray)

  }

}
