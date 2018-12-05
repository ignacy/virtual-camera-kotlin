package algebra

import java.util.*
import kotlin.math.cos
import kotlin.math.sin

fun zerosMatrix(rows : Int, cols : Int) : Matrix = Matrix(Array(rows) { Array(cols) { 0.0 } })
fun vector(vararg values : Double) : Matrix = Matrix(values.map { arrayOf(it) }.toTypedArray())
fun xRotation(fi: Double): Matrix = Matrix(arrayOf(
        arrayOf(1.0, 0.0, 0.0, 0.0),
        arrayOf(0.0, cos(fi), -sin(fi), 0.0),
        arrayOf(0.0, sin(fi), cos(fi), 0.0),
        arrayOf(0.0, 0.0, 0.0, 1.0)
))
fun yRotation(fi: Double): Matrix = Matrix(arrayOf(
        arrayOf(cos(fi), 0.0, sin(fi), 0.0),
        arrayOf(0.0, 1.0, 0.0, 0.0),
        arrayOf(-sin(fi), 0.0, cos(fi), 0.0),
        arrayOf(0.0, 0.0, 0.0, 1.0)
))
fun zRotation(fi: Double): Matrix = Matrix(arrayOf(
        arrayOf(cos(fi), -sin(fi), 0.0, 0.0),
        arrayOf(sin(fi), cos(fi), 0.0, 0.0),
        arrayOf(0.0, 0.0, 1.0, 0.0),
        arrayOf(0.0, 0.0, 0.0, 1.0)
))
fun moveLeft(step: Double): Matrix = Matrix(arrayOf(
        arrayOf(1.0, 0.0, 0.0, step),
        arrayOf(0.0, 1.0, 0.0, 1.0),
        arrayOf(0.0, 0.0, 1.0, 1.0),
        arrayOf(0.0, 0.0, 0.0, 1.0)
))
fun moveRight(step: Double): Matrix = Matrix(arrayOf(
        arrayOf(1.0, 0.0, 0.0, -step),
        arrayOf(0.0, 1.0, 0.0, 0.0),
        arrayOf(0.0, 0.0, 1.0, 0.0),
        arrayOf(0.0, 0.0, 0.0, 1.0)
))
fun moveUp(step: Double): Matrix = Matrix(arrayOf(
        arrayOf(1.0, 0.0, 0.0, 0.0),
        arrayOf(0.0, 1.0, 0.0, 0.0),
        arrayOf(0.0, 0.0, 1.0, -step),
        arrayOf(0.0, 0.0, 0.0, 1.0)
))
fun moveDown(step: Double): Matrix = Matrix(arrayOf(
        arrayOf(1.0, 0.0, 0.0, 0.0),
        arrayOf(0.0, 1.0, 0.0, 0.0),
        arrayOf(0.0, 0.0, 1.0, step),
        arrayOf(0.0, 0.0, 0.0, 1.0)
))
fun moveCloser(step: Double): Matrix = Matrix(arrayOf(
        arrayOf(1.0, 0.0, 0.0, 0.0),
        arrayOf(0.0, 1.0, 0.0, -step),
        arrayOf(0.0, 0.0, 1.0, 0.0),
        arrayOf(0.0, 0.0, 0.0, 1.0)
))
fun moveFurther(step: Double): Matrix = Matrix(arrayOf(
        arrayOf(1.0, 0.0, 0.0, 0.0),
        arrayOf(0.0, 1.0, 0.0, step),
        arrayOf(0.0, 0.0, 1.0, 0.0),
        arrayOf(0.0, 0.0, 0.0, 1.0)
))

class Matrix(private val m: Array<Array<Double>>) {
    override fun toString(): String = Arrays.deepToString(m)

    val rows get() = m.size
    val cols get() = m[0].size

    private fun setAt(row: Int, col: Int, value: Double) {
        m[row][col] = value
    }

    operator fun get(row: Int, col: Int) = m[row][col]
    operator fun set(row: Int, col: Int, value: Double) = this.setAt(row, col, value)

    fun multiple(b: Matrix) : Matrix {
        assert(this.cols == b.rows)
        val result = zerosMatrix(this.rows, b.cols)

        for (i in 0 until this.rows) {
            for (j in 0 until b.cols) {
                for (k in 0 until this.cols) {
                    result[i, j] += this[i, k] * b[k, j]
                }
            }
        }
        return result
    }

    fun normalized() : Matrix {
        var result = zerosMatrix(this.rows, this.cols)

        for (i in 0 until this.rows) {
            for (j in 0 until this.cols) {
                result[i, j] = this[i, j] / this[i, this.cols - 1]
            }
        }

        for (i in 0 until this.rows) {
            result[i, this.cols - 1] = 0.0
        }

        return result
    }
}