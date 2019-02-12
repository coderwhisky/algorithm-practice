package org.buaa.nlp.cj.designpattern.factoryMethod;

/**
 * Created by whisky on 15-5-3.
 */
public class SmsSender implements Sender {
    @Override
    public void Send() {
        System.out.println("this is sms sender");
    }
}
