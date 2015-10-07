package org.buaa.nlp.cj.codingInterviewGuide._2015_09_09;

/**
 * 题目三
 给定一个N*N的矩阵matrix，在这个矩阵中只有0和1两种值，返回边框全是1的最大正方形的边长长度。
 例如:
 01111
 01001
 01001
 01111
 01011
 其中，边框全是1的最大正方形的大小为4*4，所以返回4。
 * Created by whisky-yonk on 10/6/2015.
 */
public class _3_MaxMatrix {
    /**
     * 初始化两个数组，right[i][j] 表示 m[i][j] 中右边连续的1的个数
     * down[i][j] 表示 m[i][j] 中下边连续的1的个数
     *
     * @param m
     * @param right
     * @param down
     */
    public static void setBorderMap(int[][] m, int[][] right, int[][] down) {
        int r = m.length;
        int c = m[0].length;
        if (m[r-1][c-1] == 1) {
            right[r-1][c-1] = 1;
            down[r-1][c-1] = 1;
        }
        for (int i = r-2; i >=0; i--) {
            if (m[i][c-1] == 1) {
                right[i][c-1] = 1;
                down[i][c-1] = down[i+1][c-1] + 1;
            }
        }
        for (int i = c-2; i >= 0; i--) {
            if (m[r-1][i] == 1) {
                right[r-1][i] = right[r-1][i+1] + 1;
                down[r-1][i] = 1;
            }
        }
        for (int i = r-2; i >= 0; i--) {
            for (int j = c-2; j >= 0; j--) {
                if (m[i][j] == 1) {
                    right[i][j] = right[i][j+1] + 1;
                    down[i][j] = down[i+1][j] + 1;
                }
            }
        }
    }

    /**
     * 判断是否存在大小为 size 的正方形
     * @param size
     * @param right
     * @param down
     * @return
     */
    public static boolean hasSizeOfBorder(int size, int[][] right, int[][] down) {
        for (int i = 0; i < right.length - size + 1; i++) {
            for (int j = 0; j < right[0].length - size + 1; j++) {
                if (right[i][j] >= size && down[i][j] >= size
                        && right[i+size-1][j] >= size
                        && down[i][j+size-1] >= size)
                    return true;
            }
        }
        return false;
    }

    /**
     * 求边界为1的最大正方形
     * @param m
     * @return
     */
    public static int getMaxSize(int[][] m) {
        int[][] right = new int[m.length][m[0].length];
        int[][] down = new int[m.length][m[0].length];
        setBorderMap(m, right, down);
        for (int size = Math.min(m.length, m[0].length); size > 0; size--) {
            if (hasSizeOfBorder(size, right, down))
                return size;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] m = {
                {0,1,1,1,1},
                {0,1,0,0,1},
                {0,1,0,0,1},
                {0,1,1,1,1},
                {0,1,0,1,1}
        };
        System.out.println(getMaxSize(m));
    }
}
