name := "06_options_app"

version := "0.1"

exportJars := true

scalaVersion := "2.11.7"

libraryDependencies ++= {
  Seq(
    "org.scalacheck"      %%  "scalacheck" % "1.13.0" % "test",
    "org.scalatest"       %%  "scalatest" % "2.2.6" % "test",
    "org.specs2"          %%  "specs2" % "3.7" % "test"
  )
}

