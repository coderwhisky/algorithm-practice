package org.buaa.nlp.cj.cci150._8_1;

/**
 * Created by whisky-yonk on 8/28/2015.
 */
public class _1_8_RotatedString {
    public boolean isRotation(String s1, String s2) {
        if (s1 == null || s2 == null)
            return s1 == s2;

        if (s1.length() == s2.length() && s1.length() > 0) {
            String s1s1 = s1+s1;
            return s1s1.contains(s2);
        }
        return false;
    }

    public static void main(String[] args) {
        _1_8_RotatedString rotatedString = new _1_8_RotatedString();
        boolean result = rotatedString.isRotation("waterbottle", "erbottlewat");
        System.out.println(result);
    }
}
