package org.buaa.nlp.cj.designpattern.factoryMethod;

/**
 * Created by whisky on 15-5-3.
 */
public class SmsSendFactory implements Provider {
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
