package com.epam.training.exercise3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Eight Queens.
 */
public final class EightQueens {
    private EightQueens() {
    }

    /**
     * mian entry.
     *
     * @param args args
     */
    public static void main(String[] args) {
        ArrayList<char[][]> solutions = new ArrayList<>();
        char[][] result = new char[8][8];
        for (int r1 = 0; r1 < 8; r1++) {
            Arrays.fill(result[r1], '.');
        }
        solveAllNQueens(result, 0, solutions);
        System.out.println(solutions.size());
        for (int i = 0; i < solutions.size(); i++) {
            System.out.println("\nSolution " + (i + 1));

            char[][] board = solutions.get(i);
            for (int r = 0; r < board.length; r++) {
                for (int c = 0; c < board[r].length; c++) {
                    System.out.print(board[r][c]);
                }
                System.out.println();
            }
        }
    }


    private static char[][] copyBoard(char[][] board) {
        char[][] copy = new char[board.length][board[0].length];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                copy[r][c] = board[r][c];
            }
        }
        return copy;
    }

    private static boolean search(char[][] board) {
        boolean result = true;
        for (int i = 0; i < board.length; i++) {
            boolean found = false;
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'q') {
                    if (found) {
                        result = false;
                        break;
                    }
                    found = true;
                }
            }
        }
        return result;
    }

    private static boolean searchOffset(char[][] board) {
        boolean result = true;
        for (int offset = -board.length; offset < board.length; offset++) {
            boolean found = false;
            for (int i = 0; i < board.length; i++) {
                if (!inBounds(i, board.length - offset - i - 1, board)
                        && board[i][board.length - offset - i - 1] == 'q') {
                    if (found) {
                        result = false;
                        break;
                    }
                    found = true;
                }
            }
        }
        return result;
    }

    private static void solveAllNQueens(char[][] board, int col, ArrayList<char[][]> solutions) {
        if (col == board.length) {
            solutions.add(copyBoard(board));
            return;
        }
        boolean canBeSafe;
        for (int row = 0; row < board.length; row++) {
            board[row][col] = 'q';
            canBeSafe = search(board);
            if (canBeSafe) {
                canBeSafe = searchOffset(board);
            }
            if (canBeSafe) {
                solveAllNQueens(board, col + 1, solutions);
            }
            board[row][col] = '.';
        }
    }

    private static boolean inBounds(int row, int col, char[][] mat) {
        return row >= 0 && row < mat.length && col >= 0 && col < mat[0].length;
    }

}