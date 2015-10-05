package org.buaa.nlp.cj.understandingTheJVM;

/**
 * 此代码演示了两点：
 * 1.对象可以在被GC时自我拯救
 * 2.这种自救机会只有一次，因为一个对象的finalize()方法最多只会被系统自动调用一次
 * Created by whisky-yonk on 10/4/2015.
 */
public class _3_2_FinalizeEscapeGC {
    public static _3_2_FinalizeEscapeGC SAVE_HOOK = null;
    public void isAlive() {
        System.out.println("yes, i am still alive");
    }

    public void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        _3_2_FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new _3_2_FinalizeEscapeGC();
        // 第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();
        // 因为finalize()方法优先级降低，所以暂停0.5秒以等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead :(");
        }

        // 下面这段代码与上面的完全相同，但是这次自救却失败了
        SAVE_HOOK = null;
        System.gc();
        // 因为finalize()方法优先级降低，所以暂停0.5秒以等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead :(");
        }
    }
}
