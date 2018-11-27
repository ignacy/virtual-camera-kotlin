package algebra

class Matrix(private val m: Array<Array<Double>>) {
    companion object {
        fun zeros(rows : Int, cols : Int) : Matrix {
            return Matrix(Array(rows) { Array(cols) { 0.0 } })
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
            val m = this.identity()
            val cos = java.lang.Math.cos(fi)
            val sin = java.lang.Math.sin(fi)
            m.setAt(0, 0, cos)
            m.setAt(1, 1, cos)
            m.setAt(1, 0, sin)
            m.setAt(0, 1, -sin)
            m.setAt(0, 3, (-1).toDouble() * sin * sceneY)
            m.setAt(1, 3, (cos - 1) * sceneY)
            return m
        }
    }

    fun setAt(w: Int, k: Int, d: Double) {
        m!![w][k] = d
    }

    fun at(row: Int, col: Int) = m!![row][col]

    fun multiple(p: Matrix) : Matrix {
        val x = Matrix.zeros(4, 4)
        for (row in 0..3) {
            for (col in 0..3) {
                x.setAt(row, col, p.at(row, 0) * this.at(0, col) + p.at(row, 1) * this.at(1, col) + p.at(row, 2) * this.at(2, col) + p.at(row, 3) * this.at(3, col))
            }
        }
        return x
    }


}