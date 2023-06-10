package encoders.minting_encoders

import encoders.register_encoders.{R8Encoder, R9Encoder}
import org.ergoplatform.appkit.ErgoValue
import scorex.crypto.hash.Sha256
import special.collection.Coll

object EIP4PictureNFTEncoder extends EIP4IssuanceEncoder
  with R8Encoder[String, Coll[java.lang.Byte]]
  with R9Encoder[String, Coll[java.lang.Byte]] {

  override def encodeR8(pictureContent: String): ErgoValue[Coll[java.lang.Byte]] = {

    val pictureHash: Array[Byte] = Sha256.hash(pictureContent)
    ErgoValue.of(pictureHash)

  }

  override def encodeR9(pictureLink: String): ErgoValue[Coll[java.lang.Byte]] = {

    val pictureLinkByteArray: Array[Byte] = pictureLink.getBytes("UTF-8")
    ErgoValue.of(pictureLinkByteArray)

  }

}
