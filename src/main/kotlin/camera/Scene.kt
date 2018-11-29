package camera

import algebra.Matrix
import gui.DrawingContext

class Scene(private var objects: List<Cuboid>) {
    companion object {
        const val HEIGHT = 800
        const val WIDTH = 800
        const val ANGULAR_STEP = 0.1
        const val ZOOM_STEP = 50.0
        const val LINEAR_STEP = 100.0
    }

    val x = HEIGHT / 2
    val z = WIDTH / 2

    fun draw(context: DrawingContext) {
        objects.map { it.draw(context) }
    }

    fun rotateXLeft() {
        val cuboids = multiplyObjects(Matrix.xRotation(-Scene.ANGULAR_STEP))
        this.objects = cuboids
    }

    fun rotateXRight() {
        val cuboids = multiplyObjects(Matrix.xRotation(Scene.ANGULAR_STEP))
        this.objects = cuboids
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

    fun moveLeft() {
        val cuboids = multiplyObjects(Matrix.moveLeft(Scene.LINEAR_STEP))
        this.objects = cuboids
    }

    fun moveRight() {
        val cuboids = multiplyObjects(Matrix.moveRight(Scene.LINEAR_STEP))
        this.objects = cuboids
    }

    fun moveUp() {
        val cuboids = multiplyObjects(Matrix.moveUp(Scene.LINEAR_STEP))
        this.objects = cuboids
    }

    fun moveDown() {
        val cuboids = multiplyObjects(Matrix.moveDown(Scene.LINEAR_STEP))
        this.objects = cuboids
    }

    fun multiplyObjects(translation : Matrix) : List<Cuboid> {
        return objects.map {
            it.multiplyLines(translation)
        }
    }

    fun moveCloser() {
        val cuboids = multiplyObjects(Matrix.moveCloser(Scene.LINEAR_STEP))
        this.objects = cuboids
    }

    fun moveFurther() {
        val cuboids = multiplyObjects(Matrix.moveFurther(Scene.LINEAR_STEP))
        this.objects = cuboids
    }

}