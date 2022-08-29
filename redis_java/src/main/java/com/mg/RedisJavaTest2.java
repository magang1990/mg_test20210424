package com.mg;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author mg
 * @Date 2021-05-13
 * @Version 1.0
 */
public class RedisJavaTest2 {
	public static void main(String[] args){
		JedisPoolConfig config=new JedisPoolConfig();
		config.setMaxWaitMillis(1000);
		config.setMaxIdle(50);
		config.setMaxTotal(100);

		JedisPool pool=new JedisPool(config,"192.168.136.133", 6379,1000,"magang");
		Jedis jedis = pool.getResource();

		int i=1;
		long begin = System.currentTimeMillis();
		while (true){
			long end = System.currentTimeMillis();
			if (end-begin >=1000) {
				break;
			}
			jedis.set("name"+i,"mg" +i);
			i++;
		}
		System.out.println("1秒钟内Redis做了"+i+"次写操作");

		jedis.close();



	}
}
