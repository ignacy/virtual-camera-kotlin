package camera

import algebra.Matrix
import gui.DrawingContext
import java.awt.Color
import java.awt.Graphics

data class Point2D(val x: Double, val y: Double)
data class Point3D(val x: Double, val y: Double, val z: Double)
data class Line3D(val start: Point3D, val end: Point3D)

fun pointFromVector(vector : Matrix) : Point3D = Point3D(vector.at(0, 0), vector.at(0, 1), vector.at(0, 2))
fun pointToVectorMatrix(point : Point3D) : Matrix = algebra.vector(point.x, point.y, point.z, 1.0)
fun isVisible(camera: Camera, point: Point3D): Boolean = point.y >= (camera.y + camera.planeDistance)
fun isOnViewPlane(p: Point3D, c: DrawingContext): Boolean = p.y == c.scene.x + c.camera.planeDistance
fun transform(p : Point3D, context: DrawingContext) : Point2D {
    with (context) {
        val k = camera.planeDistance / (p.y - camera.y)
        val newX = (k * p.x + scene.x)
        val newZ = (scene.z - k * p.z)
        return Point2D(newX, newZ)
    }
}
fun multiply(p: Point3D, translation: Matrix) : Point3D {
    val result = Array(4) { 0.0 }

    for (w in 0..3) {
        result[w] = 0.0
        for (k in 0..3) {
            result[w] += translation.at(w, k) * pointToVectorMatrix(p).at(k, 0)
        }
    }
    return pointFromVector(Matrix(arrayOf(result)).normalized())
}

fun multiplyLine(line: Line3D, translation: Matrix): Line3D = Line3D(multiply(line.start, translation), multiply(line.end, translation))
fun drawLine(g: Graphics, p1 : Point2D, p2 : Point2D) = g.drawLine(p1.x.toInt(), p1.y.toInt(), p2.x.toInt(), p2.y.toInt())
fun draw(line: Line3D, c: DrawingContext, color: Color) {
    c.graphics.color = color
    val (p1, p2) = when {
        isVisible(c.camera, line.end) && isVisible(c.camera, line.start) -> Pair(transform(line.start, c), transform(line.end, c))
        isVisible(c.camera, line.end) && !isVisible(c.camera, line.start) -> transformAndCut(line.end, line.start, c)
        isVisible(c.camera, line.start) && !isVisible(c.camera, line.end) -> transformAndCut(line.start, line.end, c)
        else -> {
            TODO("Should we handle case like this?")
        }
    }
    drawLine(c.graphics, p1, p2)
}

fun transformAndCut(
        a: Point3D,
        b: Point3D,
        c: DrawingContext
): Pair<Point2D, Point2D> {
    return if (isOnViewPlane(a, c)) {
        val nowy1 = Point2D(
                a.x + c.scene.x,
                c.scene.z - a.z
        )
        Pair(nowy1, Point2D(nowy1.x, nowy1.y))
    } else {
        val k = (a.y - (c.camera.y + c.camera.planeDistance)) / (a.y - b.y)
        val x = a.x + (b.x - a.x) * k
        val z = a.z + (b.z - a.z) * k
        Pair(transform(a, c), Point2D(c.scene.x + x, c.scene.z - z))
    }
}

