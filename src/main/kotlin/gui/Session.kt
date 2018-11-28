package gui

import camera.Camera
import camera.Scene

class Session(var camera : Camera, var scene : Scene, var canvas : Canvas) {

    fun repaint() {
        this.canvas.repaint()
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

}