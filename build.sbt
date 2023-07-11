import dependencies._

inThisBuild(List(
  organization := "org.guapswap", // group id
  name := "sigmabuilders", // artifact id
  homepage := Some(url("https://guapswap.org")),
  licenses := Seq("GPL-3.0" -> url("https://spdx.org/licenses/GPL-3.0-or-later.html")),
  description := "Easy to use library for creating protocol abstractions interacting with Ergo blockchain.",
  idePackagePrefix := Some("org.guapswap.sigmabuilders"),
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

  libraryDependencies ++=
    Ergo ++
    Testing
  ,

  sonatypeCredentialHost := "s01.oss.sonatype.org",
  sonatypeRepository := "https://s01.oss.sonatype.org/service/local",

  resolvers := List(
    "Sonatype OSS Releases" at "https://s01.oss.sonatype.org/content/repositories/releases",
    "Sonatype OSS Snapshots" at "https://s01.oss.sonatype.org/content/repositories/snapshots"
  ),

  versionScheme := Some ("semver-spec"),
  assembly / assemblyJarName := s"${name.value}-${version.value}.jar",
  assembly / assemblyOutputPath := file(s"./${name.value}-${version.value}.jar/")


))
