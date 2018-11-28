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

    fun rotateYRight() {
        val cuboids = multiplyObjects(Matrix.yRotation(Scene.ANGULAR_STEP))
        this.objects = cuboids
    }

    fun rotateYLeft() {
        val cuboids = multiplyObjects(Matrix.yRotation(-Scene.ANGULAR_STEP))
        this.objects = cuboids
    }

    fun rotateZLeft() {
        val cuboids = multiplyObjects(Matrix.zRotation(-Scene.ANGULAR_STEP))
        this.objects = cuboids
    }

    fun rotateZRight() {
        val cuboids = multiplyObjects(Matrix.zRotation(Scene.ANGULAR_STEP))
        this.objects = cuboids
    }
    
    fun multiplyObjects(translation : Matrix) : List<Cuboid> {
        return objects.map {
            it.multiplyLines(translation)
        }
    }
}