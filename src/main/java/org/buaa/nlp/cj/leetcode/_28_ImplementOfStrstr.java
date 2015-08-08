package org.buaa.nlp.cj.leetcode;

/**
 * Created by Administrator on 2015/8/2.
 */
public class _28_ImplementOfStrstr {
    public int strStr(String haystack, String needle) {
        if (needle.length() < 1)
            return 0;
        if (haystack.length() < 1)
            return -1;

        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length())
                    return i;
                if (i + j == haystack.length())
                    return -1;
                // haystack中当前比较的字符所在位置为i+j
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        _28_ImplementOfStrstr implementOfStrstr = new _28_ImplementOfStrstr();
        int index = implementOfStrstr.strStr("mississippi", "issip");
        System.out.println(index);
    }
}
