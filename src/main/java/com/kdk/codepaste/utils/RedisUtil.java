package com.kdk.codepaste.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class RedisUtil {
    @Autowired
    private JedisPool jedisPool;

    /**
     * 返还到连接池
     *
     * @param jedisPool
     * @param jedis
     */
    public static void returnResource(JedisPool jedisPool, Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

    public String set(String key, String value,int indexdb) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(indexdb);
            return jedis.set(key, value);
        } catch (Exception e) {
            System.out.println(e.getMessage());
//            log.error(e.getMessage());
            return "0";
        } finally {
            returnResource(jedisPool, jedis);
        }
    }
    /**
     * 通过key获取储存在redis中的value
     * 并释放连接
     *
     * @param key
     * @param indexdb 选择redis库 0-15
     * @return 成功返回value 失败返回null
     */
    public String get(String key,int indexdb) {
        Jedis jedis = null;
        String value = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(indexdb);
            value = jedis.get(key);
//            log.info(value);
        } catch (Exception e) {
            System.out.println(e.getMessage());
//            log.error(e.getMessage());
        } finally {
            returnResource(jedisPool, jedis);
        }
        return value;
    }

    /**
     * 通过key判断redis中是否有该key
     * 并释放连接
     * @param key
     * @param indexdb 选择redis库 0-15
     * @return 成功返回value 失败返回null
     */
    public boolean exists(String key,int indexdb) {
        Jedis jedis = null;
        boolean exist = false;
        try {
            jedis = jedisPool.getResource();
            jedis.select(indexdb);
            exist = jedis.exists(key);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            returnResource(jedisPool, jedis);
        }
        return exist;
    }
}
