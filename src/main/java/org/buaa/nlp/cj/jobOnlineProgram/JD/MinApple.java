package org.buaa.nlp.cj.jobOnlineProgram.JD;

import java.util.Scanner;

/**
 * 森林中有一堆苹果，有N只熊，第一只熊将苹果扔掉一个，将剩下的分成N份，自己拿走一份。
 * 第二只熊将剩下的部分扔掉一个，分成N份，自己拿走一份
 * .....以此类推
 * 求森林中最少有多少苹果
 *
 * //分析：
 * 第i只熊取走苹果为ai
 第i+1只熊取走苹果为aii
 N*aii = (N-1)*ai-1
 N(aii+1) = (N-1)*(ai+1)
 ai = N*(aii+1)/(N-1) - 1
 a0 = (N-1)^(N-1)

 对于每次剩下的总数
 si-1-(si-1)/N = sii
 (N-1)(si-1) = N*sii
 si = N*sii/(N-1) +1
 * Created by whisky-yonk on 9/18/2015.
 */
public class MinApple {
    public static void main(String[] args) {
        MinApple main2 = new MinApple();

        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int result = main2.countApple(a);
        System.out.println(result);
    }
    // a(n)=a(n+1)-1-(a(n+1)-1)/a
    // a(n+1) = 1+ (a/(a-1))*a(n)
    public int countApple(int n) {
        int tmp = 1;
        int sum = 0;

        for (int i = 1; i <= n-1; i++) {
            tmp = tmp*(n-1);
        }

//        tmp = tmp-1;
        sum = n*tmp/(n-1) + 1;
//        sum = tmp;
        for (int i = 1; i <= n; i++) {
            tmp = n*(tmp+1)/(n-1) - 1;
            sum = sum + tmp + 1;
//            sum = n*sum/(n-1) + 1;
        }
        return sum;
    }


}
