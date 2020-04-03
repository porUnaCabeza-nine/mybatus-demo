package com.demo.aboutThread.simpleThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThreadPool {
    public static void main(String[] s){
        /**
         * 创建了固定大小为五个工作线程的线程池。然后分配给线程池十
         * 个工作，因为线程池大小为五，它将启动五个工作线程先处理五个
         * 工作，其他的工作则处于等待状态，一旦有工作完成，空闲下来工
         * 作线程就会捡取等待队列里的其他工作进行执行。
         */
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);
        }
        executor.shutdown(); // This will make the executor accept no new threads and finish all existing threads in the queue
        while (!executor.isTerminated()) { // Wait until all threads are finish,and also you can use "
            // executor.awaitTermination();" to wait
        }
        System.out.println("Finished all threads");

    }
}
