package com.xiaoa.utils.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * JedisPool工具类
 * 加载配置文件，配置连接池的参数
 * 提供获取连接的方法
 */
public class JedisPoolUtils {
    private static JedisPool jedisPool;

    static {
        //读取配置文件
        InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        //创建Properties对象
        Properties pro = new Properties();
        //关联文件
        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取数据，设置到JedisPoolConfig中
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(pro.getProperty("redis.pool.maxTotal")));
        config.setMaxIdle(Integer.parseInt(pro.getProperty("redis.pool.maxIdle")));

        //初始化JedisPool
        jedisPool = new JedisPool(config, pro.getProperty("redis.ip"), Integer.parseInt(pro.getProperty("redis.port")));
    }

    /**
     * 获取连接方法
     */
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    /**
     * 关闭资源
     *
     * @param jedis
     */
    public static void closeJedis(Jedis jedis) {
        if (null != jedis) {
            jedis.close();
        }
    }

}
