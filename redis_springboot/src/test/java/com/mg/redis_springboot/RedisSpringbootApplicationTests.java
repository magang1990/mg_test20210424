package com.mg.redis_springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class RedisSpringbootApplicationTests {

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	void contextLoads() {

		redisTemplate.opsForValue().set("name","mg" );
		String value = (String) redisTemplate.opsForValue().get("name");
		System.out.println(value);
		System.out.println(redisTemplate.opsForValue().get("name"));

		redisTemplate.expire("name",10 , TimeUnit.SECONDS );

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(redisTemplate.opsForValue().get("name"));
	}

}
