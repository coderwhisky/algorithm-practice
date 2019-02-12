package org.buaa.nlp.cj.designpattern.factoryMethod;

/**
 * 工厂类
 * Created by whisky on 15-5-3.
 */
public class SendFactory {
    /**
     * 单个工厂方法的方式
     * @param type
     * @return
     */
    public Sender produce(String type) {
        if ("mail".equals(type)) {
            return new MailSender();
        } else if ("sms".equals(type)) {
            return new SmsSender();
        } else {
            System.out.println("请输入正确的类型！");
            return null;
        }
    }

    /**
     * 多个工厂方法类
     * @return
     */
    public Sender produceMail() {
        return new MailSender();
    }

    public Sender prouceSms() {
        return new SmsSender();
    }
}
