package org.buaa.nlp.cj;

/**
 * Created by I320592 on 8/3/2015.
 */
public class _29_DivedeTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            return Integer.MAX_VALUE;

        int result = 0;
        if(dividend==Integer.MIN_VALUE)
        {
            result = 1;
            dividend += Math.abs(divisor);
        }
        if(divisor==Integer.MIN_VALUE)
            return result;

        long cpDividend = Math.abs(dividend);
        long cpDivisor = Math.abs(divisor);

        long c = 1;
        // 先将除数每次乘以2，直到比被除数大
        while (cpDividend > cpDivisor) {
            cpDivisor <<= 1;
            c <<= 1;
        }

        // 如果被除数在减去（多次乘以2的除数）之后仍然比原来的除数要大：亦即仍然够除
        while (cpDividend >= Math.abs(divisor)) {
            // 如果不够减则证明（多次乘以2的除数）比被除数要大，则需要使除数除以2（同时c也除以2，除法用右移）
            while (cpDividend >= cpDivisor) {
                cpDividend -= cpDivisor;
                result += c;
            }
            cpDivisor >>= 1;
            c >>= 1;
        }
        return (((dividend ^ divisor) >>> 31) == 1) ? (-result) : result;
    }

    public static void main(String[] args) {
        _29_DivedeTwoIntegers divedeTwoIntegers = new _29_DivedeTwoIntegers();
        int result = divedeTwoIntegers.divide(-2147483648, -1);
        System.out.println(result);
    }
}
