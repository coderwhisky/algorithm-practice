package org.buaa.nlp.cj.leetcode;

/**
 * Created by Administrator on 2015/7/8.
 */
public class _9_PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int len = 0;
        int xcopy = x;
        int lnum, rnum;
        while (xcopy != 0 ) {
            len++;
            xcopy = xcopy/10;
        }
        int xcopy1 = x, xcopy2 = x;
        while (len > 0) {
            lnum = (int) (xcopy1/((int)Math.pow(10, len-1)));
            xcopy1 = (int) (xcopy1%((int)Math.pow(10, len-1)));
//            System.out.println("xcopy1:" + xcopy1);
            rnum = xcopy2%10;
            xcopy2 = xcopy2/10;
//            System.out.println("xcopy2:" + xcopy2);
            if (lnum != rnum)
                return false;
            len--;
        }
        System.out.println(0x7fffffff);
        System.out.println(0x80000000);
        return true;
    }

    public boolean isPalindrome2(int x) {
        int px = 0;
        int xcopy = x;
        while (xcopy != 0 ) {
            px = px*10 + xcopy%10;
            xcopy = xcopy/10;
        }
        if (x == px)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        _9_PalindromeNumber palindromeNumber = new _9_PalindromeNumber();
        boolean flag = palindromeNumber.isPalindrome(-2147447412);
        System.out.println(flag);
    }
}
