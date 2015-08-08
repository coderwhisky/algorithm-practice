package org.buaa.nlp.cj.leetcode;

/**
 * Created by I320592 on 8/6/2015.
 */
public class _69_sqrt {
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        if (x == 1)
            return 1;
        long i = 0;
        long j = x/2 + 1;
        while (i < j) {
            long mid = (i+j) / 2;
            long tmp = mid * mid;
            if (tmp == x) {
                return (int) mid;
            }else if (tmp < x) {
                i = mid + 1;
            }else {
                j = mid - 1;
            }
        }
        if (j*j > x)
            return (int) (j-1);
        else
            return (int) j;
    }

    public static void main(String[] args) {
        int input = 2147395599;
        int result =new _69_sqrt().mySqrt(input);
        System.out.println(result);
    }
}
