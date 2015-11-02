package org.buaa.nlp.cj.jobOnlineProgram.Indeed.stage2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Administrator on 2015/10/31.
 */
public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String l1 = scanner.nextLine();
            String l2 = scanner.nextLine();
            int h = Integer.valueOf(l1.trim());
            int w = Integer.valueOf(l2.trim());
            char[][] square = new char[h][w];
            int lcount = 0;
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            while (lcount < h) {
                String ll = scanner.nextLine();
                char[] tmp = ll.toCharArray();
                for (int i = 0; i < w; i++) {
                    square[lcount][i] = tmp[i];
                    if (map.containsKey(tmp[i])) {
                        int tt = map.get(tmp[i]);
                        map.put(tmp[i], tt+1);
                    } else {
                        map.put(tmp[i], 1);                    }
                }
                lcount++;
            }

            int icount = 0, jcount = 0;
//            int i = 0, j = 0;
            char sp = square[0][0];

//            while (square[h-1][w-1] != '0') {
//                sp = square[i][j];
//                for (int i = 0; i < h; i ++)
//            }

            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                sp = entry.getKey();
                boolean printed = false;
                for (int i = 0; i < h; i++) {
                    for (int j = 0; j < w; j++) {
                        if (sp == square[i][j] && !printed) {
                            int ti = i+1;
                            int tj = j+1;
                            System.out.println(sp + " " + ti + " " + tj);
                            printed = true;
                        }
                    }
                }
            }

//            while (i < h) {
//                while (j < w) {
//                    if (sp == square[i][j] && square[i][j] != '0') {
//                        square[i][j] = '0';
//                        jcount++;
//                        j++;
//                    }
//                }
//                if (square[i][j] == sp) {
//                    i++;
//                    icount++;
//                    square[i][j] = '0';
//                }
//            }
        }
    }

}
