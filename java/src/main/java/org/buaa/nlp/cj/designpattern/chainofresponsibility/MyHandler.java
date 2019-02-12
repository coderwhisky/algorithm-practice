package org.buaa.nlp.cj.designpattern.chainofresponsibility;

/**
 * Created by Administrator on 2015/5/18.
 */
public class MyHandler extends AbstractHandler implements Handler {
    private String name;

    public MyHandler(String name) {
        this.name = name;
    }

    @Override
    public void operator() {
        System.out.println(name+"deal!");
        if(getHandler()!=null){
            getHandler().operator();
        }
    }
}
