package ie.tudublin

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SudokuTest {

    @Test
    fun `should solve a valid Sudoku puzzle`() {
        val board = arrayOf(
            intArrayOf(5, 3, 0, 0, 7, 0, 0, 0, 0),
            intArrayOf(6, 0, 0, 1, 9, 5, 0, 0, 0),
            intArrayOf(0, 9, 8, 0, 0, 0, 0, 6, 0),
            intArrayOf(8, 0, 0, 0, 6, 0, 0, 0, 3),
            intArrayOf(4, 0, 0, 8, 0, 3, 0, 0, 1),
            intArrayOf(7, 0, 0, 0, 2, 0, 0, 0, 6),
            intArrayOf(0, 6, 0, 0, 0, 0, 2, 8, 0),
            intArrayOf(0, 0, 0, 4, 1, 9, 0, 0, 5),
            intArrayOf(0, 0, 0, 0, 8, 0, 0, 7, 9)
        )

        val sudoku = Sudoku(board)

        assertTrue(sudoku.solve())
        assertEquals(4, board[0][2])
        assertEquals(3, board[8][0])
    }

    @Test
    fun `should reject an invalid Sudoku board`() {
        val board = arrayOf(
            intArrayOf(5, 5, 0, 0, 7, 0, 0, 0, 0),
            intArrayOf(6, 0, 0, 1, 9, 5, 0, 0, 0),
            intArrayOf(0, 9, 8, 0, 0, 0, 0, 6, 0),
            intArrayOf(8, 0, 0, 0, 6, 0, 0, 0, 3),
            intArrayOf(4, 0, 0, 8, 0, 3, 0, 0, 1),
            intArrayOf(7, 0, 0, 0, 2, 0, 0, 0, 6),
            intArrayOf(0, 6, 0, 0, 0, 0, 2, 8, 0),
            intArrayOf(0, 0, 0, 4, 1, 9, 0, 0, 5),
            intArrayOf(0, 0, 0, 0, 8, 0, 0, 7, 9)
        )

        val sudoku = Sudoku(board)

        assertFalse(sudoku.solve())
    }

    @Test
    fun `should reject an invalid completed Sudoku board`() {
        val board = arrayOf(
            intArrayOf(4, 2, 3, 4, 5, 6, 7, 8, 9),
            intArrayOf(4, 5, 6, 7, 8, 9, 1, 2, 3),
            intArrayOf(7, 8, 9, 1, 2, 3, 4, 5, 6),
            intArrayOf(2, 1, 4, 3, 6, 5, 8, 9, 7),
            intArrayOf(3, 6, 5, 8, 9, 7, 2, 1, 4),
            intArrayOf(8, 9, 7, 2, 1, 4, 3, 6, 5),
            intArrayOf(5, 3, 1, 6, 4, 2, 9, 7, 8),
            intArrayOf(6, 4, 2, 9, 7, 8, 5, 3, 1),
            intArrayOf(9, 7, 8, 5, 3, 1, 6, 4, 2)
        )

        val sudoku = Sudoku(board)

        assertFalse(sudoku.solve())
    }
}