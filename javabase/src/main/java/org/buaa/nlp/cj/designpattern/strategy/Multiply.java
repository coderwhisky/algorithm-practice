package org.buaa.nlp.cj.designpattern.strategy;

/**
 * Created by Administrator on 2015/5/18.
 */
public class Multiply extends AbstractCalculator implements ICalculator {

    @Override
    public int calculate(String exp) {
        int arrayInt[] = split(exp,"\\*");
        return arrayInt[0]*arrayInt[1];
    }
}
