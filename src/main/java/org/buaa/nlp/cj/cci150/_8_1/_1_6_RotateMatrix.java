package org.buaa.nlp.cj.cci150._8_1;

import java.util.Arrays;

/**
 * Created by whisky-yonk on 8/28/2015.
 */
public class _1_6_RotateMatrix {
    public void rotate(int[][] matrix, int n) {
        for (int layer = 0; layer < n/2; layer++) {
            int first = layer;
            int last = n-1-layer;
            for (int i = first; i < last; i++) {
                int offset = i-first;
                // 存储上边
                int top = matrix[first][i];
                // 左到上
                matrix[first][i] = matrix[last-offset][first];
                // 下到左
                matrix[last-offset][first] = matrix[last][last-offset];
                // 右到下
                matrix[last][last-offset] = matrix[i][last];
                // 上到右
                matrix[i][last] = top;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        _1_6_RotateMatrix rotateMatrix = new _1_6_RotateMatrix();
        rotateMatrix.rotate(matrix, 4);
        for (int i = 0; i < 4; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
