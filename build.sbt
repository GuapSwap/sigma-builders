lazy val root = (project in file("."))
  .settings(
    name := "sigma-builders",

    version := "0.1.0",

    scalaVersion := "2.12.15",

    libraryDependencies ++= Seq (
      "org.ergoplatform" %% "ergo-appkit" % "5.0.2"
    ),

    assembly / assemblyJarName := s"${name.value}-${version.value}.jar",
    assembly / assemblyOutputPath := file(s"./${name.value}-${version.value}.jar/")
  )


inThisBuild(List(
  organization := "org.guapswap", // group id
  name := "sigma-builders", // artifact id
  homepage := Some(url("https://guapswap.org")),
  licenses := Seq("MIT" -> url("https://opensource.org/licenses/MIT")),
  description := "Easy to use library for creating protocol abstractions interacting with Ergo blockchain.",
  scmInfo := Some(
    ScmInfo(
      url("https://github.com/GuapSwap/sigma-builders"),
      "scm:git@github.com:GuapSwap/sigma-builders.git"
    )
  ),
  developers := List(
    Developer(
      "lgd",
      "Luca D'Angelo",
      "ldgaetano@protonmail.com",
      url("https://github.com/lucagdangelo")
    )
  ),
  sonatypeCredentialHost := "s01.oss.sonatype.org",
  sonatypeRepository := "https://s01.oss.sonatype.org/service/local",


))