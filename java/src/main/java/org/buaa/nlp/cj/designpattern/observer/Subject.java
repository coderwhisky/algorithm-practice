package org.buaa.nlp.cj.designpattern.observer;

/**
 * Created by Administrator on 2015/5/18.
 */
public interface Subject {
    /*增加观察者*/
    public void add(Observer observer);

    /*删除观察者*/
    public void del(Observer observer);

    /*通知所有的观察者*/
    public void notifyObservers();

    /*自身的操作*/
    public void operation();
}
