package org.buaa.nlp.cj.concurrentprogram.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * 消费事件
 * @author I320592
 *
 */
public class PersonEvent {
	private Person person;
	public final static EventFactory<PersonEvent> EVENT_FACTORY = new EventFactory<PersonEvent>() {
		public PersonEvent newInstance() {
			return new PersonEvent();
		}
	};
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
}
