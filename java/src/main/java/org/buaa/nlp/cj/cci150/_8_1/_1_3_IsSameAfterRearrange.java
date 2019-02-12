package org.buaa.nlp.cj.cci150._8_1;

/**
 * Created by whisky-yonk on 8/27/2015.
 */
public class _1_3_IsSameAfterRearrange {
    public boolean isShitSame(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        int len = str1.length();
        int[] checks = new int[256];
        for (int i = 0; i < len; i++) {
            int val1 = str1.charAt(i);
            int val2 = str2.charAt(i);
            checks[val1] += 1;
            checks[val2] -= 1;
        }
        for (int i = 0; i < 256; i++) {
            if (checks[i] != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        _1_3_IsSameAfterRearrange isSameAfterRearrange = new _1_3_IsSameAfterRearrange();
        boolean result = isSameAfterRearrange.isShitSame("reul", "rieu");
        System.out.println(result);
    }
}
