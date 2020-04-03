package com.demo.aboutThread.threadPolDemo;

import java.util.concurrent.*;

public class threadpoolVariousDemo {

    ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    //newCachedThreadPool 创建一个可缓存线程池，如果线程池长度超过处理需要，
    // 可灵活回收空闲线程，若无可回收，则新建线程
    public void createCachedThreadPool(){
        for(int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            cachedThreadPool.execute(new Runnable() {

                @Override
                public void run() {
                    System.out.println(index);
                }
            });
        }
    }

    public static void  main(String[] s) throws InterruptedException, ExecutionException {
//        threadpoolVariousDemo th = new threadpoolVariousDemo();
//        th.createCachedThreadPool();

        final ExecutorService exec = Executors.newFixedThreadPool(5);
        Callable<String> call = new Callable<String>() {
            public String call() throws Exception {
                Thread.sleep(1000 * 3);//休眠指定的时间，此处表示该操作比较耗时
                return "Other less important but longtime things.";
            }
        };
        Future<String> task = exec.submit(call);
        //重要的事情
        Thread.sleep(1000 * 3);
        System.out.println("Let's do important things.");
        //不重要的事情
        String obj = task.get();
        System.out.println(obj);
        //关闭线程池
        exec.shutdown();


    }
}
