package org.buaa.nlp.cj.others;

import java.util.Random;

/**
 * 问题描述：程序的输入包含两个整数m和n，其中m<n。
 * 输出是0~n-1范围内的m个随机整数，
 * 要求：每个数选择出现的概率相等，且按序输出。
 * Created by whisky-yonk on 8/24/2015.
 */
public class EqualProbabilityGen {
    public void gen(int n, int m) {
        int select = m;
        int remain = n;

        Random ran = new Random();
        for (int i = 0; i < n; i++) {
            int kk = ran.nextInt();
            System.out.println(kk);
            if (kk % remain < select) {
                System.out.println(i);
                select--;
            }
            remain--;
        }
    }

    public static void main(String[] args) {
        EqualProbabilityGen equalProbabilityGen = new EqualProbabilityGen();
        equalProbabilityGen.gen(5,2);
    }
}
