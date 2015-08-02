package org.buaa.nlp.cj;

/**
 * Created by Administrator on 2015/7/5.
 */
public class _5_LongestPalindromicSubstring_5 {
    public String longestPalindrome(String s) {
        // 中心扩展法：extend out from a center node
        int n = s.length();
        int oddlen = 0;
        int evenlen = 0;
        int curlen = 0;
        int max = 1;
        int startPos = 0;
        for (int i = 0; i < n; i ++) {
            oddlen = palindromic(s, i, i);
            evenlen = palindromic(s, i, i+1);
            curlen = oddlen > evenlen ? oddlen : evenlen;

            if (curlen > max) {
                max = curlen;
                if ((max & 1) == 1) {
                    startPos = i - max/2;
                }
                if ((max&1) == 0)
                    startPos = i - max/2 + 1;
            }
        }
        return s.substring(startPos, startPos + max);
    }

    public int palindromic(String s, int i, int j){
        int len = 0;
        int n = s.length();
        while (i >= 0 && j < n && (s.charAt(i) == s.charAt(j))) {
            i--;
            j++;
        }
        len = (j-1) - (i+1) + 1;
        return len;
    }

    public String longestPalindrome2(String s) {
        // 动�?�规�? dynamic programming
        int n = s.length();
        if (n < 2)
            return s;
        boolean[][] dp = new boolean[n][n];
        int startPos = 0, max = 1;
        // 处理基本情况
        for (int i = 0; i < n; i ++) {
            dp[i][i] = true;
            if (i < n-1) {
                if (s.charAt(i) == s.charAt(i+1)) {
                    dp[i][i+1] = true;
                    startPos = i;
                    max = 2;
                } else
                    dp[i][i+1] = false;
            }
        }
        //动�?�规划过�?
        for (int len = 3; len <= n; len ++) {
            for (int i = 0; i < n-len+1; ++i) {
                int j = i + len - 1;
                if (dp[i+1][j-1] == true && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    int curlen = j - i + 1;
                    if (curlen > max) {
                        max = curlen;
                        startPos = i;
                    }
                } else
                    dp[i][j] = false;
            }
        }
        return s.substring(startPos, startPos + max);
    }
    public String longestPalindrome3(String s) {
        // manacher方法
        return "";
    }

    public static void main(String[] args) {
        _5_LongestPalindromicSubstring_5 longestPalindromicSubstring_5 = new _5_LongestPalindromicSubstring_5();
        String substr = longestPalindromicSubstring_5.longestPalindrome2("acddabcdcbagfh");
        System.out.println(substr);
    }
}
