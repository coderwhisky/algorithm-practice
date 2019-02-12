package org.buaa.nlp.cj.jobOnlineProgram.baidu;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by whisky-yonk on 9/28/2015.
 */
public class Main2 {
    static char flag = 0x8000;

    public static int is_include(byte[] a, byte[] b) {

        return 0;
    }

    public static int is_include(char[] a, char[] b) {
        int na = a.length;
        int nb = b.length;
        Set<Character> set = new HashSet<Character>();
        for(int i = 0; i < na; i++) {
            set.add(a[i]);
        }
        for(int i = 0; i < nb; i++) {
            if(!set.contains(b[i]))
                return 0;
        }
        return 1;
    }

    /**
     * @param args
     * @throws UnsupportedEncodingException
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        byte[] b1 = s.getBytes("gbk");
        String s2 = scanner.nextLine();
        byte[] b2 = s2.getBytes("gbk");
        is_include(b1, b2);

        int r = is_include(s.toCharArray(), s2.toCharArray());
        System.out.println(r);
    }
}
