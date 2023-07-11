import sbt._

object dependencies {

  val Ergo: List[ModuleID] = List(
    "org.scorexfoundation" %% "scrypto" % "2.1.10",
    "org.ergoplatform" %% "ergo-appkit" % "5.0.2",
    "org.scorexfoundation" %% "sigma-state" % "4.0.3"
  )

  val Testing: List[ModuleID] = List(
    "org.scalactic" %% "scalactic" % "3.2.14",
    "org.scalatest" %% "scalatest" % "3.2.14" % "test"
  )

}