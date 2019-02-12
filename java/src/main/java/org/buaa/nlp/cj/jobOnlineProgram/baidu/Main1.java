package org.buaa.nlp.cj.jobOnlineProgram.baidu;

import java.util.Scanner;

/**
 * Created by whisky-yonk on 9/28/2015.
 */
public class Main1 {

    static int[] factor = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600 };

    public static int getK(String s) {
        int n = s.length();
        int sum = 0;
        for(int i = 0; i < n; i++) {
            int t = 0;
            for(int j = i + 1; j < n; j++) {
                if(s.charAt(j) < s.charAt(i))
                    t += 1;
            }
            sum += t*factor[n - i - 1];
        }
        return sum + 1;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//
//		String s = "abcdefghijkl";
//		s = "hgebkflacdji";
//		s = "gfkedhjblcia";
//
//		int r = getK(s);
//		System.out.println(r);
//
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int n = Integer.parseInt(line);
        int i = 0;
        while(i < n) {
            line = sc.nextLine();
            int result = getK(line);
            System.out.println(result);

            i++;
        }
    }

}
