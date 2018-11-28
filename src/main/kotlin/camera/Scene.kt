package camera

import algebra.Matrix
import gui.DrawingContext

class Scene(private var objects: List<Cuboid>) {
    companion object {
        const val HEIGHT = 800
        const val WIDTH = 800
        const val ANGULAR_STEP = 0.1
    }

    val x = HEIGHT / 2
    val z = WIDTH / 2

    fun draw(context: DrawingContext) {
        objects.map { it.draw(context) }
    }

    fun rotateZLeft(camera: Camera) {
        var r = Matrix.identity().multiple(Matrix.zRotation(-Scene.ANGULAR_STEP))
        val cuboids = multiplyObjects(r)
        this.objects = cuboids
    }

    fun rotateZRight(camera: Camera) {
        var r = Matrix.identity().multiple(Matrix.zRotation(Scene.ANGULAR_STEP))
        val cuboids = multiplyObjects(r)
        this.objects = cuboids
    }

    fun multiplyObjects(translation : Matrix) : List<Cuboid> {
        return objects.map {
            it.multiplyLines(translation)
        }
    }

    fun rotateYRight(camera: Camera) {
        var r = Matrix.identity().multiple(Matrix.yRotation(Scene.ANGULAR_STEP))
        val cuboids = multiplyObjects(r)
        this.objects = cuboids
    }

    fun rotateYLeft(camera: Camera) {
        var r = Matrix.identity().multiple(Matrix.yRotation(-Scene.ANGULAR_STEP))
        val cuboids = multiplyObjects(r)
        this.objects = cuboids
    }
}