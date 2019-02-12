package org.buaa.nlp.cj.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by whisky on 2015/5/25.
 */
public class _3_LongestSubStrNoRepeat {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int maxLen = 0;
        Map<Character, Integer> isExits = new HashMap<Character, Integer>();
        int i = 0;
        int start = 0;
        while (i < arr.length) {
            if (isExits.containsKey(arr[i]) && (isExits.get(arr[i]) >= start)) {
                start = isExits.get(arr[i]) + 1;
            }
            maxLen = (i - start + 1) > maxLen ? (i - start + 1) : maxLen;
            isExits.put(arr[i], i);
            i++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        _3_LongestSubStrNoRepeat longestSubStrNoRepeat = new _3_LongestSubStrNoRepeat();
//        int maxlen = longestSubStrNoRepeat.lengthOfLongestSubstring("a");
        int maxlen = longestSubStrNoRepeat.lengthOfLongestSubstring("alsdkjlk");
        System.out.print(maxlen);
    }
}
