package org.buaa.nlp.cj.jobOnlineProgram.JD;

/**
 * Created by whisky-yonk on 9/19/2015.
 */
public class BestGift {
    public static void main(String[] args) {
        BestGift bestGift = new BestGift();
        int[][] values = {
                {1,2,3},
                {3,4,5},
                {2,3,5}
        };
        int result = bestGift.maxValueOfGifts(values, 3);
        System.out.println(result);
    }
    public int maxValueOfGifts(int[][] values, int n) {
        int[][] sum = new int[n][n];
        sum = values;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                else if (i == 0) {
                    sum[i][j] += sum[i][j-1];
                } else if (j == 0) {
                    sum[i][j] += sum[i-1][j];
                }else {
                    int up = sum[i-1][j];
                    int left = sum[i][j-1];
                    sum[i][j] += up > left ? up : left;
                }
            }
        }
        return sum[n-1][n-1];
    }
}
