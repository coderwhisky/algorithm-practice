package org.buaa.nlp.cj.designpattern.Iterator;

/**
 * Created by Administrator on 2015/5/18.
 */
public interface Collection {
    public Iterator iterator();

    /*取得集合元素*/
    public Object get(int i);

    /*取得集合大小*/
    public int size();
}
