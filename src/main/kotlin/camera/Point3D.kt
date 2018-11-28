package camera

import algebra.Matrix
import gui.DrawingContext

class Point3D(val x: Double, val y: Double, val z: Double) {
    companion object {
        fun fromVector(vector : Matrix) : Point3D {
            return Point3D(vector.at(0, 0), vector.at(0, 1), vector.at(0, 2))
        }
    }

    fun transform(context: DrawingContext): Point2D {
        val k = context.camera.planeDistance / (this.y - context.camera.y)
        val newX = (k * this.x + context.scene.x)
        val newZ = (context.scene.z - k * this.z)
        return Point2D(newX, newZ)
    }

    fun toVector() : Matrix {
        return Matrix.vector(x, y, z, 1.0)
    }

    fun multiply(translation: Matrix): Point3D {
        val result = this.toVector().multiple(translation).normalized()
        return Point3D.fromVector(result)
    }
}
