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
