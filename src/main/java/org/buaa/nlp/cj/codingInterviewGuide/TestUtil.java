package org.buaa.nlp.cj.codingInterviewGuide;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Administrator on 2015/9/2.
 */
public class TestUtil {
    public static int[] createArray(int len) {
        int[] result = new int[len];
        Random random = new Random();

        for (int i = 0; i < len; i++) {
            result[i] = random.nextInt(20) - 10;
//            result[i] = (int)Math.random()*(10+10) -10;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = TestUtil.createArray(10);
        System.out.println(Arrays.toString(arr));
    }
}
