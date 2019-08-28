package com.owen.study.thread.practice;

/**
 * @Author Owen Xu
 * @Date 2018/11/20
 */
public class Actor extends Thread {
    @Override
    public void run() {
        System.out.println(getName() + "是一个演员");
        int count = 0;

        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println(getName() + "登台演出：" + (++count));

            if(count == 50){
                keepRunning = false;
            }
            if(count%10 == 0 ){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(getName() + "演出结束");
    }

    public static void main(String[] args) {
        Actor actor = new Actor();
        actor.setName("Mr.Thread");
        //启动线程
        actor.start();

        Thread actressThread = new Thread(new Actress(),"Ms.Runnable");
        //启动线程
        actressThread.start();

    }
}

class Actress implements Runnable {

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println(currentThreadName + "是一个演员");
        int count = 0;

        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println(currentThreadName + "登台演出：" + (++count));

            if(count == 50){
                keepRunning = false;
            }
            if(count%10 == 0 ){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(currentThreadName + "演出结束");
    }
}