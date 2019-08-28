package com.owen.study.thread.practice;

/**
 * @Author Owen Xu
 * @Date 2018/11/20
 */
public class KeyPersonThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始战斗了！");
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "强力攻击政府军---");
        }
        System.out.println(Thread.currentThread().getName() + "结束战斗了！");
    }
}
