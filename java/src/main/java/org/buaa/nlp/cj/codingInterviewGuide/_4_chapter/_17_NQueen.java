package org.buaa.nlp.cj.codingInterviewGuide._4_chapter;

/**
 * Created by Administrator on 2015/10/29.
 */
public class _17_NQueen {
    // +++++++++ 简单解法 +++++++++++++++ start

    public static int num1 (int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n];
        return process1(record, 0, n);
    }

    /**
     * 处理第 i 行
     * @param record
     * @param i
     * @param n
     * @return
     */
    public static int process1(int[] record, int i, int n) {
        if (i == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process1(record, i+1, n);
            }
        }
        return res;
    }

    public static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (record[k] == j || Math.abs(i-k) == Math.abs(record[k] - j)) {
                return false;
            }
        }
        return true;
    }
    // +++++++++ 简单解法 +++++++++++++++ end

    public static void main(String[] args) {
        int res = _17_NQueen.num1(4);
        System.out.println(res);
    }
}
