package org.buaa.nlp.cj.jobOnlineProgram._360xiaozhao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by whisky-yonk on 9/15/2015.
 */
public class Main2 {
    private static String [][] number = {
            {" ", "-", " ", " ", " ", " ", " ", "-", " ", " ", "-", " ",   " ", " ", " ",   " ", "-", " ",   " ", "-", " ",   " ", "-", " ",   " ", "-", " ",   " ", "-", " ",   " "},
            {"|", " ", "|", " ", " ", "|", " ", " ", "|", " ", " ", "|",   "|", " ", "|",   "|", " ", " ",   "|", " ", " ",   " ", " ", "|",   "|", " ", "|",   "|", " ", "|",   " "},
            {" ", " ", " ", " ", " ", " ", " ", "-", " ", " ", "-", " ",   " ", "-", " ",   " ", "-", " ",   " ", "-", " ",   " ", " ", " ",   " ", "-", " ",   " ", "-", " ",   "*"},
            {"|", " ", "|", " ", " ", "|", "|", " ", " ", " ", " ", "|",   " ", " ", "|",   " ", " ", "|",   "|", " ", "|",   " ", " ", "|",   "|", " ", "|",   " ", " ", "|",   " "},
            {" ", "-", " ", " ", " ", " ", " ", "-", " ", " ", "-", " ",   " ", " ", " ",   " ", "-", " ",   " ", "-", " ",   " ", " ", " ",   " ", "-", " ",   " ", "-", " ",   " "}
    };

    public void printNumber(List<Integer> prinmes) {
        for (int i = 0; i < 5; i ++) {
            for (int j = 0; j < prinmes.size(); j ++) {
                String tmp = Integer.toString(prinmes.get(j));
                for (int k = 0; k < tmp.length(); k ++) {
                    int num = Integer.parseInt(tmp.substring(k, k + 1));
                    for (int n = 0; n < 3; n ++) {
                        System.out.print(number[i][num * 3 + n]);
                    }
                }
                if (j + 1 < prinmes.size()) {
                    System.out.print(number[i][30]);
                }
            }
            System.out.println();
        }
    }

    public List<Integer> primes2(int n) {
        List<Integer> result = new ArrayList<>();
//        int sqrtn = (int) Math.sqrt(n);
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                n /= i;
                result.add(i);
//                System.out.println(i);
                i--;
            }
        }
        return result;
    }



    public static void main(String args[])
    {
        Main2 main2 = new Main2();

//        Scanner cin = new Scanner(System.in);
//        int a;
//        a = cin.nextInt();
        List<Integer> result = main2.primes2(10);
        System.out.println(result.toString());
//        main2.primes2(4);
        main2.printNumber(result);



//        for (int i = 0; i < 10; i++) {
//            main2.printNumbers(i);
//            System.out.println();
//        }
    }



}
