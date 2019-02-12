package org.buaa.nlp.cj.designpattern.observer;

/**
 * Created by Administrator on 2015/5/18.
 */
public class Observer2 implements Observer {
    @Override
    public void update() {
        System.out.println("observer2 has received!");
    }
}
