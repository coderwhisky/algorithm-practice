package org.buaa.nlp.cj.concurrentprogram.theArtOfJavaCurrencyProgram;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by whisky-yonk on 9/21/2015.
 */
public class _4_16_ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<Connection>();

    public _4_16_ConnectionPool(int initialSize) {
        if (initialSize > 0) {
            for (int i = 0; i < initialSize; i++) {
                pool.addLast(_4_17_ConnecitonDriver.createConnection());
            }
        }
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            synchronized (pool) {
                pool.addLast(connection);
                // 链接释放后需要通知，这样其他消费者能够感知到连接池中已经归还了一个链接
                pool.notifyAll();
            }
        }
    }

    // 在mills内无法获取到链接，将会返回null
    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (pool) {
            if (mills <= 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeFirst();
            } else {
                long future = System.currentTimeMillis() + mills;
                long remaining = mills;
                while (pool.isEmpty() && remaining > 0) {
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }
                Connection result = null;
                if (!pool.isEmpty()) {
                    result = pool.removeFirst();
                }
                return result;
            }
        }
    }
}
