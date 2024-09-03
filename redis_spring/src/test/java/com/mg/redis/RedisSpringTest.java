package com.mg.redis;

import cn.hutool.json.JSONUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mg
 * @Date 2021-05-14
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-redis.xml")
public class RedisSpringTest {

	@Autowired
	RedisTemplate<String, Object> redisTemplate;

	@Test
	public void content(){

		/*redisTemplate.opsForValue().set("age",18 );
		redisTemplate.opsForValue().set("age1","18" );
		int value = (int)redisTemplate.opsForValue().get("age");
		System.out.println("value= "+value);
		int value1 = (int)redisTemplate.opsForValue().get("age1");
		System.out.println("value1= "+value1);*/

		User mg = new User("mg", 1);
		User ml = new User("ml", 2);
		List<User> list = new ArrayList<>();
		list.add(mg);
		list.add(ml);
		// 默认序列化key和value都是JdkSerializationRedisSerializer，存储的是含有类信息的字节数组
		// 所以redisTemplate存的不管是数字还是数字字符串，直接递增会报错。
		Long age = redisTemplate.opsForValue().increment("age");//ERR value is not an integer or out of range
		Long age1 = redisTemplate.opsForValue().increment("age1");//ERR value is not an integer or out of range
		//redisTemplate.opsForValue().set("user:object",mg);
		User mgRedis = (User)redisTemplate.opsForValue().get("user:object");
		//redisTemplate.opsForValue().set("user:list",list);
		List<User> listRedis = (List<User>)redisTemplate.opsForValue().get("user:list");
	}

	/**
	 * RedisTemplate常见的几种设置序列化器方式
	 * ①直接在业务代码调用redisTemplate.setKeySerializer()，设置key，不同类型value的序列化器
	 * ②在applicationContext-redis.xml文件中配置
	 * ③在RedisConfig配置类中，RedisTemplate的Bean配置中设置
	 */
	@Test
	public void run(){
		/*redisTemplate.opsForValue().set("age",18 );
		redisTemplate.opsForValue().set("age1","18" );*/
		Object age = redisTemplate.opsForValue().get("age");
		Object age1 = redisTemplate.opsForValue().get("age1");
		JdkSerializationRedisSerializer jdkSerializer = new JdkSerializationRedisSerializer();
		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
		/*ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(mapper);*/

		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
		redisTemplate.setKeySerializer(stringRedisSerializer);
		redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
		redisTemplate.setHashKeySerializer(stringRedisSerializer);
		redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
		/*redisTemplate.opsForValue().set("age2",19);
		redisTemplate.opsForValue().set("age3","19");//存储的是字符串"\"19\""*/
		Long age2 = redisTemplate.opsForValue().increment("age2");//20
		Long age3 = redisTemplate.opsForValue().increment("age3");//ERR value is not an integer or out of range

	}

	@Test
	public void run2(){
		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
		/*ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(mapper);*/
		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
		redisTemplate.setKeySerializer(stringRedisSerializer);
		redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);

		User mg = new User("mg", 1);
		User ml = new User("ml", 2);
		List<User> list = new ArrayList<>();
		list.add(mg);
		list.add(ml);
		//redisTemplate.opsForValue().set("user:object22",mg);
		//直接jackson2JsonRedisSerializer序列化存对象或者集合的时候，对象取值的时候出来的是LinkedHashMap，集合的是LinkedHashMap集合
		Object mgObject = redisTemplate.opsForValue().get("user:object22");
		User mgObject1 = (User) mgObject;////java.lang.ClassCastException: java.util.LinkedHashMap cannot be cast to
		//redisTemplate.opsForValue().set("user:list2",list);
		Object o = redisTemplate.opsForValue().get("user:list2");
		List<User> listRedis2 = (List<User>) o;
		List<User> listRedis22 = (List) o;
		//存复杂结构（对象，集合，数组），建议先转化为JSON字符串，再存储
		redisTemplate.opsForValue().set("user:object22:string", JSONUtil.toJsonStr(mg));
		Object mgString = redisTemplate.opsForValue().get("user:object22:string");
		User user = JSONUtil.toBean((String) mgString, User.class);

	}

}
