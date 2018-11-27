package gui

import camera.Camera
import camera.Line2D
import camera.Scene

import javax.swing.*
import java.awt.*
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import java.util.ArrayList
import javax.swing.border.Border

class Canvas (var scene: Scene, private val camera: Camera) : JPanel() {
    override fun paintComponent(graphics: Graphics) {
        super.paintComponent(graphics)
        super.setBackground(Color.decode("#dae1e7"))
        graphics.drawRect(0, 0, Scene.HEIGHT, Scene.WIDTH)
        graphics.drawOval(0, 0, 50, 50)
        scene.draw(graphics, camera)
    }
}
