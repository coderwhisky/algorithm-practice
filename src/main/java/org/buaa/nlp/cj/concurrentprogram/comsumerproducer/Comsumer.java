package org.buaa.nlp.cj.concurrentprogram.comsumerproducer;

public class Comsumer implements Runnable {
	private Info info = null;
	public Comsumer(Info info) {
		this.info = info;
	}
	public void run() {
		for (int i = 0; i < 10; i++) {
			this.info.get();
		}
	}

}
