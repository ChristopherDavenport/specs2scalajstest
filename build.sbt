import sbtcrossproject.CrossPlugin.autoImport.{crossProject, CrossType}


val specs2V = "4.9.4"

// Projects
lazy val `specs2jstest` = project.in(file("."))
  .aggregate(core.js)

lazy val core = crossProject(JSPlatform)
  .crossType(CrossType.Pure)
  .in(file("core"))
  .settings(commonSettings)
  .settings(
    name := "specs2jstest"
  )


// General Settings
lazy val commonSettings = Seq(
  scalaVersion := "2.13.1",
  crossScalaVersions := Seq(scalaVersion.value, "2.12.10"),

  libraryDependencies ++= Seq(
    "org.specs2"                  %%% "specs2-core"                % specs2V       % Test,
  )
)

// General Settings
inThisBuild(List(
  organization := "io.chrisdavenport",
  developers := List(
    Developer("ChristopherDavenport", "Christopher Davenport", "chris@christopherdavenport.tech", url("https://github.com/ChristopherDavenport"))
  ),

  homepage := Some(url("https://github.com/ChristopherDavenport/specs2jstest")),
  licenses += ("MIT", url("http://opensource.org/licenses/MIT")),

  pomIncludeRepository := { _ => false},
  scalacOptions in (Compile, doc) ++= Seq(
      "-groups",
      "-sourcepath", (baseDirectory in LocalRootProject).value.getAbsolutePath,
      "-doc-source-url", "https://github.com/ChristopherDavenport/specs2jstest/blob/v" + version.value + "€{FILE_PATH}.scala"
  )
))