import camera.*
import gui.Canvas

import javax.swing.*
import java.awt.*

class Application {
    private val frame: JFrame = JFrame()
    private val canvas: JPanel

    init {
        frame.title = "Wirtualna Kamera"
        frame.setSize(600, 600)
        frame.setLocationRelativeTo(null)
        frame.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE

        val cuboid = Cuboid(Point3D(25.0, 250.0, -50.0), 100, "#22ee44")
        val objects = listOf(cuboid)
        val camera = Camera(200.0, 0.0)

        val scene = Scene(objects)
        canvas = Canvas(scene, camera)
        frame.add(canvas)
    }

    fun start() {
        frame.isVisible = true
    }
}

fun main(args: Array<String>) {
    EventQueue.invokeLater { Application().start() }
}