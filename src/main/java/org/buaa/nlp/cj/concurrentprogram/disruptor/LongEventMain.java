package org.buaa.nlp.cj.concurrentprogram.disruptor;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

public class LongEventMain {
	public static void main(String[] args) throws Exception{
		Executor executor = Executors.newCachedThreadPool();
		
		LongEventFactory factory = new LongEventFactory();
		
		int bufferSize = 1024;
		
		Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>((EventFactory<LongEvent>) factory, bufferSize, executor);
		
		disruptor.handleEventsWith(new LongEventHandler());
		
		disruptor.start();
		
		RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
		
		LongEventProducer producer = new LongEventProducer(ringBuffer);
		
		ByteBuffer bb = ByteBuffer.allocate(8);
		for(long l = 0; true; l++) {
			bb.putLong(0, l);
			producer.ondata(bb);
			Thread.sleep(1000);
		}
	}

}
