package org.buaa.nlp.cj.Utils;

import java.util.Scanner;

/**
 * Created by whisky on 15-4-15.
 */

public class Main{

    public int cal(String str) {
        int result = 0;
        int length = 0;
        int powerNum = 0;
        for(int i=0; i<str.length();) {
            length = getLength(str, i);
            powerNum = getLengthPower(str, i);
            if (length == 1) {
                if (intValueOfChar(str.charAt(i)) > 0) {
                    result = result + intValueOfChar(str.charAt(i));
                    i++;
                } else {
                    char[] ch = String.valueOf(str.charAt(i)).toLowerCase().toCharArray();
                    result = result + 2*2*intValueOfChar(ch[0]);
                    i++;
                }
            } else {
                // 小写
                if (intValueOfChar(str.charAt(i)) > 0) {
                    result = result + (int)Math.pow((double)intValueOfChar(str.charAt(i)), (double)powerNum);
                    i = i + length;
                } else {
                    char[] ch = String.valueOf(str.charAt(i)).toLowerCase().toCharArray();
//                    result = result + 2*2*intValueOfChar(ch[0]);
                    result = result + (int)Math.pow((double)intValueOfChar(ch[0]), (double)powerNum);
                    i = i+length;
                }
            }
        }
        return result;
    }


    public int intValueOfChar(char c) {
        return Integer.valueOf(String.valueOf(c - 'a')) +1;
    }

    public int getLengthPower(String str, int start) {
        int length = 1;
        if(start > str.length())
            return 0;
        for(int i = start + 1; i < str.length() - 1; i++) {
            if (String.valueOf(str.charAt(i)).equalsIgnoreCase(String.valueOf(str.charAt(i-1)))) {
                if (intValueOfChar(str.charAt(i)) < 0)
                    length = length +2;
                else
                    ++length;
            } else {
                break;
            }
        }
        return length;
    }

    public int getLength(String str, int start) {
        int length = 1;
        if(start > str.length())
            return 0;
        for(int i = start + 1; i < str.length() - 1; i++) {
            if (String.valueOf(str.charAt(i)).equalsIgnoreCase(String.valueOf(str.charAt(i-1)))) {
                ++length;
            } else {
                break;
            }
        }
        return length;
    }

    public static void main(String args[]){
        Main mmain = new Main();
//        System.out.println("***");
//        System.out.println(mmain.getLength("abbBBbabb",1 ));
////        System.out.println(mmain.intValueOfChar('Z'));


        Scanner cin = new Scanner(System.in);
        int lines;
        String str;
        while(cin.hasNextInt()){
            lines = cin.nextInt();
            while(lines > 0) {
                str = cin.nextLine();
                int result = mmain.cal(str);
                System.out.println(result);
                lines--;
            }
        }
    }
}
