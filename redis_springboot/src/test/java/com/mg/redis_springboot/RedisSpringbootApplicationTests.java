package com.mg.redis_springboot;

import cn.hutool.core.util.BooleanUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class RedisSpringbootApplicationTests {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Test
	void contextLoads() {

		redisTemplate.opsForValue().set("name","mg" );
		redisTemplate.opsForValue().set("age","31" );
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

	@Test
	void evalLua() {
		String key = "redis:lock";
		String uuid = UUID.randomUUID().toString().replace("-", "");
		//设置分布式锁
		Boolean absent = redisTemplate.opsForValue().setIfAbsent(key, uuid, 180, TimeUnit.SECONDS);
		if (BooleanUtil.isTrue(absent)) {
			System.out.println("该线程获取到分布式锁");

			try {
				//业务代码...
			} finally {
				// 删除分布式锁lua脚本
				String script="if redis.call('get', KEYS[1]) == ARGV[1] then\n" +
						"    return redis.call('del', KEYS[1])\n" +
						"else\n" +
						"    return 0\n" +
						"end";
				//RedisScript<Boolean> redisScript = RedisScript.of(script, Boolean.class);
				RedisScript<Boolean> redisScript = RedisScript.of(new ClassPathResource("lua/redis_lock.lua"), Boolean.class);
				List<String> keyList = Collections.singletonList(key);
				//删除分布式锁
				Boolean execute = redisTemplate.execute(redisScript, keyList, uuid);
				if (BooleanUtil.isTrue(execute)) {
					System.out.println("已删除当前线程分布式锁");
				} else {
					System.out.println("当前线程分布式锁不存在");
				}
			}
		}

	}

}
