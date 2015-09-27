package org.buaa.nlp.cj.jobOnlineProgram;

/**
 * Created by whisky-yonk on 9/21/2015.
 */
public class EditDistance {
    public static void main(String[] args) {
        String str1 = "ofailing";
        String str2 = "osailn";
        int res = minEditDis(str1, str2);
        System.out.println(res);
    }

    public static int minEditDis(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
//        int len = len1 > len2 ? len2 : len1;
        int[][] eDis = new int[len1][len2];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (i == 0 && j == 0) {
                    eDis[i][j] = 0;
                } else if (i == 0 && j > 0) {
                    eDis[i][j] = j;
                } else if (j == 0 && i > 0) {
                    eDis[i][j] = i;
                } else {
                    int tt = str1.charAt(i) == str2.charAt(j) ? 0 : 1;
                    int lastMin = eDis[i-1][j-1] < eDis[i][j-1] ? eDis[i-1][j-1] : eDis[i][j-1];
                    lastMin = lastMin < eDis[i-1][j] ? lastMin : eDis[i-1][j];
                    eDis[i][j] = lastMin + tt;
                }
            }
        }
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                System.out.print(eDis[i][j] + " ");
            }
            System.out.println();
        }
        return eDis[len1-1][len2-1];
    }
}
