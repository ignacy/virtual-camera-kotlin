package camera

import algebra.Matrix
import gui.DrawingContext
import java.awt.Color

class Cuboid {
    var lines : List<Line3D> = emptyList()
    var color : Color = Color.decode("#000000")
    lateinit var walls : Map<String, List<Point3D>>

    constructor(l : List<Line3D>, c : Color) {
        lines = l
        color = c
    }

    constructor(point : Point, l : Int, c : Color) {
        val (x, y, z) = point
        color = c
        lines = listOf(
                Line3D(point, Point(x, y + l, z)),
                Line3D(point, Point(x, y, z + l)),
                Line3D(point, Point(x + l, y, z)),
                Line3D(Point(x, y + l, z), Point(x, y + l, z + l)),
                Line3D(Point(x, y + l, z), Point(x + l, y + l, z)),
                Line3D(Point(x + l, y + l, z), Point(x + l, y + l, z + l)),
                Line3D(Point(x + l, y + l, z + l), Point(x + l, y + l, z + l)),
                Line3D(Point(x + l, y + l, z + l), Point(x + l, y, z + l)),
                Line3D(Point(x, y + l, z + l), Point(x, y, z + l)),
                Line3D(Point(x, y + l, z + l), Point(x + l, y + l, z + l)),
                Line3D(Point(x, y, z + l), Point(x + l, y, z + l)),
                Line3D(Point(x + l, y, z), Point(x + l, y, z + l)),
                Line3D(Point(x + l, y, z), Point(x + l, y + l, z))
        )

        walls = hashMapOf(
            "front" to listOf(point, Point(x, y + l, z), Point(x+l, y+l, z), Point(x+l, y, z)),
            "top" to listOf(Point(x, y+l, z), Point(x, y+l, z+l), Point(x+l, y + l, z + l), Point(x+l, y +l, z)),
            "bottom" to listOf(point, Point(x, y, z + l), Point(x+l, y, z+l), Point(x+l, y, z)),
            "back" to listOf(Point(x, y, z+l), Point(x+l, y, z+l), Point(x+l, y+l, z+l), Point(x, y+l, z+l)),
            "left" to listOf(point, Point(x, y+l, z), Point(x, y +l, z + l), Point(x, y, z+l)),
            "right" to listOf(Point(x+l, y, z), Point(x+l, y, z +l), Point(x+l, y+l, z+l), Point(x+l, y+l, z))
        )
    }

    fun draw(context: DrawingContext) = this.lines.map { draw(it, context, this.color) }
    fun multiplyLines(translation: Matrix): Cuboid = Cuboid(this.lines.map { transformLine(it, translation) }, this.color)
}