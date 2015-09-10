package org.buaa.nlp.cj.baseAlgorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2015/9/10.
 */
public class GraphByMatrix {
    int size;
    boolean g[][] = new boolean[100][100];
    boolean vis[] = new boolean[100];
    int indegree[] = new int[100];
    int outdegree[] = new int[100];
    Queue<Integer> q = new LinkedList<Integer>();
    Vetex<Integer> vv[] = new Vetex[1000];

    public GraphByMatrix(int s, int v[], boolean g[][]) {
        this.size = s;
        for (int i = 0; i < size; i++) {
            vv[i] = new Vetex<Integer>(v[i]);
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.g[i][j] = g[i][j];
            }
        }
    }

    /**
     * return the first adjacent vertex to 'v'
     * @param v
     * @return
     */
    public int firstAdjVex(int v) {
        for (int j = 0; j < size; j++) {
            if (g[v][j])
                return j;
        }
        return -1;
    }

    /**
     * return the first adjacent vertex to 'v' next to v's adjacent vertex u
     * @param v
     * @param u
     * @return
     */
    public int nextAdjVex(int v, int u) {
        if (g[v][u]) {
            for (int j = u+1; j < size; j++) {
                if (g[v][j])
                    return j;
            }
        }
        return -1;
    }

    public void indegreeCount() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.indegree[i] += g[j][i] ? 1 : 0;
            }
        }
    }

    public void outdegreeCount() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.outdegree[i] += g[i][j] ? 1 : 0;
            }
        }
    }

    public void bfs() {
        for (int i = 0; i < size; i++) {

        }
    }

    private class Vetex<T> {
        T data;
        public Vetex(T d) {
            this.data = d;
        }
    }
}
