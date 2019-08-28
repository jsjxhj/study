package com.owen.study.thread.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemoTest {
    public static void main(String[] args) {
        CallableDemo ctt = new CallableDemo();
        FutureTask<Integer> ft = new FutureTask<>(ctt);
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " 的循环变量i的值" + i);
            if (i == 20) {
                new Thread(ft, "有返回值的线程").start();
            }
        }
        try {
            System.out.println("子线程的返回值：" + ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
