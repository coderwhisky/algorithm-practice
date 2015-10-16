package org.buaa.nlp.cj;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2015/7/26.
 */
public class SourceInsight {
    public static void main(String[] args) {
        Executor exe = new ScheduledThreadPoolExecutor(3);
        ForkJoinPool forkJoinPool = new ForkJoinPool(2);
        ForkJoinTask<Integer> forkJoinTask = new ForkJoinTask<Integer>() {
            @Override
            public Integer getRawResult() {
                return null;
            }

            @Override
            protected void setRawResult(Integer value) {

            }

            @Override
            protected boolean exec() {
                return false;
            }

            Object obj = new Object();
        };

//        RecursiveAction;
//        RecursiveTask;
    }
}
