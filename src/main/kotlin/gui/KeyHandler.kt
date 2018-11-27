package gui

import java.awt.event.KeyEvent
import java.awt.event.KeyListener

class KeyHandler(var session: Session) : KeyListener {
        override fun keyTyped(e: KeyEvent?) {
        }

        override fun keyReleased(e: KeyEvent?) {
        }

        override fun keyPressed(e: KeyEvent?) {
            if (e!!.keyChar == 'z') {
                session.rotateLeft()
            }

            if (e.keyChar == 'x') {
                // rotate arround Z right
            }
            session.repaint()
        }
}