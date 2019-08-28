package com.owen.study.thread.threadPool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TestScheduledThreadPool {
    public static void main(String[] args) {
        final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        final Runnable beeper = new Runnable() {
            int count = 0;

            @Override
            public void run() {
                System.out.printf("[" + new Date() + "] count=" + (++count));
            }
        };

        //1秒之后，每隔2秒运行一次
        final ScheduledFuture<?> beeperHandle = scheduledExecutorService.
                scheduleAtFixedRate(beeper, 1, 2, TimeUnit.SECONDS);

        //2秒之后运行，每次在上次任务运行完成后，等待5秒后重新运行
        final ScheduledFuture beeperHandle2 = scheduledExecutorService
                .scheduleWithFixedDelay(beeper, 2, 5, TimeUnit.SECONDS);

        //30秒之后，结束任务，并关闭scheduledExecutorService
        scheduledExecutorService.schedule(() -> {
            beeperHandle.cancel(true);
            beeperHandle2.cancel(true);
            scheduledExecutorService.shutdown();
        }, 30, TimeUnit.SECONDS);
    }
}
