package org.buaa.nlp.cj.designpattern.singleton;

/**
 * Created by Administrator on 2015/10/28.
 */
public class SingtonThreadTest implements Runnable{

    public void run() {
//        Singleton singleton = Singleton.getInstance();
//        SingletonLazybone singleton = SingletonLazybone.getInstance();
//        SingletonHungryModel singleton = SingletonHungryModel.getSingleton();
        SingletonInnerStatic singleton = SingletonInnerStatic.getInstance();
        System.out.println(singleton);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            Thread t1 = new Thread(new SingtonThreadTest());
            t1.start();
        }
    }
}
