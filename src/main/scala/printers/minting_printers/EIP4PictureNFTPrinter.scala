package org.guapswap.sigmabuilders.printers.minting_printers

import org.guapswap.sigmabuilders._
import org.ergoplatform.appkit.{InputBox, NetworkType}

object EIP4PictureNFTPrinter extends EIP4IssuanceBoxPrinter {

  override def printDecodedBox(box: InputBox, networkType: NetworkType): Unit = {

    printRawReservedRegisters(box)
    printDecodedEIP4IssuanceRegisters(box)

    println("Register 8 (sha256 picture hash): " + decoders.minting_decoders.EIP4PictureNFTDecoder.decodePictureContent(box.getRegisters.get(8).toHex)._2)
    println("Register 9 (picture link): " + decoders.minting_decoders.EIP4PictureNFTDecoder.decodeTokenName(box.getRegisters.get(9).toHex)._2)

  }

}
