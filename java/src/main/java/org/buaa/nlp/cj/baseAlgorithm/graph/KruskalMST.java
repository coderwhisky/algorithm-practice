package org.buaa.nlp.cj.baseAlgorithm.graph;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * kruskal算法的精髓在于：
 * 每次选取一条边。
 * 该边同时满足：1、在当前未选边中权值最小；2、与已选边不构成回路。
 * 直到选取n-1条表是算法结束。找到MST活判断不存在MST。

 * 代码设计：
 * 1、利用优先级队列将权值小的边放到队列最前，优先出对，保证了每次选择的都是权值最小的边。
 * 2、利用并查集的查找及结合把同处同一连通分量中的顶点连到同一父节点下。这样，每次判断是
 * 否构成回路，只要判断父节点是否相同的即可。
 * Created by Administrator on 2015/10/2.
 */
public class KruskalMST {
    private static int[] father;
    private static int nVetex;
    private static int nEdge;
    private static Edge[] graph;

    public KruskalMST(Edge[] g, int nV, int nE) {
        father = new int[nV];
        nVetex = nV;
        nEdge = nE;
//        graph = new Edge[nE];
        graph = g;
    }

//    public void storeMap(Edge[] g) {
//
//    }

    public int kruskal() {
        Edge[] mst = new Edge[nVetex - 1];
        int sumCost = 0;
        for (int i = 0; i < nVetex; i++) {
            father[i] = i;
        }

        int nMstEdge = 0;
//        Arrays.sort(graph);
        for (int i = 0; i < graph.length; i++) {
            Edge e = graph[i];
            int f = e.from;
            int t = e.to;
            int c = e.cost;
            int fx = find(f);
            int fy = find(t);

            if (fx != fy) {
                father[fy] = fx;

                Edge addedEdge = new Edge(f, t, c);
                mst[nMstEdge] = addedEdge;
//                mst[nMstEdge].from = f;
//                mst[nMstEdge].to = t;
//                mst[nMstEdge].cost = c;

                sumCost += c;
                nMstEdge++;
            }
        }

        for (int i = 0; i < mst.length; i++) {
            mst[i].print();
        }
        return sumCost;
    }

    public static int find(int x) {
        if (x == father[x])
            return father[x];
        return father[x] = find(father[x]);
    }

    static class Edge {
        int from;
        int to;
        int cost;

        public Edge(int f, int t, int c){
            from = f;
            to = t;
            cost = c;
        }

        public int compare(Edge e1, Edge e2) {
            if (e1.cost > e2.cost)
                return 1;
            else if (e1.cost < e2.cost)
                return -1;
            else
                return 0;
        }

        public void print() {
            System.out.println(from + "->" + to + ":" + cost);
        }
    }

    public static void main(String[] args) {
        Edge[] graph = new Edge[10];
        graph[0] = new Edge(0,2,1);
        graph[1] = new Edge(3,5,2);
        graph[2] = new Edge(1,4,3);
        graph[3] = new Edge(2,5,4);
        graph[4] = new Edge(0,3,5);
        graph[5] = new Edge(1,2,5);
        graph[6] = new Edge(2,3,5);
        graph[7] = new Edge(0,1,6);
        graph[8] = new Edge(2,4,6);
        graph[9] = new Edge(4,5,6);

        KruskalMST g = new KruskalMST(graph, 6, 10);
        int sumCost = g.kruskal();

    }
}
