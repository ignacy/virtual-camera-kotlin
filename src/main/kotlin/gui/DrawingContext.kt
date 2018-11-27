package gui

import camera.Camera
import camera.Scene
import java.awt.Graphics

class DrawingContext(val graphics : Graphics, val scene : Scene, val camera : Camera) {
    fun draw() {
        scene.draw(this)
    }

}