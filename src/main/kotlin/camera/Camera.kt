package camera

data class Camera(var planeDistance: Double, val y: Double)
fun isVisible(camera: Camera, point: Point3D): Boolean = point.y >= (camera.y + camera.planeDistance)
