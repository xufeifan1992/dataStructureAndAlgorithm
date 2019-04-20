package com.Queue;

/**
 * Created by xufei
 * 2019/4/17
 */
public interface Queue<E> {
    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();
}
