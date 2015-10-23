package org.buaa.nlp.cj.jobOnlineProgram.meicaiwang;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by whisky-yonk on 10/23/2015.
 */
public class _1_ {
    private static class Job{
        int id;
        int re;
        int dura;
    }

    public static float waitingTimeSJF(int[] requestTimes , int[] durations){
        int [] wart = new int[requestTimes.length];
        int waitSum = 0;

        PriorityQueue queue = new PriorityQueue(100, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                Job oo1 = (Job) o1;
                Job oo2 = (Job) o2;
                if(oo1.dura != oo2.dura){
                    return  oo1.dura -  oo2.dura;
                }
                return oo1.re - oo2.re ;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });

        int interQueue = 0;
        for(int i = 0; ; i++){
            while(interQueue < requestTimes.length && requestTimes[interQueue] <= i){
                Job job = new Job();
                job.id = interQueue;
                job.re = requestTimes[interQueue];
                job.dura = durations[interQueue];
                queue.offer(job);
                interQueue ++;
            }
            if(!queue.isEmpty()){
                Job job = (Job) queue.poll();
                waitSum += i - job.re;
                i = i + job.dura - 1;
            }else if(i > requestTimes[requestTimes.length - 1]) {
                break;
            }
        }
        float res = (float)(waitSum) / requestTimes.length ;
        System.out.printf("%.2f",res);
        return res;
    }

    public static void main(String[] args){
        waitingTimeSJF(new int[]{0,1,3,9},new int[]{2,1,7,5});
    }

}
