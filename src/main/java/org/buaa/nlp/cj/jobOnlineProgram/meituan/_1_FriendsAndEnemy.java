package org.buaa.nlp.cj.jobOnlineProgram.meituan;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by whisky-yonk on 9/19/2015.
 */
public class _1_FriendsAndEnemy {

    public static void main(String[] args) {
//        String[] str = {
//                "0 1 1",
//                "1 2 0",
//                "2 3 1",
//                "3 4 0"
//        };
//        int size = 4;
        String[] str = {
                "0 1 1",
                "1 2 0",
                "2 3 0",
        };
        int size = 3;
        System.out.println(find(str, size));
    }

    public static int find(String[] str, int size) {
        int peopleNum = 0;
        int[][] enemy;
        int[] father;

        // count people num
        for (int i = 0; i < size; i ++) {
            String[] tmp = str[i].split(" ");
            if (Integer.parseInt(tmp[0]) > peopleNum) {
                peopleNum = Integer.parseInt(tmp[0]);
            }
            if (Integer.parseInt(tmp[1]) > peopleNum) {
                peopleNum = Integer.parseInt(tmp[1]);
            }
        }
        peopleNum += 1;
        father = new int[peopleNum];
        for (int i = 0; i < peopleNum; i ++) {
            father[i] = i;
        }

        // enemy record
        enemy = new int[peopleNum][peopleNum];

        //
        for (int i = 0; i < size; i ++) {
            String[] tmp = str[i].split(" ");
            int first = Integer.parseInt(tmp[0]);
            int second = Integer.parseInt(tmp[1]);
            int third = Integer.parseInt(tmp[2]);
            if (third == 1) {
                friendMerge(father, first, second);
            }
            if (third == 0) {
                for (int j = 1; j <= enemy[first][0]; j ++) {
                    friendMerge(father, second, enemy[first][j]);
                }
                for (int j = 1; j <= enemy[second][0]; j ++) {
                    friendMerge(father, first, enemy[second][j]);
                }
                enemy[first][0] ++;
                enemy[first][enemy[first][0]] = second;

                enemy[second][0] ++;
                enemy[second][enemy[second][0]] = first;
            }
        }

        int groupCount = 0;
        for (int i = 0; i < peopleNum; i ++) {
            if (father[i] == i) {
                groupCount ++;
            }
        }

        return groupCount;
    }

    public static void friendMerge(int father[], int x, int y) {
        x = findFather(father, x);
        y = findFather(father, y);
        if (x < y) {
            father[y] = x;
        } else {
            father[x] = y;
        }
    }

    public static int findFather(int father[], int x) {
        if (father[x] != x) {
            father[x] = findFather(father, father[x]);
        }
        return father[x];
    }

}
