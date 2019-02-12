package org.buaa.nlp.cj.designpattern.singleton;

/**
 * 懒汉模式：线程安全
 * 如果不用 synchronized 则是线程不安全的懒汉模式
 * Created by Administrator on 2015/10/28.
 */
public class SingletonLazybone {
    private SingletonLazybone(){}

    private static SingletonLazybone instance;

    public static synchronized SingletonLazybone getInstance() {
        if (instance == null) {
            instance = new SingletonLazybone();
        }
        return instance;
    }

    public static void main(String[] args) {
        SingletonLazybone singleton = SingletonLazybone.getInstance();
        SingletonLazybone singleton1 = SingletonLazybone.getInstance();
        System.out.println(singleton == singleton1);
        System.out.println(singleton);
        System.out.println(singleton1);
    }
}
