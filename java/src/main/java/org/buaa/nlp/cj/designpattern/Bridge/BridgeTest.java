package org.buaa.nlp.cj.designpattern.Bridge;

/**
 * Created by Administrator on 2015/5/18.
 */
public class BridgeTest {
    public static void main(String[] args) {
        Bridge bridge = new MyBridge();

        Sourceable source1 = (Sourceable) new SourceSub1();
        bridge.setSource(source1);
        bridge.method();

        Sourceable source2 = (Sourceable) new SourceSub2();
        bridge.setSource(source2);
        bridge.method();
    }
}
