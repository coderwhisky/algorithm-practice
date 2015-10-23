package org.buaa.nlp.cj.jobOnlineProgram.microStrategy;

import java.util.Stack;

/**
 * 一个长x宽为w*h的矩形，可能存在1*1的坏块，求不包含坏块的最大矩形面积
 * Created by whisky-yonk on 10/21/2015.
 */
public class MaxMatrixWithoutDamage {
    public static int maxArea(int w, int h, int[][] field) {
        int[] tmp = new int[h];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (field[i][j] == 1) {
                    tmp[j] += 1;
                }
            }
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int max = 0;
        for (int i = 1; i < h; i++) {
            int topIdx = stack.peek();
            if (tmp[topIdx] < tmp[i]) {
                stack.push(i);
            } else {
                topIdx = stack.pop();
                while (tmp[topIdx] >= tmp[i]) {
                    topIdx = stack.pop();
                }
            }
        }
        return 0;
    }
}
