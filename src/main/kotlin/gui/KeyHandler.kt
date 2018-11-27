package gui

import java.awt.event.KeyEvent
import java.awt.event.KeyListener

class KeyHandler(var session: Session) : KeyListener {
        override fun keyTyped(e: KeyEvent?) {
        }

        override fun keyReleased(e: KeyEvent?) {
        }

        override fun keyPressed(e: KeyEvent?) {
            when(e!!.keyChar) {
                'z' -> session.rotateLeft()
                'x' -> session.rotateRight()
            }
            session.repaint()
        }
}