package camera

import java.awt.Graphics

class Scene(private val objects: List<Cuboid>) {
    companion object {
        val HEIGHT = 600
        val WIDTH = 600
    }

    val x = HEIGHT / 2
    val z = WIDTH / 2

    fun draw(graphics: Graphics, camera: Camera) {
        objects.map { it.draw(graphics, camera, this) }
    }
}