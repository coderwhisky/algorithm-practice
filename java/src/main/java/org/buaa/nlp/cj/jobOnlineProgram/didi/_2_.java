package org.buaa.nlp.cj.jobOnlineProgram.didi;

/**
 * Created by Administrator on 2015/10/15.
 */
public class _2_ {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 10; i < 100; i++) {
            if(i % 7 == 2) {
                int tmp = i;
                while (tmp > 0) {
                    System.out.print(tmp % 10 + " ");
                    sum += tmp %10;
                    tmp = tmp/10;
                    System.out.println(tmp);
                }
            } else {
                sum += i;
            }
        }

        System.out.println("sum: " + sum);
    }
}
