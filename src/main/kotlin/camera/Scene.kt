package camera

import algebra.Matrix
import gui.DrawingContext

data class Camera(var planeDistance: Double, val y: Double)

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
        val cuboids = multiplyObjects(algebra.xRotation(-Scene.ANGULAR_STEP))
        this.objects = cuboids
    }

    fun rotateXRight() {
        val cuboids = multiplyObjects(algebra.xRotation(Scene.ANGULAR_STEP))
        this.objects = cuboids
    }

    fun rotateYRight() {
        val cuboids = multiplyObjects(algebra.yRotation(Scene.ANGULAR_STEP))
        this.objects = cuboids
    }

    fun rotateYLeft() {
        val cuboids = multiplyObjects(algebra.yRotation(-Scene.ANGULAR_STEP))
        this.objects = cuboids
    }

    fun rotateZLeft() {
        val cuboids = multiplyObjects(algebra.zRotation(-Scene.ANGULAR_STEP))
        this.objects = cuboids
    }

    fun rotateZRight() {
        val cuboids = multiplyObjects(algebra.zRotation(Scene.ANGULAR_STEP))
        this.objects = cuboids
    }

    fun moveLeft() {
        val cuboids = multiplyObjects(algebra.moveLeft(Scene.LINEAR_STEP))
        this.objects = cuboids
    }

    fun moveRight() {
        val cuboids = multiplyObjects(algebra.moveRight(Scene.LINEAR_STEP))
        this.objects = cuboids
    }

    fun moveUp() {
        val cuboids = multiplyObjects(algebra.moveUp(Scene.LINEAR_STEP))
        this.objects = cuboids
    }

    fun moveDown() {
        val cuboids = multiplyObjects(algebra.moveDown(Scene.LINEAR_STEP))
        this.objects = cuboids
    }

    fun multiplyObjects(translation : Matrix) : List<Cuboid> = objects.map { it.multiplySides(translation) }

    fun moveCloser() {
        val cuboids = multiplyObjects(algebra.moveCloser(Scene.LINEAR_STEP))
        this.objects = cuboids
    }

    fun moveFurther() {
        val cuboids = multiplyObjects(algebra.moveFurther(Scene.LINEAR_STEP))
        this.objects = cuboids
    }
}