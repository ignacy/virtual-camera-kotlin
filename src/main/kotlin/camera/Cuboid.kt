package camera

import algebra.Matrix
import gui.DrawingContext
import java.awt.Color

typealias Walls = Map<String, List<Point>>

class Cuboid {
    var color : Color = Color.decode("#000000")
    var walls : Walls

    constructor(w : Walls, c : Color) {
        color = c
        walls = w
    }

    constructor(point : Point, l : Int, c : Color) {
        val (x, y, z) = point
        color = c
        walls = hashMapOf(
                "front" to listOf(point, Point(x, y + l, z), Point(x+l, y+l, z), Point(x+l, y, z)),
                "top" to listOf(Point(x, y+l, z), Point(x, y+l, z+l), Point(x+l, y + l, z + l), Point(x+l, y +l, z)),
                "bottom" to listOf(point, Point(x, y, z + l), Point(x+l, y, z+l), Point(x+l, y, z)),
                "back" to listOf(Point(x, y, z+l), Point(x+l, y, z+l), Point(x+l, y+l, z+l), Point(x, y+l, z+l)),
                "left" to listOf(point, Point(x, y+l, z), Point(x, y +l, z + l), Point(x, y, z+l)),
                "right" to listOf(Point(x+l, y, z), Point(x+l, y, z +l), Point(x+l, y+l, z+l), Point(x+l, y+l, z))
        )
    }

    fun draw(context: DrawingContext) = this.walls.values.map { drawSide(it, context, this.color) }
    fun multiplySides(translation: Matrix): Cuboid {
        val newWalls = HashMap<String, List<Point3D>>()

        this.walls.map { (name, points) ->
            newWalls.put(name, points.map { transformPoint(it, translation) })
        }
        return Cuboid(newWalls, this.color)
    }
}
