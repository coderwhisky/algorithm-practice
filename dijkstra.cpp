/* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.
* File Name : dijkstra.cpp
* Purpose :
* Creation Date : 2019-05-09 21:33:15
* Last Modified : 2019-05-09 21:42:33
* Created By : chenjiang
* Modified By : chenjiang
_._._._._._._._._._._._._._._._._._._._._.*/


void dijkstra(int vs, int prev[], int dist[], int node_num) {
    int flag[node_num];
    for (int i = 0; i < node_num; i++) {
        flag[i] = 0;
        prev[i] = 0;
        dist[i] = matrix[vs][i];
    }
    for (int i = 1; i < node_num; i++) {
        int min = INF;
        int k;
        for (int j = 0; j < node_num; j++) {
            if (flag[j] == 0 && dist[j] < min) {
                min = dist[j];
                k = j;
            }
        }
        for (int j = 0; j < node_num; j++) {
            if (flag[j] == 0 && min + matrix[k][j] < dist[j]) {
                dist[j] = min + matrix[k][j];
                prev[j] = k;
            }
        }
    }
}
