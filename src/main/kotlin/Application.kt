import camera.*
import gui.Canvas
import gui.KeyHandler
import gui.Session

import javax.swing.*
import java.awt.*

class Application : JFrame() {
    init {
        this.title = "Wirtualna Kamera"
        this.setSize(800, 800)
        this.setLocationRelativeTo(null)
        this.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE

        val objects = listOf(
                Cuboid(Point3D(25.0, 250.0, -50.0), 100, Color.decode("#3D9970")),
                Cuboid(Point3D(-200.0, 250.0, -100.0), 150, Color.decode("#85144b"))
        )

        val camera = Camera(200.0, 0.0)
        val scene = Scene(objects)
        val canvas = Canvas(scene, camera)

        val session = Session(camera, scene, canvas)

        this.addKeyListener(KeyHandler(session))
        this.add(canvas)
    }

    fun start() {
        this.isVisible = true
    }
}

fun main(args: Array<String>) {
    EventQueue.invokeLater { Application().start() }
}