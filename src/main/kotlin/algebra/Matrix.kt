package algebra

class Matrix(private val m: Array<Array<Double>>) {
    companion object {
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
        val x = Array(4) { Array(4) { 0.0 } }
        val y = p.m
        for (w in 0..3) {
            for (k in 0..3) {
                x[w][k] = y!![w][0] * m!![0][k] + y[w][1] * m!![1][k] + y[w][2] * m!![2][k] + y[w][3] * m!![3][k]
            }
        }
        return Matrix(x)
    }


}