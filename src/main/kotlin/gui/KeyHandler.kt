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
                'z' -> session.rotateZLeft()
                'x' -> session.rotateZRight()
                'c' -> session.rotateYLeft()
                'v' -> session.rotateYRight()
                'b' -> session.rotateXLeft()
                'n' -> session.rotateXRight()
            }

            when(e.keyCode) {
                KeyEvent.VK_LEFT -> session.moveLeft()
                KeyEvent.VK_RIGHT -> session.moveRight()
            }
            session.repaint()
        }
}