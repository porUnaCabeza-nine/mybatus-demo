package com.demo.aboutThread.ThreadJiShu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: ljc
 * @createDate: 2019/11/14 9:37
 */
public class JiShuDemo {



    /**
     * @Description： 当只有一个线程去执行加一的操作时，最终的结果都是等于总数5000
     *                但是，若是两个及以上的线程 同时执行加一操作，那么最终的结果只能是 小于5000
     *                关于线程并发的 一个计数 demo
     * @Author ljc
     * @Date  2019/11/14 9:43
     **/




    //线程总数
    private static          int           threadTotal = 200;
    //总数
    private static          int           clientTotal = 5000;
    private static volatile AtomicInteger count = new AtomicInteger(0);
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        for (int i=0;i<clientTotal;i++) {
            exec.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        exec.shutdown();
        System.out.println("最后的总数："+count);
    }
    private synchronized static void add(){
        count.incrementAndGet();
    }
}
