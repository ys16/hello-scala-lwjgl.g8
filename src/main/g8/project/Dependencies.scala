import sbt._

object Dependencies {
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.1"
  lazy val lwjgl = "org.lwjgl" % "lwjgl" % "3.1.1"
  lazy val lwjgl_natives = lwjgl classifier "natives-macos" classifier "natives-windows"
  lazy val lwjgl_opengl = "org.lwjgl" % "lwjgl-opengl" % "3.1.1"
  lazy val lwjgl_opengl_natives = lwjgl_opengl classifier "natives-macos" classifier "natives-windows"

  lazy val lwjgl_glfw = "org.lwjgl" % "lwjgl-glfw" % "3.1.1"
  lazy val lwjgl_glfw_natives = lwjgl_glfw classifier "natives-macos" classifier "natives-windows"

  lazy val lwjgl_stb = "org.lwjgl" % "lwjgl-stb" % "3.1.1"
  lazy val lwjgl_stb_natives = lwjgl_stb classifier "natives-macos" classifier "natives-windows"

  lazy val lwjgl_jemalloc = "org.lwjgl" % "lwjgl-jemalloc" % "3.1.1"
  lazy val lwjgl_jemalloc_natives = lwjgl_jemalloc classifier "natives-macos" classifier "natives-windows"
}
