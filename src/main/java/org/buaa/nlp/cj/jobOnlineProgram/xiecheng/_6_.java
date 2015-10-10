package org.buaa.nlp.cj.jobOnlineProgram.xiecheng;

/**
 * Created by Administrator on 2015/10/10.
 */
public class _6_ {
    abstract static class Animal{
        static {
            System.out.println("animal static code block");
        }
        Animal() {
            System.out.println("animal construtor");
        }
    }

    class Tiger extends Animal{
        Tiger() {
            System.out.println("tig construtor");
        }
    }

    public class Dog extends Animal {
        Dog(){
            System.out.println("Dog construtor");
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println("new Zoo befor");
        _6_ _6_aa = new _6_();
        Class c = Class.forName("org.buaa.nlp.cj.jobOnlineProgram.xiecheng.Dog");
        System.out.println("initilize before");
        Animal dog = (Animal)c.newInstance();
        System.out.println("new Zoo after");
    }


}
