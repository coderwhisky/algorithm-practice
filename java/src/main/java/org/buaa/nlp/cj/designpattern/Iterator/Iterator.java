package org.buaa.nlp.cj.designpattern.Iterator;

/**
 * Created by Administrator on 2015/5/18.
 */
public interface Iterator {
    //前移
    public Object previous();

    //后移
    public Object next();
    public boolean hasNext();

    //取得第一个元素
    public Object first();
}
