package org.buaa.nlp.cj.concurrentprogram.theArtOfJavaCurrencyProgram;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * Created by whisky-yonk on 9/21/2015.
 */
public class _4_17_ConnecitonDriver {
    static class ConnectionHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().equals("commit")) {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            return null;
        }
    }

    public static final Connection createConnection() {
        return (Connection) Proxy.newProxyInstance(_4_17_ConnecitonDriver.class.getClassLoader(),
                new Class<?>[] {Connection.class}, new ConnectionHandler());
    }
}
