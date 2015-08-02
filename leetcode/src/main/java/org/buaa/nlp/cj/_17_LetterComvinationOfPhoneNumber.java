package org.buaa.nlp.cj;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/7/27.
 */
public class _17_LetterComvinationOfPhoneNumber {

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty())
            return null;
        List<String> result = new ArrayList<String>();
        String[] map = new String[10];
        map[0] = "";
        map[1] = "";
        map[2] = "abc";
        map[3] = "def";
        map[4] = "ghi";
        map[5] = "jkl";
        map[6] = "mno";
        map[7] = "pqrs";
        map[8] = "tuv";
        map[9] = "wxyz";
//        if (digits.length() == 1) {
//            for (int i = 0; i < map[digits.charAt(0) - '0'].length(); i++) {
//                result.add(String.valueOf(map[digits.charAt(0) - '0'].charAt(i)));
//            }
//            return result;
//        }

        char[] middleTemp = new char[digits.length()];
        dfsGetStr(digits, 0, middleTemp, map, result);

        return result;
    }

    private void dfsGetStr(String digits, int index, char[] middleStr, String[] map, List<String> result) {
        if (index == digits.length()) {
            result.add(new String(middleStr));
            return;
        }

        char strChar = digits.charAt(index);
        for (int i = 0; i < map[strChar - '0'].length(); i ++) {
            middleStr[index] = map[strChar - '0'].charAt(i);
            dfsGetStr(digits, index+1, middleStr, map, result);
        }

    }

    public static void main(String[] args) {
        _17_LetterComvinationOfPhoneNumber letterComvinationOfPhoneNumber = new _17_LetterComvinationOfPhoneNumber();
        List<String> result = letterComvinationOfPhoneNumber.letterCombinations("4");
        System.out.println(result.toString());
    }
}
