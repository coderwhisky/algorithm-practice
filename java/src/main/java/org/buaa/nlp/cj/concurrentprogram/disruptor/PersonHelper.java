package org.buaa.nlp.cj.concurrentprogram.disruptor;

import com.lmax.disruptor.BatchEventProcessor;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SequenceBarrier;
import com.lmax.disruptor.YieldingWaitStrategy;

public class PersonHelper {
	private static PersonHelper instance;
	private static boolean inited = false;
	
	private static final int BUFFER_SIZE = 256;
	private RingBuffer<PersonEvent> ringBuffer;
	private SequenceBarrier sequenceBarrier;
	private PersonEventHandler handler;
	private BatchEventProcessor<PersonEvent> batchEventProcessor;
	
	public PersonHelper() {
//		ringBuffer = new RingBuffer<PersonEvent>(PersonEvent.EVENT_FACTORY, BUFFER_SIZE);
	}
}
