package com.demo.aboutThreadTaskPool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TranTest2Service {
    Logger log = LoggerFactory.getLogger(TranTest2Service.class);


    /*
    * @Async("taskExecutor") 对应我们自定义线程池中的 @Bean("taskExecutor") ，表示使用我们自定义的线程池。
    * */

    // 发送提醒短信 1
    @Async("taskExecutor")
    public void sendMessage1() throws InterruptedException {
        log.info("发送短信方法---- 1   执行开始");
//        Thread.sleep(5000); // 模拟耗时
        log.info("发送短信方法---- 1   执行结束");
    }

    // 发送提醒短信 2
    @Async("taskExecutor")
    public void sendMessage2() throws InterruptedException {

        log.info("发送短信方法---- 2   执行开始");
//        Thread.sleep(2000); // 模拟耗时
        log.info("发送短信方法---- 2   执行结束");
    }
}
