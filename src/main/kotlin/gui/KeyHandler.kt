package gui

import camera.Camera
import java.awt.event.KeyEvent
import java.awt.event.KeyListener

class KeyHandler(public var session: Session) : KeyListener {
        override fun keyTyped(e: KeyEvent?) {
        }

        override fun keyReleased(e: KeyEvent?) {
        }

        override fun keyPressed(e: KeyEvent?) {
            if (e!!.keyChar == 'z') {
                session.scene.rotateZLeft(session.camera)
            }

            if (e.keyChar == 'x') {
                // rotate arround Z right
            }
            session.canvas.repaint()
        }
}