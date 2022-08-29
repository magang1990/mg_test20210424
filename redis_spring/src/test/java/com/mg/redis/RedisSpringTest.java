package com.mg.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author mg
 * @Date 2021-05-14
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-redis.xml")
public class RedisSpringTest {

	@Autowired
	RedisTemplate redisTemplate;

	@Test
	public void content(){

		redisTemplate.opsForValue().set("age",18 );
		redisTemplate.opsForValue().set("age1","18" );
		int value = (int)redisTemplate.opsForValue().get("age");
		System.out.println(redisTemplate.opsForValue().get("age1"));
		System.out.println(value);
	}
}
