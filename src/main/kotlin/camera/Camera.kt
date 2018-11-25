package camera

class Camera(planeDistance: Double, y: Double) {
    var planeDistance: Double = 0.toDouble()
    var y: Double = 0.toDouble()

    init {
        this.planeDistance = planeDistance
        this.y = y
    }
}