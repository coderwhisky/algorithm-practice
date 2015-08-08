package org.buaa.nlp.cj.leetcode;

/**
 * Created by Administrator on 2015/7/8.
 */
public class _7_ReverseInteger {
    public int reverse(int x) {
        int res = 0;
        int max = 0x7fffffff;
        int min = 0x80000000;
        while (x != 0) {
            res = (res*10) + (x%10);
            if (res > max || res < min) {
                res = 0;
                return res;
            }
            x = x/10;
        }
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(0x7fffffff);
//        System.out.println(0x80000000);
        return res;
    }

    public static void main(String[] args) {
        _7_ReverseInteger reverseInteger = new _7_ReverseInteger();
        int res = reverseInteger.reverse(1534236469);
        System.out.println(res);
    }
}
