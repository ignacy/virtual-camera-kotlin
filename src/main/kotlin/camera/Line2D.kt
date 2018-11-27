package camera

import java.awt.*

class Line2D(private val start: Point2D, private val end: Point2D) {
    fun draw(g: Graphics) {
        g.drawLine(this.start.x.toInt(), this.start.y.toInt(), this.end.x.toInt(), this.end.y.toInt())
    }
}
