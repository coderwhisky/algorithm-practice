package org.buaa.nlp.cj.leetcode;

/**
 * Created by Administrator on 2015/7/8.
 */
public class _10_RegularExpMatch {
    public boolean isMatch(String s, String p) {
        if (s == null)
            return p == null;
        if (p == null)
            return s == null;
        int slen = s.length();
        int plen = p.length();
        if (plen == 0)
            return slen == 0;
        if (plen == 1) {
            if (p.equals(s) || p.equals("*") || (p.equals(".") && slen == 1))
                return true;
            else
                return false;
        }
        if (p.charAt(1) != '*') {
            if (slen > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'))
                return isMatch(s.substring(1), p.substring(1));
            return false;
        }else {
            while (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
                if (isMatch(s, p.substring(2)))
                    return true;
                s = s.substring(1);
            }
            return isMatch(s, p.substring(2));
        }
    }

    public static void main(String[] args) {
        _10_RegularExpMatch regularExpMatch = new _10_RegularExpMatch();
        boolean flag = regularExpMatch.isMatch(null, null);
        System.out.println(flag);
    }
}
