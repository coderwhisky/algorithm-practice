package org.buaa.nlp.cj.cci150._8_1;

import java.util.Arrays;

/**
 * Created by whisky-yonk on 8/28/2015.
 */
public class _1_7_MatrixClear {
    public void clearMatrix(int[][] matrix, int m, int n) {
        int[] row = new int[m];
        int[] column = new int[n];

        // record rows and columns with 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    column[j] = 1;
                }
            }
        }

        // clear the item
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] == 1 || column[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        _1_7_MatrixClear matrixClear = new _1_7_MatrixClear();
        int[][] matrix = {
                {1,2,3,4},
                {5,6,0,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        matrixClear.clearMatrix(matrix, 4, 4);
        for (int i = 0; i < 4; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
