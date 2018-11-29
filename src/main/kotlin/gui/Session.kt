package gui

import camera.Camera
import camera.Scene

class Session(var camera : Camera, var scene : Scene, var canvas : Canvas) {

    fun repaint() {
        this.canvas.repaint()
    }

    fun rotateXLeft() {
        this.scene.rotateXLeft()
    }

    fun rotateXRight() {
        this.scene.rotateXRight()
    }

    fun rotateZLeft() {
        this.scene.rotateZLeft()
    }

    fun rotateZRight() {
        this.scene.rotateZRight()
    }

    fun rotateYLeft() {
        this.scene.rotateYLeft()
    }

    fun rotateYRight() {
        this.scene.rotateYRight()
    }

    fun moveLeft() {
        this.scene.moveLeft()
    }

    fun moveRight() {
        this.scene.moveRight()
    }

    fun moveUp() {
        this.scene.moveUp()
    }

    fun moveDown() {
        this.scene.moveDown()
    }

    fun zoomIn() {
        this.camera.planeDistance = this.camera.planeDistance + Scene.ZOOM_STEP
    }

    fun zoomOut() {
        this.camera.planeDistance = this.camera.planeDistance - Scene.ZOOM_STEP
    }

    fun moveCloser() {
        this.scene.moveCloser()
    }

    fun moveFurther() {
        this.scene.moveFurther()
    }

}