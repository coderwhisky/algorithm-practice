package org.buaa.nlp.cj.designpattern.Iterator;

/**
 * Created by Administrator on 2015/5/18.
 */
public class IteratorTest {
    public static void main(String[] args) {
        Collection collection = new MyCollection();
        Iterator it = collection.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
