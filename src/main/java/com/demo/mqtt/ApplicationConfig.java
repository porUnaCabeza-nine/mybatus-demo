package com.demo.mqtt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

@Component
public class ApplicationConfig  implements ApplicationContextAware,
        InitializingBean, ServletContextAware, ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationConfig.class);



    @Value("${zvmng.mqtt.mqtt-host}")
    private String host;

    @Value("${zvmng.mqtt.cleanSession}")
    private boolean cleanSession;

    @Value("${zvmng.mqtt.keepAlive}")
    private short keepAlive;

    @Value("${zvmng.mqtt.uname}")
    private String uname;

    @Value("${zvmng.mqtt.pwd}")
    private String pwd;

    private static volatile boolean flag = false;

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("afterPropertiesSet start...");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("setApplicationContext start...");
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        logger.info("监听AP上报线程启动");
//        if (!flag) {
//            new Thread(new MqttImplRunnable(host,cleanSession,keepAlive,uname,pwd)).start();
//            //检测桌牌状态
//
//            //检测ap状态
//
//        }

    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        logger.info("setServletContext start...");
    }
}
