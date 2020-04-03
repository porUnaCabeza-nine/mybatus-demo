package com.demo.redis;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Map;

public class RedisCacheStorageImpl<V> implements RedisCacheStorage<String,V> {

    //日志记录
    private Logger log= LoggerFactory.getLogger(RedisCacheStorageImpl.class);

    JedisPool jedisPool = RedisUtil.getInstance();


    //直接存储，k-v 默认过期时间30分钟
    @Override
    public boolean set(String key, V value) {
        return set(key,value,1800);
    }

    /**
     * 在redis数据库中插入 key  和value 并且设置过期时间
     * @param key
     * @param value
     * @param exp 过期时间
     * @return
     */
    @Override
    public boolean set(String key, V value, int exp) {
        if(StringUtils.isEmpty(key)){
            System.out.println("**************key为空*******************");
        }
        Jedis jedis =jedisPool.getResource();
        try {

            //使用对象转换为Json格式插入redis
            String jsonValue = JSON.toJSONString(value);//将json对象转换为json字符串
            jedis.setex(key,1800,jsonValue);
            System.out.println("存储成功************30分钟有效**********************");
        }catch (Exception e){
            System.out.println("存储出异常啦**********************************");
        }finally {
            jedis.close();
        }
        return true;
    }

    @Override
    public String get(String key, Object object) {
        Jedis jedis =jedisPool.getResource();
        String str = "";
        try {
              str = jedis.get(key);

        }catch (Exception e){
            System.out.println("取值出异常啦**********************************");
        }finally {
            jedis.close();
        }
        return str;
    }

    @Override
    public boolean remove(String key) {
        return false;
    }

    @Override
    public boolean hset(String cacheKey, String key, V value) {
        return false;
    }

    @Override
    public V hget(String cacheKey, String key, Object object) {
        return null;
    }

    @Override
    public Map<String, V> hget(String cacheKey, Object object) {
        return null;
    }
}
