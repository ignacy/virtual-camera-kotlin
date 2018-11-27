package camera

import algebra.Matrix
import gui.DrawingContext

class Scene(private var objects: List<Cuboid>) {
    companion object {
        val HEIGHT = 800
        val WIDTH = 800
    }

    val x = HEIGHT / 2
    val z = WIDTH / 2

    fun draw(context: DrawingContext) {
        objects.map { it.draw(context) }
    }

    fun rotateZLeft(camera: Camera) {
        var r = Matrix.identity().multiple(Matrix.makeRotationZMatrix(0.1, camera.y))
        var t = Matrix.identity().multiple(r)
        val v = arrayOf(0.0, 0.0, 0.0)
        for (w in 0..2)
            t.setVal(w, 3, v[w])

        val cuboids = multiplyObjects(t)
        this.objects = cuboids
    }

    fun multiplyObjects(translation : Matrix) : List<Cuboid> {
        return objects.map {
            it.multiplyLines(translation)
        }
    }
}