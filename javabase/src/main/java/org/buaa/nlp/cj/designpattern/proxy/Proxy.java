package org.buaa.nlp.cj.designpattern.proxy;

/**
 * Created by Administrator on 2015/5/17.
 */
public class Proxy implements Sourceable {
    private Source source;
    public Proxy() {
        super();
        this.source = new Source();
    }

    public void method() {
        befor();
        source.method();
        after();
    }

    private void after() {
        System.out.println("after proxy");
    }

    private void befor() {
        System.out.println("before proxy");
    }
}
