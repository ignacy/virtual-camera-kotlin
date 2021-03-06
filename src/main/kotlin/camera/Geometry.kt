package camera

import algebra.Matrix
import gui.DrawingContext
import java.awt.Color
import java.awt.Polygon
import java.awt.geom.Path2D



data class Point2D(val x: Double, val y: Double)
data class Point3D(val x: Double, val y: Double, val z: Double)

typealias Point = Point3D

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

fun transformPoint(p : Point3D, translation: Matrix) : Point3D {
    val result = Array(4) { 0.0 }
    for (w in 0..3) {
        result[w] = 0.0
        for (k in 0..3) {
            result[w] += translation[w, k] * pointToVectorMatrix(p)[k, 0]
        }
    }
    return pointFromVectorMatrix(Matrix(arrayOf(result)).normalized())
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

fun drawSide(points : List<Point3D>, c: DrawingContext, color: Color) {
    fun isVisible(p: Point3D): Boolean = p.y >= (c.camera.y + c.camera.planeDistance)
    c.graphics.color = color

    if (points.all(::isVisible)) {
        val projectedPoints = points.map { projectTo2D(it, c) }

        val xs = projectedPoints.map { it.x }
        val ys = projectedPoints.map { it.y }

        val path = Path2D.Double()

        path.moveTo(xs[0], ys[0])
        for (i in 1 until xs.size) {
            path.lineTo(xs[i], ys[i])
        }
        path.closePath()

        c.graphics.draw(path)
        c.graphics.fill(path)
    }
}

