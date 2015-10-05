package org.buaa.nlp.cj.understandingTheJVM;

/**
 * Created by whisky-yonk on 10/4/2015.
 */
public class _3_1_ReferenceCountingGC {
    public Object instance = null;
    private static final int _1Mb = 1024*1024;
    private byte[] bigSize = new byte[2*_1Mb];

    public static void testGC() {
        _3_1_ReferenceCountingGC objA = new _3_1_ReferenceCountingGC();
        _3_1_ReferenceCountingGC objB = new _3_1_ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;
        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }
}
