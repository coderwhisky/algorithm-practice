package org.buaa.nlp.cj.designpattern.Bridge;


/**
 * Created by Administrator on 2015/5/18.
 */
public class SourceSub2 implements Sourceable {
    @Override
    public void method() {
        System.out.println("this is the second sub!");
    }
}
