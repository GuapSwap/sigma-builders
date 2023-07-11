package printers.minting_printers

import printers.BoxPrinter

import org.ergoplatform.appkit.{InputBox, NetworkType}


object EIP24IssuerBoxPrinter extends BoxPrinter {

  override def printDecodedBox(box: InputBox, networkType: NetworkType): Unit = {

    printRawReservedRegisters(box)

    printVersion(box)
    printRoyaltyInfo(box, networkType)
    printTraits(box)
    printCollectionTokenId(box)
    printAdditionalInformation(box)

  }


  private def printVersion(box: InputBox): Unit = {

    val data = decoders.minting_decoders.EIP24IssuerDecoder.decodeArtworkStandardVersion(box.getRegisters.get(0).toHex)._2
    val version = String.valueOf(data)

    println("Register 4 (artwork standard version): " + version)

  }

  private def printRoyaltyInfo(box: InputBox, networkType: NetworkType): Unit = {

    val data = decoders.minting_decoders.EIP24IssuerDecoder.decodeRoyaltyInfo(box.getRegisters.get(1).toHex, networkType)._2
    val info = data.map(d => d.toString()).mkString("[", ", ", "]")

    println("Register 5 (royalty recipients): " +  info)

  }

  private def printTraits(box: InputBox): Unit = {

    val data = decoders.minting_decoders.EIP24IssuerDecoder.decodeTraits(box.getRegisters.get(2).toHex)._2
    val properties = data._1.map(p => p.toString()).mkString("[", ", ", "]")
    val levels = data._2.map(l => l.toString()).mkString("[", ", ", "]")
    val statistics = data._3.map(s => s.toString()).mkString("[", ", ", "]")

    val traits = "{ properties: " + properties + ", levels: " + levels + ", statistics: " + statistics + " }"

    println("Register 6 (traits): " + traits)

  }

  private def printCollectionTokenId(box: InputBox): Unit = {

    val data = decoders.minting_decoders.EIP24IssuerDecoder.decodeCollectionId(box.getRegisters.get(3).toHex)._2
    val collId = data.toString

    println("Register 7 (collection token id): " + collId)

  }

  private def printAdditionalInformation(box: InputBox): Unit = {

    val data = decoders.minting_decoders.EIP24IssuerDecoder.decodeAdditionalInformation(box.getRegisters.get(4).toHex)._2
    val info = data.map(i => i.toString()).mkString("[", ", ", "]")

    println("Register 8 (additional information): " + info)

  }

}
