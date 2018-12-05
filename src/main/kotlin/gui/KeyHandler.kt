package gui

import camera.Camera
import camera.Scene
import java.awt.event.KeyEvent
import java.awt.event.KeyListener

class KeyHandler(private val camera : Camera, private val scene : Scene, private val canvas : Canvas) : KeyListener {
        override fun keyTyped(e: KeyEvent?) {
        }

        override fun keyReleased(e: KeyEvent?) {
        }

        override fun keyPressed(e: KeyEvent?) {
            when(e!!.keyCode) {
                //Rotations
                KeyEvent.VK_Z -> scene.rotateZLeft()
                KeyEvent.VK_X -> scene.rotateZRight()
                KeyEvent.VK_C -> scene.rotateYLeft()
                KeyEvent.VK_V -> scene.rotateYRight()
                KeyEvent.VK_B -> scene.rotateXLeft()
                KeyEvent.VK_N -> scene.rotateXRight()

                // Arrows
                KeyEvent.VK_LEFT -> scene.moveLeft()
                KeyEvent.VK_RIGHT -> scene.moveRight()
                KeyEvent.VK_UP -> scene.moveUp()
                KeyEvent.VK_DOWN -> scene.moveDown()

                // WSAD
                KeyEvent.VK_A -> scene.moveLeft()
                KeyEvent.VK_D -> scene.moveRight()
                KeyEvent.VK_W -> scene.moveCloser()
                KeyEvent.VK_S -> scene.moveFurther()

                //Zoom
                KeyEvent.VK_Q -> camera.planeDistance = camera.planeDistance + Scene.ZOOM_STEP
                KeyEvent.VK_E -> camera.planeDistance = camera.planeDistance - Scene.ZOOM_STEP
            }
            canvas.repaint()
        }
}