package org.buaa.nlp.cj.designpattern.Iterator;

/**
 * Created by Administrator on 2015/5/18.
 */
public interface Iterator {
    //ǰ��
    public Object previous();

    //����
    public Object next();
    public boolean hasNext();

    //ȡ�õ�һ��Ԫ��
    public Object first();
}
