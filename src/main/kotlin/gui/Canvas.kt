package gui

import camera.Camera
import camera.Line2D
import camera.Scene

import javax.swing.*
import java.awt.*
import java.util.ArrayList
import javax.swing.border.Border

class Canvas (private val scene: Scene, private val camera: Camera) : JPanel() {
    override fun paintComponent(graphics: Graphics) {
        super.paintComponent(graphics)
        graphics.drawRect(0, 0, Scene.HEIGHT, Scene.WIDTH)
        scene.draw(graphics, camera)
    }
}
