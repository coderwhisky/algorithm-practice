package org.buaa.nlp.cj.jobOnlineProgram.Indeed.stage2;

import java.util.Scanner;

/**
 * Created by Administrator on 2015/10/31.
 */
public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String l1 = scanner.nextLine();
            String l2 = scanner.nextLine();
//            if (l1 != null && l2 != null) {
//
//            }
            long n = Long.valueOf(l1.trim());
            long x = Long.valueOf(l2.trim());
            if (n % x == 0) {
                System.out.println(n/x);
            } else {
                System.out.println(n/x + 1);
            }
        }
    }
}
