package com.mg;

import redis.clients.jedis.Jedis;

/**
 * @author mg
 * @Date 2021-05-13
 * @Version 1.0
 */
public class RedisJavaTest {
	public static void main(String[] args){
		Jedis jedis=new Jedis("192.168.136.133", 6379);
		//在保护模式开启的状态下，需要填写密码；关闭则不用
		jedis.auth("magang");

		jedis.set("name", "mg");
		String value = jedis.get("name");
		jedis.close();
		System.out.println(value);
	}
}
