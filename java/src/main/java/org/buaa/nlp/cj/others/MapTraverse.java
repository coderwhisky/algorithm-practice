package org.buaa.nlp.cj.others;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * map遍历
 * Created by whisky on 2015/5/22.
 */
public class MapTraverse {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);

        //  第一种方法：通过Map.keySet遍历key和value
        System.out.println("第一种方法：通过Map.keySet遍历key和value");
        for (Integer key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }

        // 第二种：通过Map.entrySet使用iterator遍历key和value
        System.out.println("第二种：通过Map.entrySet使用iterator遍历key和value");
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        // 第三种：通过Map.entrySet遍历key和value
        System.out.println("第三种：通过Map.entrySet遍历key和value");
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
