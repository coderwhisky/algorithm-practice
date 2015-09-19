package org.buaa.nlp.cj.jobOnlineProgram.meituan;

/**
 * Created by whisky-yonk on 9/19/2015.
 */
public class _2_Int2Str {
    public static void main(String[] args) {
        String result = itoa(-936549);
        System.out.println(result);
    }

    public static String itoa(int i) {
        char[] cc = {'0','1','2','3','4','5','6','7','8','9'};

        String result = "";
        char tmp;

        if (i == 0) {
            tmp = cc[0];
            result += tmp;
            return result;
        }

        int a;
        if (i < 0) {
            a = ~i + 1;
        } else {
            a = i;
        }

        while (a != 0) {
            tmp = cc[a%10];
            result = tmp+result;
            a = a/10;
        }

        result = (i < 0) ? ("-"+result) : result;
        return result;
    }
}
