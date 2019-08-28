package com.owen.study.thread.practice;

/**
 * 大戏舞台
 * @Author Owen Xu
 * @Date 2018/11/20
 */
public class Stage extends Thread {
    @Override
    public void run() {
        System.out.println("欢迎观看隋唐演义");

        //舞台黑灯5s，等待大戏上演
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("舞台大幕拉开");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("双方军队杀的昏天暗地-------");
        ArmyRunnable armyRunnableOfZF = new ArmyRunnable();
        ArmyRunnable armyRunnableOfFarmer = new ArmyRunnable();

        //创建两个军队线程
        Thread armyOfZF = new Thread(armyRunnableOfZF,"政府军");
        Thread armyOfFarmer = new Thread(armyRunnableOfFarmer,"=====农民军");

        //启动线程，军队开始作战
        armyOfZF.start();
        armyOfFarmer.start();

        //舞台线程休眠，观看军队作战
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("激战正酣，半路杀出程咬金");
        Thread mrChen = new KeyPersonThread();
        mrChen.setName("Mr.Chen");
        System.out.println("Mr.Chen 想要结束战争");

        armyRunnableOfZF.keepRunning = false;
        armyRunnableOfFarmer.keepRunning = false;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //关键人物线程进入可运行状态，等待系统调度
        mrChen.start();

        try {
            //其他线程需要等待mrChen的线程结束
            mrChen.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("战争结束，谢谢观看");
    }

    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.start();
    }
}
