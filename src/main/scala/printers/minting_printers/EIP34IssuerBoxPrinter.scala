package org.guapswap.sigmabuilders.printers.minting_printers

import org.guapswap.sigmabuilders.printers.BoxPrinter
import org.guapswap.sigmabuilders.decoders.minting_decoders._

import org.ergoplatform.appkit.{InputBox, NetworkType}

object EIP34IssuerBoxPrinter extends BoxPrinter {

  override def printDecodedBox(box: InputBox, networkType: NetworkType): Unit = {

    printRawReservedRegisters(box)

    printVersion(box)
    printCollectionInfo(box)
    printSocials(box)
    printMintExpiry(box)
    printAdditionalInformation(box)

  }


  private def printVersion(box: InputBox): Unit = {

    val data = EIP34IssuerDecoder.decodeCollectionStandardVersion(box.getRegisters.get(0).toHex)._2
    val version = String.valueOf(data)

    println("Register 4 (collection standard version): " + version)

  }

  private def printCollectionInfo(box: InputBox): Unit = {

    val data = EIP34IssuerDecoder.decodeCollectionInfo(box.getRegisters.get(1).toHex)._2
    val info = data.mkString("[", ", ", "]")

    println("Register 5 (collection info): " +  info)

  }

  private def printSocials(box: InputBox): Unit = {

    val data = EIP34IssuerDecoder.decodeSocials(box.getRegisters.get(2).toHex)._2
    val socials = data.map(s => s.toString()).mkString("[", ", ", "]")

    println("Register 6 (socials): " + socials)

  }

  private def printMintExpiry(box: InputBox): Unit = {

    val data = EIP34IssuerDecoder.decodeMintExpiry(box.getRegisters.get(3).toHex)._2
    val expiry = String.valueOf(data)

    println("Register 7 (mint expiry): " + expiry)

  }

  private def printAdditionalInformation(box: InputBox): Unit = {

    val data = EIP34IssuerDecoder.decodeAdditionalInformation(box.getRegisters.get(4).toHex)._2
    val info = data.map(i => i.toString()).mkString("[", ", ", "]")

    println("Register 8 (additional information): " + info)

  }

}
