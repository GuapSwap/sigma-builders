package printers.minting_printers

import org.ergoplatform.appkit.{ErgoClient, ErgoValue, InputBox, JavaHelpers, NetworkType}
import printers.BoxPrinter
import special.collection.Coll

import java.nio.charset.Charset
import scala.collection.JavaConverters._
import scala.reflect._


abstract class EIP4IssuanceBoxPrinter extends BoxPrinter {

  protected def printDecodedEIP4IssuanceRegisters(box: InputBox): Unit = {

    println("Register 4 (token name): " + decoders.minting_decoders.EIP4PictureNFTDecoder.decodeTokenName(box.getRegisters.get(0).toHex)._2)
    println("Register 5 (token description): " + decoders.minting_decoders.EIP4PictureNFTDecoder.decodeTokenDescription(box.getRegisters.get(1).toHex)._2)
    println("Register 6 (number of decimals): " + decoders.minting_decoders.EIP4PictureNFTDecoder.decodeTokenDecimals(box.getRegisters.get(2).toHex)._2)
    println("Register 7 (asset type): " + decoders.minting_decoders.EIP4PictureNFTDecoder.decodeAssetType(box.getRegisters.get(3).toHex)._2.mkString("[", ", ", "]"))

  }

}
