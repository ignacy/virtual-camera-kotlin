package camera

import algebra.Matrix
import gui.DrawingContext

class Point3D(val x: Double, val y: Double, val z: Double) {
    private val vector: DoubleArray = doubleArrayOf(x, y, z, 1.0)

    fun transform(context: DrawingContext): Point2D {
        val k = context.camera.planeDistance / (this.y - context.camera.y)
        val newX = (k * this.x + context.scene.x)
        val newZ = (context.scene.z - k * this.z)
        return Point2D(newX, newZ)
    }

    fun multiply(translation: Matrix): Point3D {
        val result = Matrix(arrayOf(arrayOf(x, y, z, 1.0))).multiple(translation)
        // TODO: replace with result.normalize()
        return Point3D(
                result.at(0, 0) / result.at(0,3),
                result.at(0, 1) / result.at(0,3),
                result.at(0, 2) / result.at(0, 3)
        )
    }
}
