package camera

import algebra.Matrix
import gui.DrawingContext

data class Point3D(val x: Double, val y: Double, val z: Double)

fun fromVector(vector : Matrix) : Point3D = Point3D(vector.at(0, 0), vector.at(0, 1), vector.at(0, 2))
fun toVector(point : Point3D) : Matrix = Matrix.vector(point.x, point.y, point.z, 1.0)
fun transform(point : Point3D, context: DrawingContext) : Point2D {
    val k = context.camera.planeDistance / (point.y - context.camera.y)
    val newX = (k * point.x + context.scene.x)
    val newZ = (context.scene.z - k * point.z)
    return Point2D(newX, newZ)
}
fun multiply(point: Point3D, translation: Matrix) : Point3D {
    val result = Array(4 ) { 0.0 }

    for (w in 0..3) {
        result[w] = 0.0
        for (k in 0..3) {
            result[w] += translation.at(w, k) *
                    toVector(point).at(k, 0)
        }
    }
    val finalResult = Matrix(arrayOf(result)).normalized()
    return fromVector(finalResult)
}