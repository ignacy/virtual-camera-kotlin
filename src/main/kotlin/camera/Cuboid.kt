package camera

import algebra.Matrix
import java.awt.Color
import java.awt.Graphics
import javax.swing.DebugGraphics

class Cuboid {
    var lines : List<Line3D> = emptyList()
    var color : Color = Color.decode("#000000")

    constructor(lines : List<Line3D>, color : Color) {
        this.lines = lines
        this.color = color
    }

    constructor(point : Point3D, length : Int, color : Color) {
        this.color = color
        this.lines = listOf<Line3D>(
                Line3D(point, Point3D(point.x, point.y + length, point.z)),
                Line3D(point, Point3D(point.x, point.y, point.z + length)),
                Line3D(point, Point3D(point.x + length, point.y, point.z)),
                Line3D(Point3D(point.x, point.y + length, point.z), Point3D(point.x, point.y + length, point.z + length)),
                Line3D(Point3D(point.x, point.y + length, point.z), Point3D(point.x + length, point.y + length, point.z)),
                Line3D(Point3D(point.x + length, point.y + length, point.z), Point3D(point.x + length, point.y + length, point.z + length)),
                Line3D(Point3D(point.x + length, point.y + length, point.z + length), Point3D(point.x + length, point.y + length, point.z + length)),
                Line3D(Point3D(point.x + length, point.y + length, point.z + length), Point3D(point.x + length, point.y, point.z + length)),
                Line3D(Point3D(point.x, point.y + length, point.z + length), Point3D(point.x, point.y, point.z + length)),
                Line3D(Point3D(point.x, point.y + length, point.z + length), Point3D(point.x + length, point.y + length, point.z + length)),
                Line3D(Point3D(point.x, point.y, point.z + length), Point3D(point.x + length, point.y, point.z + length)),
                Line3D(Point3D(point.x + length, point.y, point.z), Point3D(point.x + length, point.y, point.z + length)),
                Line3D(Point3D(point.x + length, point.y, point.z), Point3D(point.x + length, point.y + length, point.z))
        )
    }

    fun draw(graphics: Graphics, camera: Camera, scene: Scene) {
        this.lines.map { it.draw(graphics, camera, scene, this.color) }
    }

    fun multiplyLines(translation: Matrix): Cuboid {
        return Cuboid(
                this.lines.map { it.multiplyPoints(translation) },
                this.color
        )
    }
}