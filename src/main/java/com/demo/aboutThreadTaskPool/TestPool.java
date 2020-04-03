package com.demo.aboutThreadTaskPool;


import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 单元测试
 */
@Slf4j
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TestPool {

    @Autowired
    private OrderTaskServic orderTaskServic;

    @Test
    public void testRunTaskOne() {
        log.info("================= run_task_one =======================");
        log.info("开始请求任务1");
        // 创建自动start的计时器
        Stopwatch sw = Stopwatch.createStarted();
        try {

            for (int i = 0;i<5;i++) {
                orderTaskServic.orderTask();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("完成请求任务1, 耗时：{}", sw.stop());

    }


}
