package camera

import algebra.Matrix
import gui.DrawingContext
import java.awt.Graphics

class Point3D(val x: Double, val y: Double, val z: Double) {
    private val vector: DoubleArray = doubleArrayOf(x, y, z, 1.0)

    fun transform(context: DrawingContext): Point2D {
        val k = context.camera.planeDistance / (this.y - context.camera.y)
        val newX = (k * this.x + context.scene.x)
        val newZ = (context.scene.z - k * this.z)
        return Point2D(newX, newZ)
    }

    fun multiply(translation: Matrix): Point3D {
        val v = arrayOf(x, y, z, 1.0)
        val tab = translation.m
        val tmp = Array(4) { 0.0 }

        for (w in 0..3) {
            tmp[w] = 0.0
            for (k in 0..3) {
                tmp[w] += tab!![w][k] * v[k]
            }
        }

        return Point3D(
                tmp[0] * (1/tmp[3]),
                tmp[1] * (1/tmp[3]),
                tmp[2] * (1/tmp[3])
        )
    }
}
