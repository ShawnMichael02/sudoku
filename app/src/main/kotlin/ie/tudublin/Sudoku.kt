package ie.tudublin

class Sudoku(private val board: Array<IntArray>) {

    var iterations = 0
        private set

    private val maxIterations = 2_000_000

    fun solve(): Boolean {
        iterations = 0

        if (board.size != 9 || board.any { it.size != 9 }) {
            return false
        }

        if (!isValidBoard()) {
            return false
        }

        return solveBoard()
    }

    private fun solveBoard(): Boolean {
        iterations++

        if (iterations > maxIterations) {
            return false
        }

        for (row in 0 until 9) {
            for (col in 0 until 9) {

                if (board[row][col] == 0) {

                    for (number in 1..9) {

                        if (isSafe(row, col, number)) {
                            board[row][col] = number

                            if (solveBoard()) {
                                return true
                            }

                            board[row][col] = 0
                        }
                    }

                    return false
                }
            }
        }

        return true
    }

    private fun isSafe(row: Int, col: Int, number: Int): Boolean {

        for (i in 0 until 9) {
            if (board[row][i] == number ||
                board[i][col] == number
            ) {
                return false
            }
        }

        val boxRow = (row / 3) * 3
        val boxCol = (col / 3) * 3

        for (r in boxRow until boxRow + 3) {
            for (c in boxCol until boxCol + 3) {
                if (board[r][c] == number) {
                    return false
                }
            }
        }

        return true
    }

    private fun isValidBoard(): Boolean {

        for (row in 0 until 9) {
            for (col in 0 until 9) {

                val number = board[row][col]

                if (number !in 0..9) {
                    return false
                }

                if (number != 0) {
                    board[row][col] = 0
                    val valid = isSafe(row, col, number)
                    board[row][col] = number

                    if (!valid) {
                        return false
                    }
                }
            }
        }

        return true
    }
}