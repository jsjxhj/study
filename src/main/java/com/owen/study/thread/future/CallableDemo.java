package com.owen.study.thread.future;

import java.util.concurrent.Callable;

public class CallableDemo implements Callable<Integer> {
    @Override
    public Integer call() {
        int i = 0;
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        return i;
    }
}
