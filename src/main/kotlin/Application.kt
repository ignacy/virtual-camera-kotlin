import camera.*
import gui.Canvas
import gui.KeyHandler

import javax.swing.*
import java.awt.*
import java.awt.event.KeyEvent
import java.awt.event.KeyListener

class Application : JFrame() {
    private val canvas : JPanel
    private var scene : Scene

    init {

        this.title = "Wirtualna Kamera"
        this.setSize(600, 600)
        this.setLocationRelativeTo(null)
        this.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE

        val objects = listOf(
                Cuboid(Point3D(25.0, 250.0, -50.0), 100, Color.decode("#3D9970")),
                Cuboid(Point3D(-200.0, 250.0, -100.0), 150, Color.decode("#85144b"))
        )
        val camera = Camera(200.0, 0.0)

        scene = Scene(objects)
        canvas = Canvas(scene, camera)

        this.addKeyListener(KeyHandler(scene, camera, canvas))
        this.add(canvas)
    }

    fun start() {
        this.isVisible = true
    }
}

fun main(args: Array<String>) {
    EventQueue.invokeLater { Application().start() }
}