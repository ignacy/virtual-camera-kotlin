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

        val objects = listOf(
                Cuboid(Point3D(25.0, 250.0, -50.0), 100, Color.decode("#3D9970")),
                Cuboid(Point3D(-200.0, 250.0, -100.0), 150, Color.decode("#85144b"))
        )
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