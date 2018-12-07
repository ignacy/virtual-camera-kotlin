import camera.Cuboid
import camera.Point3D
import camera.Scene
import camera.Camera
import gui.Canvas
import gui.KeyHandler
import java.awt.Color
import java.awt.EventQueue
import javax.swing.JFrame
import javax.swing.WindowConstants

Jestes?

tak


Bez zooma to i tak lipa ale we 2 to chyba nie pisalo by sie 
tylko najpierw jeden pozniej drugij i by bylo
no jak dziala to nie jest zle


A co jest jak popiszemy i chce zrobic commit?
Na mnie czy na ciebie bedzie?
Czy rozmysli sie samo


chyba na ciebie bo tak jakby dzielimy tylko edytor sam a reszte masz swoje

Sprawdzmy :decode

:D
class Application : JFrame() {
    init {
        this.isResizable = false
        this.title = "Wirtualna Kamera"
        this.setSize(Scene.WIDTH, Scene.HEIGHT)
        this.setLocationRelativeTo(null)
        this.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        val objects = listOf(
                Cuboid(Point3D(25.0, 250.0, -50.0), 100, Color.decode("#3D9970")),
                Cuboid(Point3D(-200.0, 250.0, -100.0), 150, Color.decode("#85144b")),
                Cuboid(Point3D(-100.0, 250.0, 100.0), 150, Color.decode("#FFDC00"))
        )

        val camera = Camera(200.0, 0.0)
        val scene = Scene(objects)
        val canvas = Canvas(scene, camera)

        this.addKeyListener(KeyHandler(camera, scene, canvas))
        this.add(canvas)
    }

    fun start() {
        this.isVisible = true
    }
}

fun main(args: Array<String>) {
    EventQueue.invokeLater { Application().start() }
}