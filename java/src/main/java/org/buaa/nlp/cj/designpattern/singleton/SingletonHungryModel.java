package org.buaa.nlp.cj.designpattern.singleton;

/**
 * 饿汉单例模式
 * 关键点：单例的实例被声明为 static 和 final 变量，在第一次加载到内存时就会被初始化，所以创建实例本身是安全的
 * Created by Administrator on 2015/10/28.
 */
public class SingletonHungryModel {
    private static final SingletonHungryModel singleton = new SingletonHungryModel();
    private SingletonHungryModel() {}

    public static SingletonHungryModel getSingleton() {
        return singleton;
    }
}
