package org.buaa.nlp.cj.concurrentprogram;

/**
 * Created by Administrator on 2015/5/24.
 */
public class Calculator implements Runnable {
    private int number;
    public Calculator(int number) {
        this.number = number;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            Calculator calculator = new Calculator(i);
            Thread thread = new Thread(calculator);
            thread.start();
        }
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s: %d * %d = %d\n",
                    Thread.currentThread().getName(),
                    number, i, i * number);
        }
    }
}
