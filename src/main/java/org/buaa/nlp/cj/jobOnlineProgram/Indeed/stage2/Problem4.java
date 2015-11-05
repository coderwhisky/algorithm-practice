package org.buaa.nlp.cj.jobOnlineProgram.Indeed.stage2;

import java.util.Scanner;

/**
 * Created by Administrator on 2015/10/31.
 */
public class Problem4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            char[] s = line.toCharArray();

            StringBuffer sb = new StringBuffer();
            int crepeat = 1;
            int i = 0;
            char repeatChar = '0';

            int nTimes = 1;
            char candidate = s[0];
            for (i = 1; i < s.length; i++)
            {
                if (nTimes == 0)
                {
                    candidate = s[i];
                    nTimes = 1;
                }
                else
                {
                    if (candidate == s[i])
                        nTimes++;
                    else
                        nTimes--;
                }
            }

            if (nTimes > s.length/2) {
                System.out.println(-1);
            } else {
                i = 0;
                while (i < s.length) {
//            for (int i = 0; i < s.length; i++) {
                    char min = s[i];
                    int midx = i;
                    int j = i;
                    for (; j < s.length; j++) {
                        if (s[j] < min && s[j] != repeatChar) {
                            min = s[j];
                            midx = j;
                        }
                    }
                    // repeat
                    if (min == s[i] && midx != i) {
                        repeatChar = min;
                    } else {
                        char tmp = s[i];
                        s[i] = s[midx];
                        s[midx] = tmp;
                        sb.append(s[i]);
                        i++;
                        repeatChar = '0';
                    }
                }
                System.out.println(sb.toString());
            }

        }
    }
}
