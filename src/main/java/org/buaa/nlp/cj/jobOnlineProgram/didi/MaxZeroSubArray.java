package org.buaa.nlp.cj.jobOnlineProgram.didi;

import sun.security.util.Length;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by whisky-yonk on 9/25/2015.
 */
public class MaxZeroSubArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] charArry = str.trim().split(" ");
        int[] num = new int[charArry.length];
        for (int i = 0; i < charArry.length; i++) {
            num[i] = Integer.valueOf(charArry[i]);
        }

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,-1);
        int sum = 0;
        int len = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
            if (map.containsKey(sum)) {
                if (len < i - map.get(sum)) {
                    len = i - map.get(sum);
                    start = map.get(sum);
                    end = i;
                }
                if (!map.containsKey(sum)) {
                    map.put(sum, i);
                }
            }
        }

    }

}
