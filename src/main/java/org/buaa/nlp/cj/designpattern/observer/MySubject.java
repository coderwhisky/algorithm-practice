package org.buaa.nlp.cj.designpattern.observer;

/**
 * Created by Administrator on 2015/5/18.
 */
public class MySubject extends AbstractSubject {
    @Override
    public void operation() {
        System.out.println("update self!");
        notifyObservers();
    }
}
