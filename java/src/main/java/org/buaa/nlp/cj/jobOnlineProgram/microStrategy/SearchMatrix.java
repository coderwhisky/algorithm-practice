package org.buaa.nlp.cj.jobOnlineProgram.microStrategy;

/**
 * Created by whisky-yonk on 10/31/2015.
 */
public class SearchMatrix {
    public static boolean matrixSearch(int[][] matrix, int tg) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (tg < matrix[0][0] || tg > matrix[n-1][m-1]) {
            return false;
        }
        return false;
    }

    public static boolean rowSearch(int[][] matrix, int tg) {
        int row = matrix.length, col = matrix[0].length;
        int low = 0, high = 0, mid = 0, midVal = 0, fixMin = -1;
        return false;
    }

    public static boolean colSearch(int[][] matrix, int tg) {
        return false;
    }
    public static void main(String[] args) {

    }
}
