package camera

import algebra.Matrix
import gui.DrawingContext
import java.awt.Color

class Line3D(private val start: Point3D, private val end: Point3D) {
    fun draw(context: DrawingContext, color: Color) {
        context.graphics.color = color

        if (isVisible(context.camera, end) && isVisible(context.camera, start)) {
            val transformedStart = transform(start, context)
            val transformedEnd = transform(end, context)

            context.graphics.drawLine(
                    transformedStart.x.toInt(),
                    transformedStart.y.toInt(),
                    transformedEnd.x.toInt(),
                    transformedEnd.y.toInt()
            )
        } else if (isVisible(context.camera, end) && !isVisible(context.camera, start)) {
            val (transformedCutStart, transformedCutEnd) = transformAndCut(end, start, context)
            context.graphics.drawLine(
                    transformedCutStart.x.toInt(),
                    transformedCutStart.y.toInt(),
                    transformedCutEnd.x.toInt(),
                    transformedCutEnd.y.toInt()
            )
        } else if (isVisible(context.camera, start) && !isVisible(context.camera, end)) {
            val (transformedCutStart, transformedCutEnd) = transformAndCut(start, end, context)
            context.graphics.drawLine(
                    transformedCutStart.x.toInt(),
                    transformedCutStart.y.toInt(),
                    transformedCutEnd.x.toInt(),
                    transformedCutEnd.y.toInt()
            )

        }
    }

    private fun transformAndCut(a: Point3D, b: Point3D, context: DrawingContext): Pair<Point2D, Point2D> {
        if (a.y === context.scene.x + context.camera.planeDistance) {
            val nowy1 = Point2D(
                    a.x + context.scene.x,
                    context.scene.z - a.z
            )
            val nowy2 = Point2D(nowy1.x, nowy1.y)
            return Pair(nowy1, nowy2)
        } else {
            val dy = a.y - b.y
            val y = a.y - (context.camera.y + context.camera.planeDistance)
            val k = y / dy
            val x = a.x + (b.x - a.x) * k
            val z = a.z + (b.z - a.z) * k
            return Pair(transform(a, context),
                    Point2D(context.scene.x + x, context.scene.z - z))
        }
    }

    fun multiplyPoints(translation: Matrix): Line3D {
        return Line3D(

                multiply(start, translation),
                multiply(end, translation)
        )
    }
}
