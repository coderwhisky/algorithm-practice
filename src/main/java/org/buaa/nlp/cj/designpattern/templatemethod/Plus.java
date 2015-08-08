package org.buaa.nlp.cj.designpattern.templatemethod;

/**
 * Created by Administrator on 2015/5/18.
 */
public class Plus extends AbstractCalculator {
    @Override
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }
}
