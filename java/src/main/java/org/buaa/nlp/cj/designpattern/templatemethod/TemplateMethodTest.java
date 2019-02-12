package org.buaa.nlp.cj.designpattern.templatemethod;

/**
 * Created by Administrator on 2015/5/18.
 */
public class TemplateMethodTest {
    public static void main(String[] args) {
        String exp = "8+8";
        AbstractCalculator cal = new Plus();
        int result = cal.calculate(exp, "\\+");
        System.out.println(result);
    }
}
