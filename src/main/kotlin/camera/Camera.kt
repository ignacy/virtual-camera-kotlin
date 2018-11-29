package camera

class Camera(var planeDistance: Double, val y: Double) {

    fun isVisible(point : Point3D) : Boolean {
        return (point.y >= y + planeDistance)
    }
}