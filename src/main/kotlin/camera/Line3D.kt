package camera

import algebra.Matrix
import gui.DrawingContext
import java.awt.Color
import java.awt.Graphics
import java.util.ArrayList
import java.awt.BasicStroke
import java.awt.Graphics2D



class Line3D(private val start: Point3D, private val end: Point3D) {
    fun draw(context: DrawingContext, color: Color) {
        val transformedStart = start.transform(context)
        val transformedEnd = end.transform(context)

        val g2 = context.graphics as Graphics2D
        g2.stroke = BasicStroke(3f)

        g2.color = color

        if (context.camera.isVisible(end) && context.camera.isVisible(start)) {
            g2.drawLine(
                    transformedStart.x.toInt(),
                    transformedStart.y.toInt(),
                    transformedEnd.x.toInt(),
                    transformedEnd.y.toInt()
            )
        }
    }

    fun multiplyPoints(translation: Matrix): Line3D {
        return Line3D(
                start.multiply(translation),
                end.multiply(translation)
        )
    }
}
