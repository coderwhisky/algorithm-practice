package org.buaa.nlp.cj.designpattern.observer;

/**
 * Created by Administrator on 2015/5/18.
 */
public class ObserverTest {
    public static void main(String[] args) {
        Subject sub = new MySubject();
        sub.add(new Observer1());
        sub.add(new Observer2());

        sub.operation();
    }
}
