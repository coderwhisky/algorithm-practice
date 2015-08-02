package org.buaa.nlp.cj.designpattern.adapter;

/**
 * Created by whisky on 15-5-3.
 */
public class Adapter extends Source implements Targetable {

    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }
}
