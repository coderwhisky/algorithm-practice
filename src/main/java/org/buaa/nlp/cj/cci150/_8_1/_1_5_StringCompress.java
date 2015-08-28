package org.buaa.nlp.cj.cci150._8_1;

/**
 * Created by whisky-yonk on 8/27/2015.
 */
public class _1_5_StringCompress {
    /**
     * using StringBuffer
     * @param str
     * @return
     */
    public String compressStr(String str) {
        if (str == null || str.length() <= countCompression(str) || str.isEmpty())
            return str;

        StringBuffer newStr = new StringBuffer();
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            char last = str.charAt(i-1);
            char cur = str.charAt(i);
            if (cur == last) {
                count++;
                if (i != str.length()-1)
                    continue;
            } else {
                newStr.append(String.valueOf(last) + String.valueOf(count));
                count = 1;
            }
            if (i == str.length()-1) {
                newStr.append(String.valueOf(cur) + String.valueOf(count));
            }
        }
        return newStr.toString();
    }

    public int countCompression(String str) {
        if (str == null || str.isEmpty())
            return 0;
        int len = str.length();
        if (len < 2) {
            return len*2;
        }
        int count = 1;
        for (int i = 1; i < len; i++) {
            char cur = str.charAt(i);
            char last = str.charAt(i-1);
            if (cur == last) {
                continue;
            } else {
                count++;
            }
        }
        return count*2;
    }
    public static void main(String[] args) {
        _1_5_StringCompress stringCompress = new _1_5_StringCompress();
        int newlen = stringCompress.countCompression("a");
        System.out.println(newlen);
        String cstr = stringCompress.compressStr("aaabbbccc");
        System.out.println(cstr);
    }
}
