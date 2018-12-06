package camera

import algebra.Matrix
import gui.DrawingContext
import java.awt.Color
import java.util.*
import java.util.function.DoubleUnaryOperator

typealias Wall = List<Point3D>

class Cuboid {
    var color : Color = Color.decode("#000000")
    var walls : List<List<Point3D>>

    constructor(w : List<List<Point3D>>, c : Color) {
        color = c
        walls = w
    }

    constructor(point : Point, l : Int, c : Color) {
        val (x, y, z) = point
        color = c
        walls = listOf(
                listOf(point, Point(x, y + l, z), Point(x+l, y+l, z), Point(x+l, y, z)),
                listOf(Point(x, y+l, z), Point(x, y+l, z+l), Point(x+l, y + l, z + l), Point(x+l, y +l, z)),
                listOf(Point(x, y, z+l), Point(x+l, y, z+l), Point(x+l, y+l, z+l), Point(x, y+l, z+l)),
                listOf(point, Point(x, y+l, z), Point(x, y +l, z + l), Point(x, y, z+l)),
                listOf(Point(x+l, y, z), Point(x+l, y, z +l), Point(x+l, y+l, z+l), Point(x+l, y+l, z))
        )

        Collections.sort(walls) { wall1, wall2 -> massCenter(wall1).y.compareTo(massCenter(wall2).y)}
    }

    fun draw(context: DrawingContext) = this.walls.map { drawSide(it, context, this.color) }
    fun multiplySides(translation: Matrix): Cuboid {
        val transformed = this.walls.map { it.map { transformPoint(it, translation) } }
        return Cuboid(transformed, this.color)
    }
}

fun massCenter(points : List<Point>) : Point {
    return Point(
            points.sumByDouble { it.x } / 4.0,
            points.sumByDouble { it.y } / 4.0,
            points.sumByDouble { it.z } / 4.0
    )
}

