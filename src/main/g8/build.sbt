import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "$scala_version$",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "$name$",
    libraryDependencies ++= Seq(
      scalaTest % Test,
      lwjgl,
      lwjgl_natives,
      lwjgl_opengl,
      lwjgl_opengl_natives % Runtime,
      lwjgl_stb,
      lwjgl_stb_natives % Runtime,
      lwjgl_glfw,
      lwjgl_glfw_natives % Runtime,
      lwjgl_jemalloc,
      lwjgl_jemalloc_natives % Runtime
    )
  )

fork in run := true
javaOptions in run += {
  if (System.getProperty("os.name").split(" ")(0).toLowerCase() == "mac"){
    "-XstartOnFirstThread"
  } else {
    ""
  }
}
