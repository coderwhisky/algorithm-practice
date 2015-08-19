package org.buaa.nlp.cj.concurrentprogram.comsumerproducer.ArrayBlockingQueue;

public class Apple {
	private String appName;
	public String getAppName() {
		return appName;
	}
	
	public String toString() {
		return this.appName;
	}
	
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public Apple(String appName) {
		this.appName = appName;
	}
}
