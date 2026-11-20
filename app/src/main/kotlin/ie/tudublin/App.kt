package ie.tudublin

import java.io.File

fun main(args: Array<String>) {

    if (args.isEmpty()) {
        println("Please provide a Sudoku file.")
        println("Usage: sudoku <filename>")
        return
    }

    try {
        val file = File(args[0])

        if (!file.exists()) {
            println("File not found: ${args[0]}")
            return
        }

        val lines = file.readLines()

        if (lines.size != 9) {
            println("Invalid Sudoku file. It must contain 9 rows.")
            return
        }

        val board = Array(9) { row ->
            val values = lines[row].filter { it.isDigit() }

            if (values.length != 9) {
                println("Invalid Sudoku row: ${row + 1}")
                return
            }

            IntArray(9) { col ->
                values[col].digitToInt()
            }
        }

        println("Original Sudoku:")
        printBoard(board)

        val sudoku = Sudoku(board)

        println("\nSolving Sudoku...")

        if (sudoku.solve()) {
            println("\nSolution:")
            printBoard(board)
            println("\nIterations: ${sudoku.iterations}")
        } else {
            println("\nNo valid solution found.")
            println("Iterations: ${sudoku.iterations}")
        }

    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}

fun printBoard(board: Array<IntArray>) {
    for (row in board) {
        println(row.joinToString(" "))
    }
}