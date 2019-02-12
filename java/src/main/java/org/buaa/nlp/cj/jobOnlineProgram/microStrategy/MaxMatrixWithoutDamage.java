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

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        int max = 0;
        for (int i = 1; i < h; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                int topIdx = stack.peek();
                int cur = 0;
                if (tmp[topIdx] < tmp[i]) {
                    cur = tmp[i];
                    max = tmp[i] > max ? tmp[i] : max;
                    stack.push(i);
                } else {
                    while (tmp[topIdx] >= tmp[i]) {
                        topIdx = stack.pop();
                        cur = (i-topIdx)*tmp[topIdx];
                        max = max < cur ? cur : max;
                        topIdx = stack.peek();
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] field = {
                {0,1,1,1,1},
                {1,0,1,1,1},
                {1,1,0,1,1},
                {0,1,1,0,1}
        };
        int w = field.length;
        int h = field[0].length;

        System.out.println(maxArea(w,h,field));
    }
}
