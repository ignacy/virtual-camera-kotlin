import camera.Line2D
import camera.Point2D
import gui.Canvas

import javax.swing.*
import java.awt.*
import java.util.ArrayList

class Application {
    private val frame: JFrame = JFrame()
    private val canvas: JPanel

    init {
        frame.title = "Wirtualna Kamera"
        frame.setSize(300, 200)
        frame.setLocationRelativeTo(null)
        frame.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE

        val lines = ArrayList<Line2D>()
        lines.add(Line2D(Point2D(10.0, 10.0), Point2D(300.0, 10.0)))
        lines.add(Line2D(Point2D(10.0, 20.0), Point2D(300.0, 20.0)))
        canvas = Canvas(lines)

        frame.add(canvas)
    }

    fun start() {
        frame.isVisible = true
    }
}

fun main(args: Array<String>) {
    EventQueue.invokeLater { Application().start() }
}