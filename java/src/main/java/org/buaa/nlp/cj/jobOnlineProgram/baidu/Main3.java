package org.buaa.nlp.cj.jobOnlineProgram.baidu;

import java.util.Scanner;

/**
 * Created by whisky-yonk on 9/28/2015.
 */
public class Main3 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int x = sc.nextInt();

        int m = b - a + 1;
        double r1 = 1;
        for(int i = n+1; i <= m; i++) {
            r1 *= i;
        }
        double r2 = 1;
        for(int i = 1; i <= (m-n); i++)
            r2 *= i;
        double r = r2/r1;
        System.out.println(r);
        String s = String.format("%.4f", r);
        System.out.println(s);
    }

}
