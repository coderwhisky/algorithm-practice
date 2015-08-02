package org.buaa.nlp.cj.designpattern.adapter;

/**
 * Created by whisky on 15-5-3.
 */
public class AdapterTest {
    public static void main(String[] args) {
        // 类的适配器模式
        Targetable target = new Adapter();
        target.method1();
        target.method2();

        // 对象的适配器模式
        Source source = new Source();
        Targetable target1 = new Wrapper(source);
        target1.method1();
        target1.method2();

        // 接口的适配器模式
        Sourceable source1 = new SourceSub1();
        Sourceable source2 = new SourceSub2();
        source1.method1();
        source1.method2();
        source2.method1();
        source2.method2();
    }

}
