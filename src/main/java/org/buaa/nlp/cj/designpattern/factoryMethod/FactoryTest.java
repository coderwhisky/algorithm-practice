package org.buaa.nlp.cj.designpattern.factoryMethod;

/**
 * Created by whisky on 15-5-3.
 */
public class FactoryTest {
    public static void main(String[] args) {
        // ����������������
        SendFactory factory = new SendFactory();
        Sender sender = factory.produce("sms");
        sender.Send();

        // ���������������
        Sender sender1 = factory.produceMail();
        sender1.Send();

        // ���󹤳���������
        Provider provider = new MailSendFactory();
        Sender sender2 = provider.produce();
        sender2.Send();
    }
}
