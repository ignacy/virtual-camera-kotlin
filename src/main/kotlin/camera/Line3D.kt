package camera

import algebra.Matrix
import gui.DrawingContext
import java.awt.Color



class Line3D(private val start: Point3D, private val end: Point3D) {
    fun draw(context: DrawingContext, color: Color) {
        val transformedStart = start.transform(context)
        val transformedEnd = end.transform(context)

        context.graphics.color = color
        if (context.camera.isVisible(end) && context.camera.isVisible(start)) {
            context.graphics.drawLine(
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
