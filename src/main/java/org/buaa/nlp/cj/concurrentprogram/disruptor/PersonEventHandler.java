package org.buaa.nlp.cj.concurrentprogram.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * 消费事件处理器
 * @author I320592
 *
 */
public class PersonEventHandler implements EventHandler<PersonEvent> {
	public PersonEventHandler() {
	}

	public void onEvent(PersonEvent event, long sequence, boolean endOfBatch) throws Exception {
		// TODO Auto-generated method stub
		Person person = event.getPerson();
		System.out.println("name=" + person.getName() + 
				", age=" + person.getAge() +
				", gender=" + person.getGender() +
				", mobile=" + person.getMobile());
	}
}
