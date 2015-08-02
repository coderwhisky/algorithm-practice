package org.buaa.nlp.cj.designpattern.proxy;

/**
 * Created by Administrator on 2015/5/17.
 */
public class ProxyTest {
    public static void main(String[] args) {
        Sourceable source = new Proxy();
        source.method();
    }
}
