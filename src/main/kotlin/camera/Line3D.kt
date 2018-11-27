package camera

import algebra.Matrix
import java.awt.Color
import java.awt.Graphics
import java.util.ArrayList

class Line3D(private val start: Point3D, private val end: Point3D) {
    fun draw(graphics: Graphics, camera: Camera, scene: Scene, color: Color) {
        val transformedStart = start.transform(camera, scene)
        val transformedEnd = end.transform(camera, scene)

        graphics.color = color

        if (camera.isVisible(end) && camera.isVisible(start)) {
            graphics.drawLine(
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