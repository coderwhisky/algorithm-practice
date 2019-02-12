package org.buaa.nlp.cj.designpattern.Facade;

/**
 * Created by Administrator on 2015/5/18.
 */
public class User {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startup();
        computer.shutdown();
    }
}
