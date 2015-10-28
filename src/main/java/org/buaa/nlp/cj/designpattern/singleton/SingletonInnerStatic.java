package org.buaa.nlp.cj.designpattern.singleton;

/**
 * Created by Administrator on 2015/10/28.
 */
public class SingletonInnerStatic {
    private SingletonInnerStatic(){}
    private static class SinletonHolder {
        private static final SingletonInnerStatic INSTANCE = new SingletonInnerStatic();
    }

    public static SingletonInnerStatic getInstance() {
        return SinletonHolder.INSTANCE;
    }
}
