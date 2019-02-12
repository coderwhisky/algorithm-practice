package org.buaa.nlp.cj.baseAlgorithm.graph;

/**
 * Created by whisky-yonk on 10/5/2015.
 */
public class Floyd {
    public static int[][] floyd(int[][] gWeight) {
        int nV = gWeight.length;
        int[][] ser = gWeight;
        int[][] path = new int[nV][nV];
        for (int i = 0; i < nV; i++)
            for (int j = 0; j < nV; j++) {
                if (gWeight[i][j] != Integer.MAX_VALUE)
                    path[i][j] = i;
                else {
                    path[i][j] = Integer.MAX_VALUE;
                }
            }

        for (int k = 0; k < nV; k++) {
            for (int i = 0; i < nV; i++) {
                for (int j = 0; j < nV; j++) {
                    if (ser[i][k] != Integer.MAX_VALUE && ser[k][j] != Integer.MAX_VALUE) {
                        if (ser[i][k] + ser[k][j] < ser[i][j]) {
                            ser[i][j] = Math.min(ser[i][j], ser[i][k] + ser[k][j]);
                            path[i][j] = path[k][j];
                        }
                    }
                }
            }
        }
        System.out.println("path matrix:");
        for (int i = 0; i < nV; i++) {
            for (int j = 0; j < nV; j++)
                System.out.print(path[i][j] + " ");
            System.out.println();
        }
        System.out.println("////////////////////");
        return ser;
    }

    public static void main(String[] args) {
        int m = Integer.MAX_VALUE;
        int[][] g = {
                {0, m, 3, m},
                {2, 0, m, m},
                {m, 7, 0, 1},
                {6, m, m, 0}
        };

        int[][] res = floyd(g);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res.length; j++)
                System.out.print(res[i][j] + " ");
            System.out.println();
        }
    }
}
