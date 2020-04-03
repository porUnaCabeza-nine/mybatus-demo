package com.demo.aboutThreadPool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: ljc
 * @createDate: 2019/12/3 14:30
 */
public class Test {

    public static void main(String[] args) {
        //开始时间
//        long start = System.currentTimeMillis();
//        CountDownLatch latch = new CountDownLatch(5);
//        for (int i =0;i<5;i++){
//            int finalI = i;
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("子线程在执行中"+ finalI);
//                    latch.countDown();//减少latch中的数值
//                }
//            }).start();
//        }
//        try {
//            latch.await();//阻塞当前线程知道latch中的值为0
//            System.out.println("主线程执行");
//            long endTime=System.currentTimeMillis(); //获取结束时间
//            System.out.println("所需时间:"+(endTime-start));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        ----------------------------------------------------
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                    System.out.println("子线程执行中:"+Thread.currentThread().getName() + "   i=" + temp);
                }
            });
        }
        try {
            countDownLatch.await();
            executorService.shutdown();
            System.out.println("子线程执行完毕");
            System.out.println("主线程开始");
            System.out.println("主线程到你了~");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }

    }


