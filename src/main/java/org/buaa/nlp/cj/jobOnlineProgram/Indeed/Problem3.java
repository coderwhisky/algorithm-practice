package org.buaa.nlp.cj.jobOnlineProgram.Indeed;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2015/10/25.
 */
public class Problem3 {
    public static boolean assignStatus(int[] room, int[] party) {
        if (party.length > room.length) {
            return false;
        }
        boolean[] roomStatus = new boolean[room.length];
        Arrays.sort(room);
        Arrays.sort(party);
        int j = room.length-1;
        for (int i = party.length-1; i >= 0; i--) {
            boolean flag = false;
            while (j >= 0) {
                if (room[j] >= party[i] && !roomStatus[j]) {
                    break;
                } else {
                    j--;
                }
            }
            if (j < 0) {
                return false;
            } else {
                roomStatus[j] = true;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line1 = scanner.nextLine();
            String line2 = scanner.nextLine();
            String line3 = scanner.nextLine();
            int N = Integer.valueOf(line1.trim().split(" ")[0]);
            int M = Integer.valueOf(line1.trim().split(" ")[1]);
            int[] rooms = new int[N];
            int[] parties = new int[M];
            String[] rooItem = line2.trim().split(" ");
            String[] partyItem = line3.trim().split(" ");
            for (int i = 0; i < rooItem.length; i++) {
                rooms[i] = Integer.valueOf(rooItem[i].trim());
            }
            for (int i = 0; i < partyItem.length; i++) {
                parties[i] = Integer.valueOf(partyItem[i].trim());
            }

            if (assignStatus(rooms, parties)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

/**
 * C - 旅館/Hotel
 Time limit : 2sec / Stack limit : 256MB / Memory limit : 256MB

 Problem Statement
 Mr. Takahashi runs a N-room hotel. M parties have reservations today, but unfortunately he forgot to make sure that it is possible to assign rooms to all the reservations.

 Each reservation needs to be assigned a room with the capacity of at least the size of the party. Exactly one room should be assigned to each reservation: it is not allowed to assign more than one room to one reservation, or assign one room to more than one reservation.

 Determine whether it is possible to assign rooms to all reservations following the restrictions.

 Input
 Input is given from Standard Input in the following format:

 N M
 A1 A2 ... AN
 B1 B2 ... BM
 The first line contains two integer N(1≦N≦105) and M(1≦M≦105).
 The second line contains N space-separated integers A1, A2, …, AN. For each i(1≦i≦N), Ai(1≦Ai≦105) represents the capacity of the ith room.
 The third line contains M space-separated integers B1, B2, …, BM. For each i(1≦i≦M), Bi(1≦Bi≦105) represents the size of the party making the ith reservation.
 Output
 Print YES in a single line if it is possible to assign rooms to all reservations following the restrictions. Print NO otherwise. Be sure to print a newline at the end of output.

 Partial Points
 Partial points may be awarded in this problem:

 60 points will be awarded for passing the test set satisfying N≦100, M≦100.
 Another 40 points will be awarded for passing the test set without additional constraints.
 入力例1
 3 2
 2 2 3
 3 1
 出力例1
 YES
 入力例2
 3 2
 2 2 3
 3 3
 出力例2
 NO
 入力例3
 3 4
 10 10 10
 1 1 1 1
 出力例3
 NO
 入力例4
 10 10
 10 9 8 7 6 5 4 3 2 1
 10 9 8 7 6 5 4 3 2 1
 出力例4
 YES
 */
