package gui

import camera.Camera
import camera.Scene
import java.awt.BasicStroke
import java.awt.Graphics
import java.awt.Graphics2D

class DrawingContext {
    val graphics : Graphics
    val scene : Scene
    val camera : Camera

    constructor(g : Graphics, scene : Scene, camera : Camera) {
        val g2 = g as Graphics2D
        g2.stroke = BasicStroke(3f)
        this.graphics = g2
        this.camera = camera
        this.scene = scene
    }

    fun draw() {
        scene.draw(this)
    }
}