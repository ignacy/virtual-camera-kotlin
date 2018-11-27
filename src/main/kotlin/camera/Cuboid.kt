package camera

import java.awt.Graphics
import javax.swing.DebugGraphics

class Cuboid (private val point : Point3D, private val length : Int, val color : String) {
    fun lines() = listOf<Line3D> (
            Line3D(point, Point3D(point.x, point.y + length, point.z)),
            Line3D(point, Point3D(point.x, point.y, point.z + length)),
            Line3D(point, Point3D(point.x + length, point.y, point.z)),
            Line3D(Point3D(point.x, point.y + length, point.z), Point3D(point.x + length, point.y + length, point.z))
    )

    fun draw(graphics: Graphics, camera: Camera, scene: Scene) {
        lines().map { it.draw(graphics, camera, scene) }
    }
}