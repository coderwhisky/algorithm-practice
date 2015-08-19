package org.buaa.nlp.cj.concurrentprogram.comsumerproducer.ArrayBlockingQueue;

public class Consumer implements Runnable {
	private Basket basket;
	private String name;
	
	public Consumer(Basket basket, String name) {
		this.basket = basket;
		this.name = name;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				System.out.println(name + ":consumer" + basket.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
