package camera

import java.awt.Graphics

class Scene(private val objects: List<Cuboid>) {
    val x: Int
    val z: Int

    init {
        this.x = WIDTH / 2
        this.z = HEIGHT / 2
    }

    companion object {
        val HEIGHT = 600
        val WIDTH = 600
    }

    fun draw(graphics: Graphics, camera: Camera) {
        objects.map { it.draw(graphics, camera, this) }
    }
}