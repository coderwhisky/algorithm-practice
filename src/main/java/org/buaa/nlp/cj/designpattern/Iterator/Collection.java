package org.buaa.nlp.cj.designpattern.Iterator;

/**
 * Created by Administrator on 2015/5/18.
 */
public interface Collection {
    public Iterator iterator();

    /*ȡ�ü���Ԫ��*/
    public Object get(int i);

    /*ȡ�ü��ϴ�С*/
    public int size();
}
