package org.buaa.nlp.cj.baseAlgorithm.graph;

import org.buaa.nlp.cj.designpattern.Facade.Disk;

import java.util.Stack;

/**
 * Created by Administrator on 2015/10/3.
 */
public class Dijkstra {
    private static int[] path;

    public static int dijkstra(int[][] g, int nV, int nE, int start){
        int[] dist = new int[nV];
        boolean[] visit = new boolean[nV];
        int sumDist = 0;
        path = new int[nV];
        // 初始化
        for (int i = 0; i < nV; i++) {
            if (g[start][i] != Integer.MAX_VALUE) {
                dist[i] = g[start][i];
                path[i] = start;
            } else {
                dist[i] = Integer.MAX_VALUE;
                path[i] = -1;
            }
        }
        visit[start] = true;
        path[start] = start;
        dist[start] = 0;
        for (int i = 1; i < nV; i++) {
            int dMin = Integer.MAX_VALUE;
            int vMin = i;
            //寻找距离已选节点路劲最短的节点
            for (int j = 0; j < nV; j++) {
                if (dist[j] < dMin && !visit[j]) {
                    dMin = dist[j];
                    vMin = j;
                }
            }
            visit[vMin] = true;
            sumDist += dMin;
            for (int j = 0; j < nV; j++) {
                if (g[vMin][j] != Integer.MAX_VALUE) {
                    if (dist[j] == Integer.MAX_VALUE) {
                        if (g[vMin][j] < dist[j]) {
                            dist[j] = g[vMin][j];
                            path[j] = vMin;
                        }
                    }else {
                        if (dMin + g[vMin][j] < dist[j]) {
                            dist[j] = dMin + g[vMin][j];
                            path[j] = vMin;
                        }
                    }
                }
            }
        }
        System.out.println("the shortest distance: " + sumDist);
        return sumDist;
    }

    public static void printPath(int[] path, int v, int start) {
        Stack<Integer> stack = new Stack<Integer>();
        while (v != start) {
            stack.push(v);
            v = path[v];
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + "->");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int m = Integer.MAX_VALUE;
        int[][] graph = {
                {m,100,30,m,10},
                {m,m,m,m,m},
                {m,60,m,60,m},
                {m,10,m,m,m},
                {m,m,m,50,m}
        };
        int nV = 5;
        int nE = 7;
//        Dijkstra dijkstra = new Dijkstra();
        dijkstra(graph, nV, nE, 0);
        for (int i = 1; i < nV; i++) {
            printPath(Dijkstra.path, i, 0);
        }
    }
}
