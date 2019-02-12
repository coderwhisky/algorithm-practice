package org.buaa.nlp.cj.concurrentprogram.comsumerproducer;

public class Producer implements Runnable {
	private Info info = null;
	public Producer(Info info) {
		this.info = info;
	}
	
	public void run() {
		boolean flag = true;
		for (int i = 0; i < 10; i++) {
			if (flag) {
				this.info.set("name--1", "content--1");
				flag = false;
			} else {
				this.info.set("name--2", "content--2");
				flag = true;
			}
		}
	}

}
