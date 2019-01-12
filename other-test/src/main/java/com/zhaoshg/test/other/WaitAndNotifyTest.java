package com.zhaoshg.concurrent;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * TODO Write down the function of this class
 *
 * @Description
 * @auther zhaoshg    mail:mr.zhaoshg@gmail.com
 * @create 2019-01-10 17:17
 */
public class WaitAndNotifyTest {
    // 在多线程间共享的对象上使用wait
    private String[] shareObj = {"true"};
    private volatile int flag = 3;


    @Test
    public void test() throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(4);
        WaitAndNotifyTest test = new WaitAndNotifyTest();
        WaitAndNotifyTest.ThreadWait threadWait1 = test.new ThreadWait("wait thread1", latch);
        threadWait1.setPriority(2);
        WaitAndNotifyTest.ThreadWait threadWait2 = test.new ThreadWait("wait thread2", latch);
        threadWait2.setPriority(3);
        WaitAndNotifyTest.ThreadWait threadWait3 = test.new ThreadWait("wait thread3", latch);
        threadWait3.setPriority(4);

        WaitAndNotifyTest.ThreadNotify threadNotify = test.new ThreadNotify("notify thread", latch);
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(threadNotify);
        service.execute(threadWait1);
        service.execute(threadWait2);
        service.execute(threadWait3);
        //FIXME Junit 不支持多线程，主线程会提前结束，所以需要睡眠足够时间
//        Thread.sleep(6000);
        //FIXME Junit 不支持多线程，主线程会提前结束，也可以用latch来控制
        latch.await();
        service.shutdown();
    }


    class ThreadWait extends Thread {

        private CountDownLatch latch;

        public ThreadWait(String name, final CountDownLatch latch) {
            super(name);
            this.latch = latch;
        }

        public void run() {
            synchronized (shareObj) {
                while ("true".equals(shareObj[0])) {
                    System.out.println("线程" + this.getName() + "开始等待");
                    long startTime = System.currentTimeMillis();
                    try {
                        flag--;
                        sleep(1000);
                        System.out.println("线程" + this.getName() + " flag is " + flag);
                        shareObj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    long endTime = System.currentTimeMillis();
                    System.out.println("线程" + this.getName() + "等待时间为：" + (endTime - startTime));
                }
            }
            System.out.println("线程" + getName() + "等待结束");
            latch.countDown(); // 执行完毕，计数器减1
        }
    }

    class ThreadNotify extends Thread {
        private CountDownLatch latch;

        public ThreadNotify(String name, CountDownLatch latch) {
            super(name);
            this.latch = latch;
        }

        public void run() {
            try {
                while (flag != 0) {
                    System.out.println("flag == " + flag);
                    System.out.println("sleep 100ms");
                    sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (shareObj) {
                if (flag == 0) {
                    System.out.println("线程" + this.getName() + "开始准备通知");
                    shareObj[0] = "false";
                    shareObj.notifyAll();
                    System.out.println("线程" + this.getName() + "通知结束");
                    System.out.println("线程" + this.getName() + "运行结束");
                    latch.countDown(); // 执行完毕，计数器减1
                }
            }
        }
    }
}
