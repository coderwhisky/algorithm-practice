package org.buaa.nlp.cj.jobOnlineProgram.qunar;

import java.util.List;
import java.util.Scanner;

/**
 * Created by whisky-yonk on 9/21/2015.
 */
public class DeadLockDetect {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int threadNum = Integer.parseInt(scanner.nextLine());

        while (threadNum > 0) {
            threadNum--;
        }
    }

    public static int blockThread() {
        return 0;
    }

    class ThreadInfo{
        int Id;
        List<Integer> hold;
        int wait;

        public int getId() {
            return Id;
        }

        public void setId(int id) {
            Id = id;
        }

        public List<Integer> getHold() {
            return hold;
        }

        public void setHold(List<Integer> hold) {
            this.hold = hold;
        }

        public int getWait() {
            return wait;
        }

        public void setWait(int wait) {
            this.wait = wait;
        }
    }
}
