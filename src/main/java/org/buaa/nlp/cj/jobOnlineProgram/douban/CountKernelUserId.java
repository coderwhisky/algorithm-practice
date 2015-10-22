package org.buaa.nlp.cj.jobOnlineProgram.douban;

/**
 * Created by Administrator on 2015/10/20.
 */
public class CountKernelUserId {
    public static void main(String[] args) {
//        System.out.println(1000001 + 1000000000);
        long sum = countKernelU();
        System.out.println(sum);
    }

    public static long countKernelU() {
        long sum = 0;
        for (long i = 1000001; i < 1001000002; i++) {
            if (i%6 == 0 || i%9 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
