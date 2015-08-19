package org.buaa.nlp.cj.concurrentprogram.comsumerproducer.ArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;



public class Basket {
	ArrayBlockingQueue<Apple> basket = new ArrayBlockingQueue<Apple>(3);
	
	public void add(Apple apple) throws InterruptedException {
		if (basket.size() >= 3) {
			System.out.println("add block, please waiting...");
		}
		basket.put(apple);
	}

	
	public Apple get() throws InterruptedException {
		if (basket.size() <= 0) {
			System.out.println("get block, there is no apple...");
		}
		return basket.take();
	}
}

