package org.buaa.nlp.cj.designpattern.singleton;

/**
 * Created by whisky on 15-5-3.
 */
public class Singleton {
    // ˽�й��췽������ֹ��ʵ����
    private Singleton() {}

    private static class SingletonFactory {
        private static Singleton instance = new Singleton();
    }

    // ��ȡʵ��
    public static Singleton getInstance() {
        return SingletonFactory.instance;
    }

    // ����ö����������л������Ա�֤���������л�ǰ�󱣳�һ��
    // ��Ϊ���л������л����ڶ���ĳ־û������ǽ������״̬������������������������Ȼ�����ʵ���ʱ���ٻ��
    public Object readResolve() {
        return getInstance();
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println(singleton == singleton1);

        System.out.println(singleton);
        System.out.println(singleton1);
        System.out.println(singleton2);
    }
}
