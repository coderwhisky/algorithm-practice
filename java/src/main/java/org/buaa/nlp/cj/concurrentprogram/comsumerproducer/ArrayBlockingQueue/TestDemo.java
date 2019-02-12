package org.buaa.nlp.cj.concurrentprogram.comsumerproducer.ArrayBlockingQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import sun.print.resources.serviceui;

public class TestDemo {
	
	public static void main(String[] args) {
		
		Basket basket = new Basket();
		
		Consumer c1 = new Consumer(basket, "c1");
		
		Producer p1 = new Producer(basket, "p1");
		Producer p2 = new Producer(basket, "p2");
		
		ExecutorService service = Executors.newCachedThreadPool();
//		ScheduledThreadPoolExecutor service = new ScheduledThreadPoolExecutor(3);
		service.execute(c1);
		service.execute(p1);
		service.execute(p2);
	}
}
