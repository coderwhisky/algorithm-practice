package org.buaa.nlp.cj.baseAlgorithm.mystack;

import java.util.Objects;

/**
 * Created by Administrator on 2015/9/7.
 */
public interface MyStack {

    boolean isEmpty();

    void clear();

    int length();

    boolean push(Integer data);

    Integer pop();
}
