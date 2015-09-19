package org.buaa.nlp.cj.meituan;

import org.buaa.nlp.cj.designpattern.composite.Tree;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by whisky-yonk on 9/19/2015.
 */
public class _1_FriendsAndEnemy {
    public static void main(String[] args) {
        String[] arr = {
                "0 1 1",
                "1 2 0",
                "2 3 1",
                "3 4 0"
        };
        System.out.println(new _1_FriendsAndEnemy().countPerson(arr));
        System.out.println(new _1_FriendsAndEnemy().find(arr, 4));
    }

    public int find(String[] arr, int size) {
        int result = 0;
        int persons = countPerson(arr);
        int[][] stat = new int[persons][persons];
        for (int i = 0; i < size; i++) {
            int p1 = Integer.valueOf(arr[i].substring(0,1));
            int p2 = Integer.valueOf(arr[i].substring(2,3));
            int isFriend = Integer.valueOf(arr[i].substring(4));
            stat[p1][p1] = isFriend;
        }
        boolean[] visit = new boolean[persons];
        for (int i = 0; i < persons; i++)
            visit[i] = false;
        visit[0] = true;

        for (int i = 0; i < persons; i++) {
            for (int j = i; j < persons; j++)
            if (!visit[i] && stat[i][j] == 1) {
                visit[j] = true;
                continue;
            }else {
                result ++;
            }
        }
        return result;
    }

    public int countPerson(String[] arr) {
        Set<Integer> persons = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            int p1 = Integer.valueOf(arr[i].substring(0,1));
            int p2 = Integer.valueOf(arr[i].substring(2,3));
            persons.add(p1);
            persons.add(p2);
        }
        return persons.size();
    }
}
