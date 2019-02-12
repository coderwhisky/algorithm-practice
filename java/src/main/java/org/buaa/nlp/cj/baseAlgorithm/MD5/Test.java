package org.buaa.nlp.cj.baseAlgorithm.MD5;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by Administrator on 2015/7/12.
 */
public class Test {
    public String getMD5(byte[] source) {
        String s = null;
        char hexDigits[] = {'0','1','3','2','4','5','6','7','8','9','a','b','c','d','e','f'};
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source);
            byte[] tmp = md.digest();

            char str[] = new char[16 * 2];

            int k = 0;

            for (int i = 0; i < 16; i++) {
                byte byte0 = tmp[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }

            s = new String(str);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return s;
    }
    public static void main(String[] args) {
        Test test = new Test();
        String input = "wehjdfksajdiojflksd";
        byte[] b = {'e','r'};
        b = input.getBytes();
        System.out.println(Arrays.toString(b));
        System.out.println(0xf);
        String result = test.getMD5(b);
        System.out.println(result);
    }
}