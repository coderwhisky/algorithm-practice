package org.buaa.nlp.cj.designpattern.decorator;

/**
 * Created by Administrator on 2015/5/17.
 */
public class Source implements Sourceable {
    @Override
    public void method() {
        System.out.println("the original method");
    }
}
