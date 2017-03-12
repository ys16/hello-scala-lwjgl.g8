package $package$

import org.lwjgl.glfw.{GLFWErrorCallback, GLFWKeyCallbackI}
import org.lwjgl.glfw.GLFW._
import org.lwjgl.glfw.Callbacks._
import org.lwjgl.opengl._
import org.lwjgl.opengl.GL11._
import org.lwjgl.system.MemoryStack._

object $name;format="Camel"$ {
  def main(args: Array[String]): Unit = {
    new $name;format="Camel"$().run()
  }
}

class $name;format="Camel"$(){


  def init(): Long = {

    GLFWErrorCallback.createPrint(System.err).set
    if (!glfwInit() )
      throw new IllegalStateException("Unable to initialize GLFW")

    glfwDefaultWindowHints()
    glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE)
    glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE)

    val window = glfwCreateWindow(300, 300, "Hello LWJGL",0, 0 )

    glfwSetKeyCallback(window, new GLFWKeyCallbackI {
      override def invoke(window: Long, key: Int, scancode: Int, action: Int, mods: Int) = {
        if(key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE ) {
          glfwSetWindowShouldClose(window, true)
        }
      }
    })
    try {
      val stack = stackPush()
      val pWidth = stack.mallocInt(1)
      val pHeight = stack.mallocInt(1)

      glfwGetWindowSize(window, pWidth, pHeight)
      val vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor())

      glfwSetWindowPos(window,
        (vidmode.width - pWidth.get(0)) /2,
        (vidmode.height - pHeight.get(0)) /2)
    }
    catch{
      case e: Exception => e.printStackTrace();throw e
    }

    glfwMakeContextCurrent(window)

    glfwSwapInterval(1)

    glfwShowWindow(window)

    window
  }

  def run(): Unit = {
    val window = init()
    loop(window)

    glfwFreeCallbacks(window)
    glfwDestroyWindow(window)

    glfwTerminate()
    glfwSetErrorCallback(null).free()
  }

  def loop(window: Long): Unit = {
    def pool(): Unit = {
      glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)

      // Somthing OpenGL Operation
      //glBegin(GL_TRIANGLES)
      //glVertex3f(-0.6f,0.2f,0.5f)
      //glVertex3f(0.6f,-0.4f,-0.5f)
      //glVertex3f(0.8f,0.6f,0.0f)
      //glEnd()

      glfwSwapBuffers(window)

      glfwPollEvents()

      if (!glfwWindowShouldClose(window)) pool()
    }

    GL.createCapabilities()

    glClearColor(1.0f, 0.0f, 0.0f, 0.0f)

    if (!glfwWindowShouldClose(window)) pool()
  }
}
