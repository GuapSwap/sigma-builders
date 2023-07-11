package org.guapswap.sigmabuilders.printers

import org.ergoplatform.appkit.{InputBox, NetworkType}

import scala.collection.JavaConverters._

trait BoxPrinter {

  def printRawBox(box: InputBox): Unit = {

    printRawReservedRegisters(box)
    printRawDataRegisters(box)

  }


  protected def printRawReservedRegisters(box: InputBox): Unit = {

    println("Printing reserved register data")

    println("Register 0 (value): " + box.getValue)
    println("Register 1 (ergotree): " + box.getErgoTree.bytesHex)
    println("Register 2 (tokens): " + box.getTokens.asScala.toList.mkString("[", ", ", "]"))
    println("Register 3 (creation height): " + box.getCreationHeight)
    println("Register 3 (tx id): " + box.getTransactionId)
    println("Register 3 (tx index): " + box.getTransactionIndex)

  }

  protected def printRawDataRegisters(box: InputBox): Unit = {

    println("Printing data register data")

    for (i <- 0 until box.getRegisters.size) {

      val regIndex: Int = i + 4
      val reg = box.getRegisters.get(i)
      val decodedValue: String = reg.toString

      println(s"Register $regIndex: $decodedValue")

    }

  }

  def printDecodedBox(box: InputBox, networkType: NetworkType): Unit

}
