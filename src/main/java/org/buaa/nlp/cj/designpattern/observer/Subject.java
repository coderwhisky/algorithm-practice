package org.buaa.nlp.cj.designpattern.observer;

/**
 * Created by Administrator on 2015/5/18.
 */
public interface Subject {
    /*���ӹ۲���*/
    public void add(Observer observer);

    /*ɾ���۲���*/
    public void del(Observer observer);

    /*֪ͨ���еĹ۲���*/
    public void notifyObservers();

    /*����Ĳ���*/
    public void operation();
}
