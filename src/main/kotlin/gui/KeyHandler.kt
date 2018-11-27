package gui

import camera.Camera
import camera.Scene
import java.awt.event.KeyEvent
import java.awt.event.KeyListener

class KeyHandler(public var scene : Scene, val camera: Camera, private val canvas: Canvas) : KeyListener {
        override fun keyTyped(e: KeyEvent?) {
        }

        override fun keyReleased(e: KeyEvent?) {
        }

        override fun keyPressed(e: KeyEvent?) {
            println("JHELLLO")
            if (e!!.keyChar == 'z') {
                // rotate arround Z left
                println("Z")
                scene = scene.rotateZLeft(this.camera)
            }

            if (e.keyChar == 'x') {
                // rotate arround Z right
            }
            canvas.scene = scene
            canvas.repaint()
        }
}