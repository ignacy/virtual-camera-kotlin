package camera

import java.awt.Graphics

class Point3D(val x: Double, val y: Double, val z: Double) {
    private val vector: DoubleArray = doubleArrayOf(x, y, z, 1.0)

    fun transform(camera: Camera, scene: Scene): Point2D {
        val k = camera.planeDistance / (this.y - camera.y)
        val newX = (k * this.x + scene.x)
        val newZ = (scene.z - k * this.z)
        return Point2D(newX, newZ)
    }
}
