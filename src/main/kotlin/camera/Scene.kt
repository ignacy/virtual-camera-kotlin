package camera

import algebra.Matrix
import java.awt.Graphics

class Scene(private val objects: List<Cuboid>) {
    companion object {
        val HEIGHT = 600
        val WIDTH = 600
    }

    val x = HEIGHT / 2
    val z = WIDTH / 2

    fun draw(graphics: Graphics, camera: Camera) {
        objects.map { it.draw(graphics, camera, this) }
    }

    fun rotateZLeft(camera: Camera): Scene {
        var r = Matrix.identity()
        r.multiple(Matrix.makeRotationZMatrix(0.1, camera.y))

        val t = Matrix.identity()

        val v = arrayOf(0.0, 0.0, 0.0)

        for (w in 0..2)
            t.setVal(w, 3, v[w])

        t.multiple(r)

        val cuboids = multiplyObjects(t)
        return Scene(cuboids)
    }

    fun multiplyObjects(translation : Matrix) : List<Cuboid> {
        return objects.map {
            it.multiplyLines(translation)
        }
    }
}