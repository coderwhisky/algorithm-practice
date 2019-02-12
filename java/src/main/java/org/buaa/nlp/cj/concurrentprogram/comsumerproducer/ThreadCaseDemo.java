package org.buaa.nlp.cj.concurrentprogram.comsumerproducer;

public class ThreadCaseDemo {
	public static void main(String[] args) {
		Info info = new Info();
		Producer pro = new Producer(info);
		Comsumer com = new Comsumer(info);
		Thread tpro = new Thread(pro);
		Thread tcom = new Thread(com);
		tpro.start();
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		tcom.start();
	}
}
