package com.demo.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by ${HeJD} on 2018/6/29.
 */
@Component
public class RedisUtil {
    /**
     * 日志记录
     */
    private static final Logger LOG = LoggerFactory.getLogger(RedisUtil.class);


    private static JedisPool jedisPool;


    private RedisUtil(){ };

    public  static JedisPool getInstance(){
        // 第一次检查instance是否被实例化出来，如果没有进入if块
        if(jedisPool == null) {
            synchronized (JedisPool.class) {
                // 某个线程取得了类锁，实例化对象前第二次检查instance是否已经被实例化出来，如果没有，才最终实例出对象
                if (jedisPool == null) {
                    jedisPool = new JedisPool();
                }
            }
        }
        return jedisPool;
    }


    public void setPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }
    /**
     * 获取jedis
     * @return
     */
    public Jedis getResource(){

        return jedisPool.getResource();
    }
    /**
     * 关闭连接
     * @param jedis
     */
    public void disconnect(Jedis jedis){
        jedisPool.close();
    }
    /**
     * 将jedis 返还连接池
     * @param jedis
     */
    public void returnResource(Jedis jedis){
        if(null != jedis){
            try {
                jedisPool.close();
            } catch (Exception e) {
                LOG.info("can't return jedis to jedisPool");
            }
        }
    }
    /**
     * 无法返还jedispool，释放jedis客户端对象，
     * @param jedis
     */
    public void brokenResource(RedisProperties.Jedis jedis){
        if (jedis!=null) {
            try {
                jedisPool.close();
            } catch (Exception e) {
                LOG.info("can't release jedis Object");
            }
        }
    }
}
