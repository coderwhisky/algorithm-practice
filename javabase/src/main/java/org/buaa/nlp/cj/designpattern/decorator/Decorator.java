package org.buaa.nlp.cj.designpattern.decorator;

/**
 * Created by Administrator on 2015/5/17.
 */
public class Decorator implements Sourceable {
    private Sourceable source;
    public Decorator(Sourceable source) {
        super();
        this.source = source;
    }
    @Override
    public void method() {
        System.out.println("before decorator");
        source.method();
        System.out.println("after decorator");
    }
}
