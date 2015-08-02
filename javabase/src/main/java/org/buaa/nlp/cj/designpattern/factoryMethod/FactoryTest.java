package org.buaa.nlp.cj.designpattern.factoryMethod;

/**
 * Created by whisky on 15-5-3.
 */
public class FactoryTest {
    public static void main(String[] args) {
        // 单个工厂方法测试
        SendFactory factory = new SendFactory();
        Sender sender = factory.produce("sms");
        sender.Send();

        // 多个工厂方法测试
        Sender sender1 = factory.produceMail();
        sender1.Send();

        // 抽象工厂方法测试
        Provider provider = new MailSendFactory();
        Sender sender2 = provider.produce();
        sender2.Send();
    }
}
