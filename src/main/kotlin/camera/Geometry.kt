package camera

import algebra.Matrix
import gui.DrawingContext
import java.awt.Color

data class Point2D(val x: Double, val y: Double)
data class Point3D(val x: Double, val y: Double, val z: Double)
data class Line3D(val start: Point3D, val end: Point3D)

fun pointFromVectorMatrix(v : Matrix) : Point3D = Point3D(v[0, 0], v[0, 1], v[0, 2])
fun pointToVectorMatrix(p : Point3D) : Matrix = algebra.vector(p.x, p.y, p.z, 1.0)

fun projectTo2D(p : Point3D, context: DrawingContext) : Point2D {
    with (context) {
        val k = camera.planeDistance / (p.y - camera.y)
        val newX = (k * p.x + scene.x)
        val newZ = (scene.z - k * p.z)
        return Point2D(newX, newZ)
    }
}

fun transformLine(line: Line3D, translation: Matrix): Line3D {
    fun multiply(p: Point3D): Point3D {
        val result = Array(4) { 0.0 }
        for (w in 0..3) {
            result[w] = 0.0
            for (k in 0..3) {
                result[w] += translation[w, k] * pointToVectorMatrix(p)[k, 0]
            }
        }
        return pointFromVectorMatrix(v = Matrix(arrayOf(result)).normalized())
    }
    return Line3D(multiply(line.start), multiply(line.end))
}

fun transformAndCut(
        a: Point3D,
        b: Point3D,
        c: DrawingContext
): Pair<Point2D, Point2D> {
    fun isOnViewPlane(p: Point3D): Boolean = p.y == c.scene.x + c.camera.planeDistance

    return if (isOnViewPlane(a)) {
        val nowy1 = Point2D(
                a.x + c.scene.x,
                c.scene.z - a.z
        )
        Pair(nowy1, Point2D(nowy1.x, nowy1.y))
    } else {
        val k = (a.y - (c.camera.y + c.camera.planeDistance)) / (a.y - b.y)
        val x = a.x + (b.x - a.x) * k
        val z = a.z + (b.z - a.z) * k
        Pair(projectTo2D(a, c), Point2D(c.scene.x + x, c.scene.z - z))
    }
}

fun draw(line: Line3D, c: DrawingContext, color: Color) {
    fun isVisible(p: Point3D): Boolean = p.y >= (c.camera.y + c.camera.planeDistance)

    c.graphics.color = color

    val (p1, p2) = when {
        isVisible(line.end) && isVisible(line.start) -> Pair(projectTo2D(line.start, c), projectTo2D(line.end, c))
        isVisible(line.end) && !isVisible(line.start) -> transformAndCut(line.end, line.start, c)
        isVisible(line.start) && !isVisible(line.end) -> transformAndCut(line.start, line.end, c)
        else -> { Pair(null, null) }
    }

    if (p1 != null && p2 != null) {
        c.graphics.drawLine(p1.x.toInt(), p1.y.toInt(), p2.x.toInt(), p2.y.toInt())
    }
}
