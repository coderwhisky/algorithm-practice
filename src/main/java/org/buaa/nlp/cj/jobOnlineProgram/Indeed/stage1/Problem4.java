package org.buaa.nlp.cj.jobOnlineProgram.Indeed.stage1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 2015/10/25.
 */
public class Problem4 {
    static class Problem4Node {
        int left;
        int right;
        public String toString() {
            return left+":"+right;
        }
    }

    public static void insert(List<Problem4Node> list, Problem4Node n) {
        int i = 0;
        for(; i < list.size(); i++) {
            if(n.left > list.get(i).left)
                continue;
        }
        list.add(i, n);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        int n = Integer.parseInt(line);
        List<Problem4Node> list = new ArrayList<Problem4Node>();

        int i = 0;
        while (i < n) {
            line = scanner.nextLine();
            String[] ss = line.split(" ");
            int si = Integer.parseInt(ss[0]);
            int ci = Integer.parseInt(ss[1]);

            int esi = si + ci - 1;
            int count = 0;
            int idx = si;
            Problem4Node newnode = new Problem4Node();
            newnode.left = si;
            newnode.right = esi;
            while(true) {
                Problem4Node cur = null;
                for(int j = 0; j < list.size(); j++) {
                    Problem4Node Problem4Node = list.get(j);
                    if((newnode.left>=Problem4Node.left && newnode.left<=Problem4Node.right)
                            || (newnode.right>=Problem4Node.left&&newnode.right<=Problem4Node.right)
                            || (Problem4Node.left>=newnode.left && Problem4Node.right<=newnode.right)) {
                        cur = Problem4Node;
                        break;
                    }
                }
                if(cur == null) {
                    insert(list, newnode);
                    idx = newnode.right;
                    break;
                }
                else {
                    list.remove(cur);
                    int min_l = newnode.left < cur.left?newnode.left:cur.left;
                    int max_l = newnode.left > cur.left?newnode.left:cur.left;

                    int min_r = (newnode.right < cur.right)?newnode.right:cur.right;
                    int max_r = (newnode.right>cur.right)?newnode.right:cur.right;

                    int t1 = min_r - max_l + 1;

                    max_r += t1;
                    newnode.left = min_l;
                    newnode.right = max_r;
                }
            }
//			System.out.println(list);
            System.out.println(idx);
            i++;
        }
    }
}
