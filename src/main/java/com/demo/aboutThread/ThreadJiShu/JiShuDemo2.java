package com.demo.aboutThread.ThreadJiShu;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: ljc
 * @createDate: 2019/11/14 9:37
 */
public class JiShuDemo2 {



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
    private static AtomicInteger count = new AtomicInteger(0);
    public static void main(String[] args) {
        //线程计数器 （ 闭锁）
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        //定义一个线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        //Semaphore 可以阻塞进程 并且控制同时一时间的请求的并发量（控制同时的并发数）
        // ，与线程池一起使用
        //threadTotal 表示允许的并发数
        final Semaphore semaphore = new Semaphore(threadTotal);
        for (int i=0;i<clientTotal;i++) {
            //通过java8 的表达式 启动 线程
            exec.execute(()->{
                try {
                    //通过信号量判断是否继续执行线程
                    //若超出定义好的 允许的并发数量 则会阻塞线程
                    semaphore.acquire();
                    add();

                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            });
        }
        exec.shutdown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("最后的总数："+count);
    }
    private static void add(){
        //先执行增加操作 再获取当前值
        count.incrementAndGet();
        //先获取当前值 再执行增加操作
//        count.getAndIncrement();
//
    }
}
