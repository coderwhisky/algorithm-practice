package org.buaa.nlp.cj.designpattern.factoryMethod;

/**
 * Created by whisky on 15-5-3.
 */
public class MailSender implements Sender {
    @Override
    public void Send() {
        System.out.println("this is mail sender");
    }
}
