package org.buaa.nlp.cj.baseAlgorithm.graph;

import java.util.ArrayList;

/**
 * http://www.cnblogs.com/hapjin/p/4760934.html
 * Created by Administrator on 2015/9/10.
 */
public class GraphByAdjList {
    private final int V;
    private int E;
//    private ArrayList<Integer>[] adj;
    private ArrayList<ArrayList<Integer>> adj;
    public GraphByAdjList(int V) {
        this.V = V;
        this.E = 0;
//        adj = new ArrayList[V];
        adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < V; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(i);
            adj.add(tmp);
        }
    }

}
