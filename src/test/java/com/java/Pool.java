package com.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by wangzhj on 2016/9/27.
 */
public class Pool<T> {

    private int count = 0;

    private static Queue<Object> queue = new ConcurrentLinkedQueue<>();

    public Pool() {
        this(10);
    }

    public Pool(int count) {
        for (int i = 0; i < count; count++) {
            new Thread(new Worker(queue), "线程[" + i + "]").start();
        }
    }

    public synchronized static void add(Object t) {
        queue.add(t);
        queue.notifyAll();
    }
}
