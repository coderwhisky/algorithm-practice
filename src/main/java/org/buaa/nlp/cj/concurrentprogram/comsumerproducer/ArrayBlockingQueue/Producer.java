package org.buaa.nlp.cj.concurrentprogram.comsumerproducer.ArrayBlockingQueue;

public class Producer implements Runnable{
	private Basket basket;
	private String name;
	
	public Producer(Basket basket, String name) {
		this.basket = basket;
		this.name = name;
	}

	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println(name + "produce...");
			try {
				basket.add(new Apple("name" + Math.random()*100));
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
