package org.buaa.nlp.cj.designpattern.Bridge;

/**
 * Created by Administrator on 2015/5/18.
 */
public class MyBridge extends Bridge {
    public void method() {
        getSource().method();
    }
}
