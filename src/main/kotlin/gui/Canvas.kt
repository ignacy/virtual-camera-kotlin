package gui

import camera.Line2D

import javax.swing.*
import java.awt.*
import java.util.ArrayList

class Canvas// FIXME: powinien brac Scene
(private val lines: ArrayList<Line2D>) : JPanel() {

    override fun paintComponent(graphics: Graphics) {
        super.paintComponent(graphics)

        // FIXME: scene.draw(graphics)
        for (line in lines) {
            line.draw(graphics)
        }
    }
}
