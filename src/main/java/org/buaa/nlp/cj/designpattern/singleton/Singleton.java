package org.buaa.nlp.cj.designpattern.singleton;

/**
 * Created by whisky on 15-5-3.
 */
public class Singleton {
    // 私有构造方法，防止被实例化
    private Singleton() {}

    private static class SingletonFactory {
        private static Singleton instance = new Singleton();
    }

    // 获取实例
    public static Singleton getInstance() {
        return SingletonFactory.instance;
    }

    // 如果该对象被用于序列化，可以保证对象在序列化前后保持一致
    // 何为序列化：序列化用于对象的持久化，就是将对象的状态（各个属性量）保存起来，然后在适当的时候再获得
    public Object readResolve() {
        return getInstance();
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
    }
}
