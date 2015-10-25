package org.buaa.nlp.cj.jobOnlineProgram.Indeed;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Administrator on 2015/10/25.
 */
public class problem2 {
    public static String grading(int[] nums) {
        int maxCount = 0;
        int maxItem = 0;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int oldCount = map.get(nums[i]);
                map.put(nums[i], oldCount+1);
                if (maxCount < oldCount + 1) {
                    maxCount = oldCount + 1;
                    maxItem = nums[i];
                }
            } else {
                map.put(nums[i], 1);
                if (maxCount < 1) {
                    maxCount = 1;
                    maxItem = nums[i];
                }
            }
        }

        if (maxCount > nums.length / 2) {
            return String.valueOf(maxItem);
        } else {
            return "?";
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line1 = scanner.nextLine();
            String line2 = scanner.nextLine();
            int N = Integer.valueOf(line1.trim().split(" ")[0]);
            int M = Integer.valueOf(line1.trim().split(" ")[1]);
            String[] items = line2.trim().split(" ");
            int[] nums = new int[N];
            for (int i = 0; i < items.length; i++) {
                nums[i] = Integer.valueOf(items[i].trim());
            }
            String ser = grading(nums);
            System.out.println(ser);
        }
    }
}

/**
 * B - 採点/Grading
 * Problem Statement
 Mr. Takahashi is marking examination papers of his students. Unfortunately, he has forgotten the correct answer to a certain question.

 N students answered this question by an integer between 0 and M, inclusive. He has decided to assume the correct answer to be the integer X if more than half of the students answered X.

 You are given the answers of the N students to this question. If he is going to assume the correct answer to be some integer X, print the value of X. If he is unable to assume the correct answer to be any integer, print ?.

 Input
 Input is given from Standard Input in the following format:

 N M
 A1 A2 ... AN
 The first line contains two space-separated integers N(1≦N≦105) and M(1≦M≦105).
 The second line contains N space-separated integers A1, A2, …, AN. For each i(1≦i≦N), Ai(0≦Ai≦M) represents the answer of the ith student.
 Output
 If Mr. Takahashi is going to assume the correct answer to be some integer X, print the value of X in a single line. Otherwise, print ?. Be sure to print a newline at the end of output.

 Partial Points
 Partial points may be awarded in this problem:

 40 points will be awarded for passing the test set satisfying N≦100, M≦100.
 Another 60 points will be awarded for passing the test set without additional constraints.
 入力例1
 3 2
 2 1 2
 出力例1
 2
 入力例2
 4 2
 2 1 2 1
 出力例2
 ?
 入力例3
 10 1
 0 0 0 0 0 0 1 1 1 1
 出力例3
 0
 入力例4
 10 5
 0 1 2 3 4 5 5 5 5 5
 出力例4
 ?
 */
