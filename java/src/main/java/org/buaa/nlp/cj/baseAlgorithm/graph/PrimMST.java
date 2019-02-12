package org.buaa.nlp.cj.baseAlgorithm.graph;

/**
 * Created by Administrator on 2015/10/2.
 */
public class PrimMST {
    private static int[][] graph;
    private static int vNum;
    public PrimMST(){}
    public PrimMST(int[][] edge, int v) {
        vNum = v;
        int nrow = edge.length;
        int ncolumn = edge[0].length;
        graph = new int[nrow][ncolumn];
        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < ncolumn; j++) {
                graph[i][j] = edge[i][j];
            }
        }
    }

    /**
     * prim 算法基本思想：
     * PrimMST（Minimum Spanning Tree，最小生成树）问题有两种通用的解法，Prim算法就是其中之一，它是从点的方面考虑构建一颗MST，
     * 大致思想是：设图G顶点集合为U，首先任意选择图G中的一点作为起始点a，将该点加入集合V，再从集合U-V中找到另一点b使得点b到V中任意一点的权值最小，
     * 此时将b点也加入集合V；以此类推，现在的集合V={a，b}，再从集合U-V中找到另一点c使得点c到V中任意一点的权值最小，此时将c点加入集合V，
     * 直至所有顶点全部被加入V，此时就构建出了一颗MST。因为有N个顶点，所以该MST就有N-1条边，每一次向集合V中加入一个点，就意味着找到一条MST的边。
     *
     * 设置2个数据结构：
     * lowcost[i]:表示以i为终点的边的最小权值,当lowcost[i]=0说明以i为终点的边的最小权值=0,也就是表示i点加入了MST
     * mst[i]:表示对应lowcost[i]的起点，即说明边<mst[i],i>是MST的一条边，当mst[i]=0表示起点i加入MST
     * @param g
     * @param n
     * @return
     */
    public static int prim(int[][] g, int n) {
        int[] lowCost = new int[n];
        int[] mst = new int[n];
        int sumCost = 0;
//        boolean[] visit = new boolean[n];

        // 值为 Integer.MIN_VALUE 表示已经访问过
        lowCost[0] = Integer.MIN_VALUE;
//        visit[0] = true;
        mst[0] = 0;
        for (int i = 1; i < n; i++) {
            lowCost[i] = g[0][i];
            mst[i] = 0;
        }

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int minId = 0;

            for (int j = 1; j < n; j++) {
                if (lowCost[j] < min && lowCost[j] != Integer.MIN_VALUE) {
                    min = lowCost[j];
                    minId = j;
                }
            }
            System.out.println(mst[minId] + "-" + minId + ": " + min);
            sumCost += min;
            lowCost[minId] = Integer.MIN_VALUE;
//            visit[minId] = true;

            for (int j = 1; j < n; j++) {
                if (g[minId][j] < lowCost[j] && lowCost[j] != Integer.MIN_VALUE) {
                    lowCost[j] = g[minId][j];
                    mst[j] = minId;
                }
            }
        }
        return sumCost;
    }

    public static void main(String[] args) {
        int m = Integer.MAX_VALUE;
        int[][] graph = {
                {m,6,1,5,m,m},
                {6,m,5,m,3,m},
                {1,5,m,5,6,4},
                {5,m,5,m,m,2},
                {m,3,6,m,m,6},
                {m,m,4,2,6,m}
        };
        prim(graph, 6);
    }
}
