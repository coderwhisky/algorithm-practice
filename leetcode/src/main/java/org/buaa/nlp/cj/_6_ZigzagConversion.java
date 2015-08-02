package org.buaa.nlp.cj;

/**
 * Created by Administrator on 2015/7/5.
 */
public class _6_ZigzagConversion {
    String convert(String s, int numRows) {
        if (s.length() <= 2 || numRows <= 1)
            return s;

        int len = s.length();
//        String res = "";
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < len && i < numRows; ++i) {
            res.append(s.charAt(i));
            int indx = i;
            for (int k = 1; indx < len; ++k) {
                if (i == 0 || i == numRows - 1) {
                    indx = indx + 2*numRows - 2;
                } else {
                    // 中间�?
                    if ((k%2) == 0) {
                        indx = indx + 2*i;
                    } else {
                        indx = indx + 2*(numRows-1-i);
                    }
                }

                if (indx < len)
                    res.append(s.charAt(indx));
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        _6_ZigzagConversion zigzagConversion = new _6_ZigzagConversion();
        String s = zigzagConversion.convert("ABCDEF", 3);
        System.out.println(s);
    }
}
