package org.buaa.nlp.cj.designpattern.chainofresponsibility;

/**
 * Created by Administrator on 2015/5/18.
 */
public abstract class AbstractHandler {
    private Handler handler;

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
