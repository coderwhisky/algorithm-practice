package org.buaa.nlp.cj.jobOnlineProgram.worksApplications;

import java.util.Scanner;

/**
 * Created by whisky-yonk on 10/17/2015.
 */
public class GluttonousSnake {
    public static void main(String[] args) {
//        int[][] nums={{-1, 4, 5, 1},{2, -1, 2, 4},{3, 3, -1, 3},{4,2,1,-1}};
//        System.out.println(maxScore(nums));

        Scanner scan = new Scanner(System.in);
        String lnm = scan.nextLine();
        int n = Integer.valueOf(lnm.trim().split(" ")[0]);
        int m = Integer.valueOf(lnm.trim().split(" ")[1]);
        int[][] nums = new int[n][m];
        int i = 0;
        while (i < n) {
            String line = scan.nextLine();
            String[] tt = line.trim().split(" ");
            for (int j = 0; j < m; j++) {
                nums[i][j] = Integer.valueOf(tt[j]);
            }
            i++;
        }
        boolean[] canReachRight = new boolean[n];
        int maxScore = maxScore(nums, canReachRight);
        boolean flag = false;
        for (int k = 0; k < n; k++) {
            if (canReachRight[k]) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println(-1);
        } else {
            System.out.println(maxScore);
        }
    }

//    public static boolean canReachRight(int[][] nums, int i, int j) {
//        boolean[][] marked =
//    }

    public static int maxScore(int[][] nums, boolean[] canReachRight){
        if(nums==null || nums.length==0) return -1;
        int m=nums.length;
        int n=nums[0].length;
        int score=0;
//        boolean[] canReachRight = new boolean[m];
        for(int i=0; i<m; i++){
            boolean[][] marked=new boolean[m][n];
            if (nums[i][0] != -1) {
                int s=dfs(nums, i, 0, marked, canReachRight);
                if(s>score) score=s;
            }
        }
        return score;
    }

    private static int dfs(int[][] nums, int i, int j, boolean[][] marked, boolean[] canReachRight){
        marked[i][j]=true;
        int up=0;
        if(i-1>=0){
            if(nums[i-1][j]!=-1 && !marked[i-1][j]){
                up=dfs(nums, i-1, j, marked, canReachRight);
            }
        }else{
            if(nums[nums.length-1][j]!=-1 && !marked[nums.length-1][j]){
                return dfs(nums, nums.length-1, j, marked, canReachRight);
            }
        }
        int bottom=0;
        if (i+1 < nums.length && nums[i+1][j]!=-1 && !marked[i+1][j]) {
            bottom = dfs(nums, i+1, j, marked, canReachRight);
        }
//        if (i+1 < nums.length) {
//            if(nums[i+1][j]!=-1 && !marked[i+1][j]){
//                bottom=dfs(nums, i+1, j, marked);
//            }
//        } else {
//            if (nums[0][j] != -1 && !marked[0][j]) {
//                return dfs(nums, 0, j, marked);
//            }
//        }
        int right=0;
        if(j+1<nums[0].length && nums[i][j+1]!=-1 && !marked[i][j+1]){
            right=dfs(nums, i, j+1, marked, canReachRight);
        }
        if (j == nums[0].length - 1 && nums[i][j] != -1) {
            canReachRight[i] = true;
        }
        return Math.max(up, Math.max(right, bottom))+nums[i][j];
    }
}
