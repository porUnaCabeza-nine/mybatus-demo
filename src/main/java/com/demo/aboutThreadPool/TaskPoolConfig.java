package com.demo.aboutThreadPool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 自定义一个线程池
 * EnableAsync表示开启异步
 */
@EnableAsync
@Configuration
public class TaskPoolConfig {


/**
 *   默认情况下，在创建了线程池后，线程池中的线程数为0，当有任务来之后，就会创建一个线程去执行任务，
 *	当线程池中的线程数目达到corePoolSize后，就会把到达的任务放到缓存队列当中；
 *  当队列满了，就继续创建线程，当线程数量大于等于maxPoolSize后，开始使用拒绝策略拒绝
 */
    /**
     * 声明一个线程池
     *
     * @return
     */
    @Bean("taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        核心线程数，默认为10
        executor.setCorePoolSize(10);
//        最大线程数 20
        executor.setMaxPoolSize(20);
//        队列最大长度
        executor.setQueueCapacity(1000);
//         线程池维护线程所允许的空闲时间
        executor.setKeepAliveSeconds(60);
//         线程池名前缀
        executor.setThreadNamePrefix("taskExecutor-");
//       完成任务自动关闭 , 默认为false--
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // 允许线程空闲时间（单位：默认为秒）
        executor.setAwaitTerminationSeconds(10);
        // 线程池对拒绝任务的处理策略
        // CallerRunsPolicy：由调用线程（提交任务的线程）处理该任务
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 初始化
        executor.initialize();
        return executor;
    }
}
