package org.buaa.nlp.cj.designpattern.Bridge;


/**
 * Created by Administrator on 2015/5/18.
 */
public abstract class Bridge {
    Sourceable source;

    public void method() {
        source.method();
    }

    public Sourceable getSource() {
        return source;
    }

    public void setSource(Sourceable source) {
        this.source = source;
    }

}
