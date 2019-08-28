package com.owen.study.thread.practice;

/**
 * 军队线程，模拟作战双方的行为
 *
 * @Author Owen Xu
 * @Date 2018/11/20
 */
public class ArmyRunnable implements Runnable {
    //保证线程可以正确的读取其他线程写入的值
    volatile boolean keepRunning = true;

    @Override
    public void run() {
        while (keepRunning) {
            //发动5连击
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "进攻方【" + i + "】");
                //让出处理器时间，下次谁进攻不知道，去抢cpu资源
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread().getName() + "结束了进攻!");
    }
}
