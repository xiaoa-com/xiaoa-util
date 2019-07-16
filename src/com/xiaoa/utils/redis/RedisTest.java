package com.xiaoa.utils.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class RedisTest {
    @Test
    public void getJedisTest(){
        Jedis jedis = JedisPoolUtils.getJedis();

        jedis.set("name","meng");
        System.out.println(jedis);
        jedis.close();
        System.out.println(jedis);
    }
    @Test
    public void getJedisTest2(){
        Jedis jedis = JedisPoolUtils.getJedis();

        jedis.set("xing","wan");
        System.out.println(jedis);
        JedisPoolUtils.closeJedis(jedis);
        jedis.set("hh","22");
        System.out.println(jedis);
    }
}
