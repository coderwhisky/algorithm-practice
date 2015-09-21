package org.buaa.nlp.cj.jobOnlineProgram.qunar;

import java.io.IOException;
import java.util.*;

/**
 * Created by whisky-yonk on 9/21/2015.
 */
public class CommonNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lIdx = 1;
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();
        List<Integer> l3 = new ArrayList<Integer>();

        while (scanner.hasNext()) {
            int len = scanner.nextInt();
            while (len > 0) {
                int item = scanner.nextInt();
                if (lIdx == 1) {
                    l1.add(item);
                }
                if (lIdx == 2) {
                    l2.add(item);
                }
                if (lIdx == 3) {
                    l3.add(item);
                }
                len--;
            }
            lIdx++;
            if (len == 0 && lIdx == 4){
                break;
            }
        }
        try {
            System.in.close();
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Integer> res = commonNum(l1, l2, l3);
        boolean flag = true;
        for (Integer n : res) {
            if (flag) {
                System.out.println(n);
                flag = false;
            } else {
                System.out.println(" " + n);
            }
        }
    }

    public static List<Integer> commonNum(List<Integer> l1, List<Integer> l2, List<Integer> l3){
        List<Integer> res = new ArrayList<Integer>();

        Map<Integer, Integer> numCount = new HashMap<Integer, Integer>();
        for (int n1 : l1) {
            if (numCount.containsKey(n1)) {
                numCount.put(n1, numCount.get(n1) + 1);
            } else {
                numCount.put(n1, 1);
            }
        }

        for (int n2 : l2) {
            if (numCount.containsKey(n2)) {
                numCount.put(n2, numCount.get(n2) + 1);
            } else {
                numCount.put(n2, 1);
            }
        }

        for (int n3 : l3) {
            if (numCount.containsKey(n3)) {
                numCount.put(n3, numCount.get(n3) + 1);
            } else {
                numCount.put(n3, 1);
            }
        }

        for (Map.Entry<Integer, Integer> m : numCount.entrySet()) {
            if (m.getValue() == 3) {
                res.add(m.getKey());
            }
        }

        Collections.sort(res, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        return res;
    }
}
