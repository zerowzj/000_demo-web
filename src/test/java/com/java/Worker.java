package com.java;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by wangzhj on 2016/9/27.
 */
public class Worker<T> implements Runnable {

    private Queue<T> queue = new ConcurrentLinkedQueue<>();

    public Worker(Queue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        synchronized (queue){
            while(queue.isEmpty()){
                try {
                    queue.wait();
                } catch (Exception ex){
                    ex.printStackTrace();
                }

                queue.peek();
            }
        }
    }
}
