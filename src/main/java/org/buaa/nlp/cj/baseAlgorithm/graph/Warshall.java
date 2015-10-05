package org.buaa.nlp.cj.baseAlgorithm.graph;

/**
 * 来源： http://www.cnblogs.com/kkgreen/archive/2011/07/01/2095158.html
 * warshall 图的传递闭包
 * Created by whisky-yonk on 10/5/2015.
 */
public class Warshall {
    public static int[][] warshall(int[][] g) {
        int[][] res = g;
        int nV = g.length;
        for (int k = 0; k < nV; k++) {
//            int[][] tmp = new int[nV][nV];
            for (int i = 0; i < nV; i++)
                for (int j = 0; j < nV; j++) {
                    if (res[i][j] == 1) {
//                        tmp[i][j] = 1;
                        res[i][j] = 1;
                    } else if (res[i][k] == 1 && res[k][j] == 1) {
//                        tmp[i][j] = 1;
                        res[i][j] = 1;
                    } else {
//                        tmp[i][j] = 0;
                        res[i][j] = 0;
                    }
                }
//            res = tmp;
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] g = {
                {0,1,0,0},
                {0,0,0,1},
                {0,0,0,0},
                {1,0,1,0}
        };
        int[][] res = warshall(g);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res.length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
