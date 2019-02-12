package org.buaa.nlp.cj.others;

import java.util.Arrays;

/**
 * 给定一数组a[N]，我们希望构造数组b [N]，其中b[j]=a[0]*a[1]…a[N-1] / a[j]，在构造过程中，不允许使用除法：

 要求O（1）空间复杂度和O（n）的时间复杂度；

 除遍历计数器与a[N] b[N]外，不可使用新的变量（包括栈临时变量、堆空间和全局静态变量等）；

 实现程序（主流编程语言任选）实现并简单描述。
 * Created by I320592 on 8/7/2015.
 */
public class MultiplyArrayRebuild {
    public int[] arrayRebuild(int[] inArray) {
        int len = inArray.length;
        int[] result = new int[len];
        result[0] = 1;
        for (int i = 1; i < len; i++)
            result[i] = result[i-1] * inArray[i-1];
        int i;
        for (i = len - 2; i > 0; i--) {
            result[0] *= inArray[i+1];
            result[i] *= result[0];
        }
        result[0] = result[0]*inArray[i+1];
        return result;
    }

    public static void main(String[] args) {
        MultiplyArrayRebuild multiplyArrayRebuild = new MultiplyArrayRebuild();
        int[] inArray = {1,2,3,4,5};
        int[] result = multiplyArrayRebuild.arrayRebuild(inArray);
        System.out.println(Arrays.toString(result));
    }
}
