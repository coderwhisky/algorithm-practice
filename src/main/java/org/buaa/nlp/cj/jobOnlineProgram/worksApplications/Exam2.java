package org.buaa.nlp.cj.jobOnlineProgram.worksApplications;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by whisky-yonk on 10/16/2015.
 */
public class Exam2 {

    public static int[] treeDFS(int[][] treeMap,int[] distance, int start, int n) {
        int cur = start;
        boolean[] visit = new boolean[n+1];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(cur);
        visit[cur] = true;
        distance[cur] = 0;
        while (!stack.isEmpty()) {
            cur = stack.peek();
            int i = 1;
            for (; i <= n; i++) {
                if (treeMap[cur][i] == 1 && !visit[i]) {
                    distance[i] = distance[cur] + 1;
                    visit[i] = true;
                    stack.push(i);
                    break;
                }
            }
            if (--i == n) {
                stack.pop();
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String lnm = scan.nextLine();
        int n = Integer.valueOf(lnm.trim().split(" ")[0]);
        int m = Integer.valueOf(lnm.trim().split(" ")[1]);
        int[][] cityMap = new int[n+1][n+1];

        int i = 0;
        while (i < n-1) {
            String line = scan.nextLine();
            int tc1 = Integer.valueOf(line.trim().split(" ")[0]);
            int tc2 = Integer.valueOf(line.trim().split(" ")[1]);
            cityMap[tc1][tc2] = 1;
            i++;
        }

        int[] distance = new int[n+1];
        distance = treeDFS(cityMap, distance, 1, n);
        int j = 0;
        while (j < m) {
            String line = scan.nextLine();
            int p = Integer.valueOf(line.trim().split(" ")[0]);
            int c = Integer.valueOf(line.trim().split(" ")[1]);

            if (p == 1) {
                distance = treeDFS(cityMap, distance, c, n);
            }
            if (p == 2) {
                System.out.println(distance[c]);
            }
            j++;
        }

    }
}
