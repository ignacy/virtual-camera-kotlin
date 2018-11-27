package gui

import camera.Camera
import camera.Scene

class Session(var camera : Camera, var scene : Scene, var canvas : Canvas) {

    fun repaint() {
        this.canvas.repaint()
    }

    fun rotateZLeft() {
        this.scene.rotateZLeft(this.camera)
    }

    fun rotateZRight() {
        this.scene.rotateZRight(this.camera)
    }

    fun rotateYLeft() {
        this.scene.rotateYLeft(this.camera)
    }

    fun rotateYRight() {
        this.scene.rotateYRight(this.camera)
    }

}