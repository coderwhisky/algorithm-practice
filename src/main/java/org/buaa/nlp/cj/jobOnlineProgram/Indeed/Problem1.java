package org.buaa.nlp.cj.jobOnlineProgram.Indeed;

import java.util.Scanner;

/**
 * Created by Administrator on 2015/10/25.
 */
public class Problem1 {
    public static String toDoubleStr(String in) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < in.length(); i++) {
            sb.append(in.charAt(i));
            sb.append(in.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(toDoubleStr(line));
        }
    }
}
