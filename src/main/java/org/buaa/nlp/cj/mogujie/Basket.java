package org.buaa.nlp.cj.mogujie;

import java.util.Scanner;

/**
 * Created by whisky-yonk on 9/19/2015.
 */
public class Basket {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        int n = scanner.nextInt();
        boolean[] tag = new boolean[p];
        for (int i = 0; i < p; i++)
            tag[i] = false;
        for (int i = 0; i < n; i ++) {
            int x = scanner.nextInt();
            int tmp = x % p;
            if (tag[tmp]) {
                System.out.println(i + 1);
                return;
            } else {
                tag[tmp] = true;
            }
        }
    }
}
