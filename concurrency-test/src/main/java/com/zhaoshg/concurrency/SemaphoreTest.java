package com.zhaoshg.concurrency;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

/**
 * @Description
 * @auther zhaoshg    mail:mr.zhaoshg@gmail.com
 * @create 2019-01-11 8:57
 */
public class SemaphoreTest {

    Semaphore semaphore = new Semaphore(0);

    @Test
    public void test() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {

                System.out.println(Thread.currentThread().getName() + " try to  get semaphore");
                semaphore.acquire(2);
                System.out.println(Thread.currentThread().getName() + " now get semaphore");
                semaphore.release(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " sleeping 500ms ...");
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " release some semaphore");
            semaphore.release(2);
        });

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(t1);
        executorService.submit(t2);
        executorService.shutdown();
        //FIXME Junit 不支持多线程，主线程会提前结束，所以给主线程足够睡眠时间，以便线程执行完毕。
        sleep(1000);
    }

}
