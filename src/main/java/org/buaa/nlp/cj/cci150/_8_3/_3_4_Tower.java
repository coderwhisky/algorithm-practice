package org.buaa.nlp.cj.cci150._8_3;

import java.util.Stack;

/**
 * Created by Administrator on 2015/9/8.
 */
public class _3_4_Tower {
    private Stack<Integer> disks;
    private int index;

    public _3_4_Tower() {}

    public _3_4_Tower(int i) {
        disks = new Stack<Integer>();
        index = i;
    }

    public int getIndex() {
        return index;
    }

    public void add(int d) {
        if (! disks.isEmpty() && disks.peek() <= d) {
            System.out.println("Error placing disk " + d);
        } else {
            disks.push(d);
        }
    }

    public void moveTopTo(_3_4_Tower t) {
        int top = disks.pop();
        t.add(top);
        System.out.println("Move disk " + top + " from tower " + getIndex() + " to tower " + t.getIndex());
    }

    public void moveDisks(int n, _3_4_Tower destination, _3_4_Tower buffer) {
        if (n > 0) {
            moveDisks(n-1, buffer, destination);
            moveTopTo(destination);
            moveDisks(n - 1, destination, this);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        _3_4_Tower[] towers = new _3_4_Tower[n];
        for (int i = 0; i < 3; i++) {
            towers[i] = new _3_4_Tower(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            towers[0].add(i);
        }

        towers[0].moveDisks(n, towers[2], towers[1]);
        System.out.println("****************");
    }
}
