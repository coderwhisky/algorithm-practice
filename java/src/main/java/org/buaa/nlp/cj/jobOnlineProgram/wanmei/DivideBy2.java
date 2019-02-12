package org.buaa.nlp.cj.jobOnlineProgram.wanmei;

/**
 * 讲一个数拆分成2的n次方的和
 * Created by whisky-yonk on 10/13/2015.
 */
public class DivideBy2 {
    /*任何数都能分解成2的幂，给定整数n，求n的此类划分方法的数量！
    *f(2m+1）=f(2m), f(2m) = f(2m - 1) + f(m)，*/
    public static int countDividBy2(int n) {
        if (n == 1) {
            return 1;
        }else if (n % 2 == 0){
            return countDividBy2(n-1) + countDividBy2(n/2);
        } else {
            return countDividBy2(n-1);
        }
    }

    public static void divideBy2(int n) {
        while (n > 0) {
            int sum = 1;
            while (sum <= n) {
                sum <<= 1;
            }
            if (sum > n)
                sum >>= 1;
            System.out.print(sum + " ");
            n = n - sum;
        }
    }

    public static void main(String[] args) {
        divideBy2(17);
    }
}
