package gui

import camera.Camera
import camera.Scene
import javax.swing.*
import java.awt.*

class Canvas (var scene: Scene, private val camera: Camera) : JPanel() {
    override fun paintComponent(graphics: Graphics) {
        super.paintComponent(graphics)
        super.setBackground(Color.decode("#dae1e7"))
        graphics.drawRect(0, 0, Scene.HEIGHT, Scene.WIDTH)
        DrawingContext(graphics, scene, camera).draw()
    }
}

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