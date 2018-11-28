package gui

import java.awt.event.KeyEvent
import java.awt.event.KeyListener

class KeyHandler(var session: Session) : KeyListener {
        override fun keyTyped(e: KeyEvent?) {
        }

        override fun keyReleased(e: KeyEvent?) {
        }

        override fun keyPressed(e: KeyEvent?) {
            when(e!!.keyCode) {
                //Rotations
                KeyEvent.VK_Z -> session.rotateZLeft()
                KeyEvent.VK_X -> session.rotateZRight()
                KeyEvent.VK_C -> session.rotateYLeft()
                KeyEvent.VK_V -> session.rotateYRight()
                KeyEvent.VK_B -> session.rotateXLeft()
                KeyEvent.VK_N -> session.rotateXRight()

                // Arrows
                KeyEvent.VK_LEFT -> session.moveLeft()
                KeyEvent.VK_RIGHT -> session.moveRight()
                KeyEvent.VK_UP -> session.moveUp()
                KeyEvent.VK_DOWN -> session.moveDown()
                // WSAD
                KeyEvent.VK_A -> session.moveLeft()
                KeyEvent.VK_D -> session.moveRight()
                KeyEvent.VK_W -> session.moveUp()
                KeyEvent.VK_S -> session.moveDown()

                //Zoom
                KeyEvent.VK_Q -> session.zoomIn()
                KeyEvent.VK_E -> session.zoomOut()
            }
            session.repaint()
        }
}