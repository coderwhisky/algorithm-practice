package org.buaa.nlp.cj.concurrentprogram;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class ConcurrentCalculator2 {
	private ExecutorService exec;
	private CompletionService<Long> completionService;
	private int cpuCoreNumbers;
	
	class SumCalculator implements Callable<Long> {
		private int[] numbers;
		private int start;
		private int end;

		public SumCalculator(int[] numbers, int start, int end) {
			this.numbers = numbers;
			this.start = start;
			this.end = end;
		}
		
		public Long call() throws Exception {
			// TODO Auto-generated method stub
			long sum = 0;
			for(int i = start; i < end; i++) {
				sum += numbers[i];
			}
			return sum;
		}
	}
	
	public ConcurrentCalculator2() {
		// TODO Auto-generated constructor stub
		cpuCoreNumbers = Runtime.getRuntime().availableProcessors();
		exec = Executors.newFixedThreadPool(cpuCoreNumbers);
		completionService = new ExecutorCompletionService<Long>(exec);
	}
	
	/**
	 * {@link ConcurrentCalculator}
	 * @param numbers
	 * @return
	 */
	public Long sum(final int[] numbers) {
		for (int i = 0; i < cpuCoreNumbers; i++) {
			int increment = numbers.length / cpuCoreNumbers +1;
			int start = increment*i + 1;
			int end = increment*i +increment;
			if (end > numbers.length) {
				end = numbers.length;
			}
			SumCalculator subCal = new SumCalculator(numbers, start, end);
			if (!exec.isShutdown()) {
				exec.submit(subCal);
			}
		}
		return getResult();
	}
	
	public Long getResult() {
		Long result = 0l;
		for (int i = 0; i < cpuCoreNumbers; i++) {
			try {
				Long subSum = completionService.take().get();
				result += subSum;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public void close() {
		exec.shutdown();
	}
	
	class RR implements Runnable {
		public void run() {
			// TODO Auto-generated method stub
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Integer.SIZE);
		BlockingQueue<Runnable> lbq = new LinkedBlockingDeque<Runnable>();
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 1, TimeUnit.HOURS, lbq);
		System.out.println();
	}
}
