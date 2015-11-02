package org.buaa.nlp.cj.jobOnlineProgram.Indeed.stage2;


import java.util.Scanner;

/**
 * Created by Administrator on 2015/10/31.
 */
public class Problem3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String l1 = scanner.nextLine();
            String l2 = scanner.nextLine();
            String l3 = scanner.nextLine();
            String l4 = scanner.nextLine();
            int h = Integer.valueOf(l1.trim());
            int w = Integer.valueOf(l2.trim());
            int[][] nums = new int[h][w];

            int x = Integer.valueOf(l3.trim());
            int k = Integer.valueOf(l4.trim());
            int cl = 0;
            while (cl < h) {
                String line = scanner.nextLine();
                String[] nstr = line.trim().split(" ");
                for (int i = 0; i < nstr.length; i++) {
                    nums[cl][i] = Integer.valueOf(nstr[i]);
                }
                cl++;
            }

            int ck = 0;
            while (ck < k) {
                int[] rsum = new int[h];
                int[] csum = new int[w];
                int r = 0;
                int c = 0;
                while (r < h) {
                    for (int j = 0; j < w; j++) {
                        rsum[r] += nums[r][j];
                    }
                    r++;
                }
                while (c < w) {
                    for (int i = 0; i < h; i++) {
                        csum[c] += nums[i][c];
                    }
                    c++;
                }
                // rorc = 0 if min comes from rsum[], or 1 if min comes from csum[]
                int rorc = 0;
                int min = rsum[0];
                int rtoreplaceidx = 0;
                for (int i = 0; i < rsum.length; i++) {
                    if (rsum[i] < min) {
                        min = rsum[i];
                        rorc = 0;
                        rtoreplaceidx = i;
                    }
                }
                int ctoreplaceidx = 0;
                for (int i = 0; i < csum.length; i++) {
                    if (csum[i] < min) {
                        min = csum[i];
                        rorc = 1;
                        ctoreplaceidx = i;
                    }
                }
                // replace the ith row with x
                if (rorc == 0) {
                    if (rsum[rtoreplaceidx] < x * w) {
                        for (int i = 0; i < w; i++) {
                            nums[rtoreplaceidx][i] = x;
                        }
                    }
//                    else {
//                        break;
//                    }
                }else {
                    if (csum[ctoreplaceidx] < x * h) {
                        for (int i = 0; i < h; i++) {
                            nums[i][ctoreplaceidx] = x;
                        }
                    }
//                    else {
//                        break;
//                    }
                }
                ck++;
            }

            int sum = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    sum += nums[i][j];
                }
            }
            System.out.println(sum);
        }
    }
}
