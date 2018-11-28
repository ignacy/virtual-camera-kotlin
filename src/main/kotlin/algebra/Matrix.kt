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

        fun makeRotationYMatrix(fi: Double, sceneY: Double): Matrix {
            val m = this.identity()
            val cos = java.lang.Math.cos(fi)
            val sin = java.lang.Math.sin(fi)
            m.setAt(0, 0, cos);
            m.setAt(2, 2, cos);
            m.setAt(0, 2, sin);
            m.setAt(2, 0, -sin);
            return m;
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
}