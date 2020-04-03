package com.demo.aboutThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class fixedThread {

    public static void main(String[] str){

        //创建一个固定大小的线程池，任务超过10个时，会将线程放入等待队列中。初始化一个指定线程数的线程池，
        // 其中 corePoolSize ==   maxiPoolSize，使用 LinkedBlockingQuene 作为任务队列。
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        for(int i = 0; i < 10; i++) {
//            //线程池开启后直接创建了10个线程，一起等待1000ms之后同时执行。
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        Thread.currentThread().sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("...");
//                }
//            });
//        }
//        //关闭状态，线程池不接收新任务，但是会处理队列中的任务。
//        executorService.shutdown();

        /**
         * 创建一个单例线程池，线程池中只有一个线程，初始化只有一个线程的线程池，
         *内部使用 LinkedBlockingQueue作为任务队列。特点：如果该线程异常结束，
         * 会重新创建一个新的线程继续执行任务，唯一的线程可以保证所提交任务的
         * 顺序执行。
         */
        ExecutorService executorServiceSingle = Executors.newSingleThreadExecutor();

            executorServiceSingle.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("...");
                }
            });

        executorServiceSingle.shutdown();



        //任务调度的线程池
        //10表示延迟10s开始任务调度，3表示调度之间间隔3s
        ScheduledExecutorService sch = Executors.newScheduledThreadPool(10);
        sch.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("...");
            }
        }, 10, 3, TimeUnit.SECONDS);
        sch.shutdown();
    }

    /**
     * 创建一个缓存线程池，初始化一个可以缓存线程的线程池，默认缓存60s，线程池的线程数可达到
     * Integer.MAX_VALUE，即2147483647，内部使用 SynchronousQueue 作为任务队列。
     * 特点：在没有任务执行时，当线程的空闲时间超过 keepAliveTime，会自动释放线程资源。当提交新任务时，
     * 如果没有空闲线程，则创线程执行任务，会导致一定的系统开销，
     * 因此，使用时要注意控制并发的任务数，防止因创建大量的线程导致而降低性能。
     */
    ExecutorService executorService = Executors.newCachedThreadPool();


}
