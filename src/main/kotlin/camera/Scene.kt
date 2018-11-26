package camera

import java.util.ArrayList

class Scene(private val lines: ArrayList<Line3D>) {
    private val x: Int
    private val z: Int

    init {
        this.x = WIDTH / 2
        this.z = HEIGHT / 2
    }

    companion object {
        val HEIGHT = 600
        val WIDTH = 600
    }

}