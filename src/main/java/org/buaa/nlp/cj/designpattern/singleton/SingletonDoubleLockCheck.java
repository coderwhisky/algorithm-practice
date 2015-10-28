package org.buaa.nlp.cj.designpattern.singleton;

/**
 * 双重检验锁
 * Created by Administrator on 2015/10/28.
 */
public class SingletonDoubleLockCheck {
//    private static SingletonDoubleLockCheck instance;
    /**
     * instance = new SingletonDoubleLockCheck(); 这个并非一个原子操作，事实上JVM中做了这三件事儿：
     *  1. 给 instance 分配内存
     *  2. 调用 SingletonDoubleLockCheck 的构造函数来初始化成员变量
     *  3. 将 instance 对象指向分配的内存空间
     *  在 JVM 即时编译时存在指令重排序的优化，也就是说上面的第二步和第三步的顺序是不能保证的，最终的执行顺序可能是 1-3-2 或者 1-2-3
     *  如果是前者，则在 3 执行完毕、 2 未执行之前，被线程二抢占了， 这时 instance 已经是非 null 的了（但却没有初始化），所以线程二会直接返回
     *  instance ，然后使用，就会报错
     *
     *  这是使用 volatile 的原因。
     */
    private volatile static SingletonDoubleLockCheck instance;
    private SingletonDoubleLockCheck(){}
    public static SingletonDoubleLockCheck getInstance() {
        if (instance == null) {
            synchronized (SingletonDoubleLockCheck.class) {
                if (instance == null) {
                    instance = new SingletonDoubleLockCheck();
                }
            }
        }
        return instance;
    }

}
