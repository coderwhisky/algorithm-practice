package org.buaa.nlp.cj.cci150._8_1;

/**
 * Created by whisky-yonk on 8/26/2015.
 */
public class _1_4_ReplaceSpace {
    public char[] replaceSpace0(char[] chars, int len) {
        int shift = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ')
                shift++;
        }

        int newlen = len + shift*2;
        char[] result = new char[newlen];
        for (int i = len-1; i >= 0; i--) {
            if (chars[i] == ' ') {
                result[newlen-1] = '0';
                result[newlen-2] = '2';
                result[newlen-3] = '%';
                newlen -= 3;
            } else {
                result[newlen-1] = chars[i];
                newlen -= 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        _1_4_ReplaceSpace replaceSpace = new _1_4_ReplaceSpace();
        char[] chars = "Mr John Smith".toCharArray();
        int len = chars.length;
        char[] result = replaceSpace.replaceSpace0(chars, len);
        System.out.println(String.valueOf(result));
//        StringBuffer;
    }
}
