package gui

import camera.Camera
import camera.Scene

class Session(var camera : Camera, var scene : Scene, var canvas : Canvas) {

    fun repaint() {
        this.canvas.repaint()
    }

    fun rotateLeft() {
        this.scene.rotateZLeft(this.camera)
    }

}