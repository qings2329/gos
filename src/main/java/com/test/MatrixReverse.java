package com.test;

public class MatrixReverse {


    public static void main(String[] args) {

        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}};
        int x = matrix.length;
        int y = matrix[0].length;

        int[][] newMatrix = new int[y][x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                newMatrix[j][i] = newMatrix[i][j];
            }
        }

    }

}
