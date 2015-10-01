package org.buaa.nlp.cj.baseAlgorithm.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Administrator on 2015/9/10.
 */
public class GraphByMatrix {
    private static int[][] edges;
    private static int n;
    private static int e;
    private static boolean[] visit;

    public GraphByMatrix(int[][] edge, int nNode, int nEdge) {
        visit = new boolean[nNode];
        edges = new int[nNode][nNode];
        for (int i = 0; i < nNode; i++) {
            for (int j = 0; j < nNode; j++) {
                edges[i][j] = edge[i][j];
            }
            visit[i] = false;
        }
        n = nNode;
        e = nEdge;
    }

    /**
     * 深度优先遍历，递归实现
     * @param v
     */
    public static void DFS(int v) {
        if (v < 0 || v >= n) {
            System.out.println("invalid node");
            return;
        }

        System.out.print(v + " ");
        visit[v] = true;
        for (int i = 0; i < n; i++) {
            if (edges[v][i] != 0 && !visit[i]) {
                DFS(i);
            }
        }
    }

    /**
     * 深度优先遍历，非递归实现。
     * @param v
     */
    public static void DFS2(int v) {
        Stack<Integer> stack = new Stack<>();
        System.out.print(v + " ");
        visit[v] = true;
        stack.push(v);

        while (!stack.isEmpty()) {
            int top = stack.peek();
            int i = -1;
            for (i = 0; i < n; i++) {
                if (edges[top][i] != 0 && !visit[i]) {
                    System.out.print(i + " ");
                    visit[i] = true;
                    stack.push(i);
                    break;
                }
            }
            if (i == n) {
                stack.pop();
            }
        }
    }

    /**
     * 广度优先遍历
     * @param v
     */
    public static void BFS(int v) {
        LinkedList<Integer> queue = new LinkedList<>();
        System.out.print(v + " ");
        queue.add(v);
        visit[v] = true;

        while (!queue.isEmpty()) {
            int front = queue.poll();
            int i = -1;
            for (i = 0; i < n; i++) {
                if (edges[front][i] != 0 && !visit[i]) {
                    System.out.print(i + " ");
                    visit[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] edges = {
                {0,1,1,0,0,0,0,0},
                {1,0,0,1,1,0,0,0},
                {1,0,0,0,0,1,1,0},
                {0,1,0,0,0,0,0,1},
                {0,1,0,0,0,0,0,1},
                {0,0,1,0,0,0,1,0},
                {0,0,1,0,0,1,0,0},
                {0,0,0,1,1,0,0,0}
        };
        GraphByMatrix graphByMatrix = new GraphByMatrix(edges, 8, 9);
//        DFS(0);
//        DFS2(0);
//        BFS(3);
    }

}
