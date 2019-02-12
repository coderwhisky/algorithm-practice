package org.buaa.nlp.cj.designpattern.factoryMethod;

/**
 * ������
 * Created by whisky on 15-5-3.
 */
public class SendFactory {
    /**
     * �������������ķ�ʽ
     * @param type
     * @return
     */
    public Sender produce(String type) {
        if ("mail".equals(type)) {
            return new MailSender();
        } else if ("sms".equals(type)) {
            return new SmsSender();
        } else {
            System.out.println("��������ȷ�����ͣ�");
            return null;
        }
    }

    /**
     * �������������
     * @return
     */
    public Sender produceMail() {
        return new MailSender();
    }

    public Sender prouceSms() {
        return new SmsSender();
    }
}
