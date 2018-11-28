import camera.*
import gui.Canvas
import gui.KeyHandler
import gui.Legend
import gui.Session

import javax.swing.*
import java.awt.*
import java.awt.FlowLayout
import javax.swing.JPanel





class Application : JFrame() {
    init {
        this.isResizable = false
        this.title = "Wirtualna Kamera"
        this.setSize(1000, 800)
        this.setLocationRelativeTo(null)
        this.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE

        this.layout = BorderLayout()

        val objects = listOf(
                Cuboid(Point3D(25.0, 250.0, -50.0), 100, Color.decode("#3D9970")),
                Cuboid(Point3D(-200.0, 250.0, -100.0), 150, Color.decode("#85144b"))
        )

        val camera = Camera(200.0, 0.0)
        val scene = Scene(objects)
        val canvas = Canvas(scene, camera)

        val session = Session(camera, scene, canvas)

        this.addKeyListener(KeyHandler(session))


        val container = JPanel()
        val legend = Legend()
        legend.setSize(300, 800)
        legend.add(JLabel("2"))

        canvas.add(JLabel("1"))

        container.layout = GridLayout(1,2)
        container.add(canvas)
        container.add(legend)

        this.add(container)
    }

    fun start() {
        this.isVisible = true
    }
}

fun main(args: Array<String>) {
    EventQueue.invokeLater { Application().start() }
}