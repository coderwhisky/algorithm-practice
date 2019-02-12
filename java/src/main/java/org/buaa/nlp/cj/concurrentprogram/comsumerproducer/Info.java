package org.buaa.nlp.cj.concurrentprogram.comsumerproducer;

import com.sun.xml.internal.bind.v2.runtime.Name;

public class Info {
	private String name = "name";
	private String content = "content";
	private boolean flag = true;
	
	public synchronized void set(String name, String conten) {
		while (!flag) {
			try {
				super.wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		this.setName(name);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		this.setContent(conten);
		flag = false;
		super.notify();
	}
	
	public synchronized void get() {
		while (flag) {
			try {
				super.wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println(this.name + "-->" + this.content);
		flag = true;
		super.notify();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
