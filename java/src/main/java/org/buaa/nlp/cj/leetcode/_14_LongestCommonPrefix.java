package org.buaa.nlp.cj.leetcode;

/**
 * Created by Administrator on 2015/7/9.
 */
public class _14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        String comStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (comStr.isEmpty() || comStr == null)
                return "";
            if (strs[i].isEmpty() || strs[i] == null)
                return "";
            int comLen = comStr.length();
            int curLen = strs[i].length();
            int minLen = comLen < curLen ? comLen : curLen;
            int j = 0;
            while (j < minLen && strs[i].charAt(j) == comStr.charAt(j)) {
                j++;
            }
            comStr = comStr.substring(0, j);
        }
        return comStr;
    }

    public static void main(String[] args) {
        _14_LongestCommonPrefix longestCommonPrefix = new _14_LongestCommonPrefix();
        String[] strs = {"c", "c"};
        String comStr = longestCommonPrefix.longestCommonPrefix(strs);
        System.out.println(comStr);
    }
}
