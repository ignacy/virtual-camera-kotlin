package algebra

import kotlin.math.cos
import kotlin.math.sin

class Matrix(private val m: Array<Array<Double>>) {
    companion object {
        fun zeros(rows : Int, cols : Int) : Matrix {
            return Matrix(Array(rows) { Array(cols) { 0.0 } })
        }

        fun vector(vararg values : Double) : Matrix {
            return Matrix(arrayOf(values.toTypedArray()))
        }

        fun identity() : Matrix {
            return Matrix(
                    arrayOf(
                        arrayOf(1.0, 0.0, 0.0, 0.0),
                        arrayOf(0.0, 1.0, 0.0, 0.0),
                        arrayOf(0.0, 0.0, 1.0, 0.0),
                        arrayOf(0.0, 0.0, 0.0, 1.0)
                    )
            )
        }

       fun makeRotationZMatrix(fi: Double, sceneY : Double): Matrix {
            return Matrix(arrayOf(
                    arrayOf(cos(fi), -sin(fi), 0.0, 0.0),
                    arrayOf(sin(fi), cos(fi), 0.0, 0.0),
                    arrayOf(0.0, 0.0, 1.0, 0.0),
                    arrayOf(0.0, 0.0, 0.0, 1.0)
            ))
        }

        fun makeRotationYMatrix(fi: Double, sceneY: Double): Matrix {
            return Matrix(arrayOf(
                    arrayOf(cos(fi), 0.0, sin(fi), 0.0),
                    arrayOf(0.0, 1.0, 0.0, 0.0),
                    arrayOf(-sin(fi), 0.0, cos(fi), 0.0),
                    arrayOf(0.0, 0.0, 0.0, 1.0)
            ))
        }
    }

    fun setAt(w: Int, k: Int, d: Double) {
        m!![w][k] = d
    }

    fun rows() = m.size

    fun cols() = m[0].size

    fun at(row: Int, col: Int) = m!![row][col]

    fun multiple(b: Matrix) : Matrix {
        val result = Matrix.zeros(4, 4)

        for (i in 0 until this.rows()) {
            for (j in 0 until b.cols()) {
                for (k in 0 until this.cols()) {
                    result.setAt(i, j, result.at(i, j) + this.at(i, k) * b.at(k, j))
                }
            }
        }
        return result
    }

    fun normalized() : Matrix {
        var result = Matrix.zeros(this.rows(), this.cols())

        for (i in 0 until this.rows()) {
            for (j in 0 until this.cols()) {
                result.setAt(i, j, this.at(i, j) / this.at(i, this.cols() - 1))
            }
        }

        for (i in 0 until this.rows()) {
            result.setAt(i, this.cols() - 1, 0.0)
        }

        return result
    }
}