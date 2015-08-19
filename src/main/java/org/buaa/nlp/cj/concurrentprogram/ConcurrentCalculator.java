package org.buaa.nlp.cj.concurrentprogram;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import com.sun.jndi.url.corbaname.corbanameURLContextFactory;

public class ConcurrentCalculator {
	private ExecutorService exec;
	private int cpuCoreNumber;
	private List<Future<Long>> tasks = new ArrayList<Future<Long>>();
	
	// inner class, complete the split child task
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
	
	public ConcurrentCalculator() {
		cpuCoreNumber = Runtime.getRuntime().availableProcessors();
		exec = Executors.newFixedThreadPool(cpuCoreNumber);
	}
	
	/**
	 * 根据 CPU 核心个数拆分任务，创建 FutureTask 并提交到 executor
	 * @param numbers
	 * @return
	 */
	public Long sum(final int[] numbers) {
		for(int i = 0; i < cpuCoreNumber; i++) {
			int increment = numbers.length / cpuCoreNumber + 1;
			int start = increment*i;
			int end = increment * i + increment;
			if (end > numbers.length) {
				end = numbers.length;
			}
			SumCalculator subCal = new SumCalculator(numbers, start, end);
			FutureTask<Long> task = new FutureTask<Long>(subCal);
			tasks.add(task);
			if (!exec.isShutdown()) {
				exec.submit(task);
			}
		}
		return getResult();
	}
	
	public Long getResult() {
		Long result = 0l;
		for(Future<Long> task : tasks) {
			Long subSum;
			try {
				// 如果计算未完成，则阻塞
				subSum = task.get();
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
	
	public static void main(String[] args) {
		int[] numbers = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,14,13,15,16,17,18,19};
		ConcurrentCalculator calc = new ConcurrentCalculator();
		Long sum = calc.sum(numbers);
		System.out.println(sum);
		calc.close();
	}
}
