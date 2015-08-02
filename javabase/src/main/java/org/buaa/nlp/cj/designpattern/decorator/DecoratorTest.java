package org.buaa.nlp.cj.designpattern.decorator;

/**
 * Created by Administrator on 2015/5/17.
 */
public class DecoratorTest {
    public static void main(String[] args) {
        Sourceable source = new Source();
        source.method();
        Sourceable obj = new Decorator(source);
        obj.method();
    }
}
