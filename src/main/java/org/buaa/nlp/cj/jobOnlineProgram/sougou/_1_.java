package org.buaa.nlp.cj.jobOnlineProgram.sougou;

import java.util.*;

import static java.lang.Integer.*;

/**
 * Created by whisky-yonk on 10/17/2015.
 */
public class _1_ {
    static class UserNode{
        int val;
        ArrayList<UserNode> answers;
        public UserNode(int uid) {
            answers = new ArrayList<UserNode>();
            val = uid;
        }
    }

    public static List<Integer> findSpam(int[][] qamap ) {
        Set<Integer> spams = new HashSet<Integer>();
        List<Integer> ser_spams = new ArrayList<Integer>();
        for (int i = 0; i < qamap.length; i++) {
            for (int j = 0; j < qamap.length; j++) {
                if (qamap[i][j] == 1 && i != j) {
                    if (!spams.contains(i)) {
                        ser_spams.add(i);
                    }
                    if (!spams.contains(j)) {
                        ser_spams.add(j);
                    }
                    for (int k = 0; k < qamap.length; k++) {
                        if (qamap[i][k] == 1 && qamap[j][k] ==1) {
//                            spams.add(k);
                            if (!spams.contains(k)) {
                                ser_spams.add(k);
                            }
                        }
                    }
                }
            }
        }
        return ser_spams;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String uline = scan.nextLine();
        int uNum = valueOf(uline.trim());
        int i = 0;
//        HashMap<UserNode> logs = new HashMap<UserNode>();
//        Map<UserNode,
        Set<UserNode> logs = new HashSet<UserNode>();

        int[][] qamap = new int[10000][10000];
        while (i < uNum) {
            String line = scan.nextLine();
            String[] strUid = line.trim().split(" ");
//            int[] u = new int[strUid.length];
//            UserNode q = new UserNode(Integer.valueOf(strUid[0]));
//            logs.add(q);
            int q = Integer.valueOf(strUid[0]);
            for (int k = 1; k < strUid.length; k++) {
//                u[i] = Integer.valueOf(strUid[i]);
                int a = Integer.valueOf(strUid[i]);
                qamap[a][q] = 1;
//                q.answers.add(new UserNode(a));
            }
            i++;
        }
        List<Integer> ser = findSpam(qamap);
        System.out.println(ser.size());
        for (int ii = 0; ii < ser.size(); ii++) {
            System.out.println(ser.get(ii));
        }
    }
}
