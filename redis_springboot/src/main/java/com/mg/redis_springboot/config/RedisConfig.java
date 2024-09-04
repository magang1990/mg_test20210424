package com.mg.redis_springboot.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @name: RedisConfig
 * @description:
 * @author: dawei.pei
 * @date: 2021/8/24 16:07
 * @version: v1.0
 **/
@Configuration
public class RedisConfig {

    /*@Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port.default:6379}")
    private int port;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.timeout:30000}")
    private int timeout;
    @Value("${spring.redis.database.default:0}")
    private int database;
    @Value("${spring.redis.ssl: false}")
    private Boolean redisSsl;

    @Primary
    @Bean
    public JedisConnectionFactory peJedisConnectionFactory() {
        JedisPoolConfig config = new JedisPoolConfig();
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(config);
        jedisConnectionFactory.setDatabase(this.database);
        jedisConnectionFactory.setHostName(this.host);
        jedisConnectionFactory.setPassword(this.password);
        jedisConnectionFactory.setPort(this.port);
        jedisConnectionFactory.setTimeout(this.timeout);
        jedisConnectionFactory.setUseSsl(redisSsl);
        return jedisConnectionFactory;
    }*/

    //使用默认的Redis连接则可以不用设置
    //LettuceConnectionFactory：适合需要高并发、异步操作和响应式编程的应用，性能更好，线程安全。SpringBoot默认客户端。
    //JedisConnectionFactory：适合简单的同步操作场景，通常需要管理连接池以提高性能。
    /*@Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port.default:6379}")
    private int port;
    @Value("${spring.redis.password}")
    private String password;

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName(host);
        config.setPort(port);
        config.setPassword(password);
        return new LettuceConnectionFactory(config);
    }*/

    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        // 使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值（默认使用JDK的序列化方式）
        Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        serializer.setObjectMapper(mapper);
        /*JedisConnectionFactory jedisConnectionFactory = peJedisConnectionFactory();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);*/
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setValueSerializer(serializer);
        redisTemplate.setHashValueSerializer(serializer);
        //使用StringRedisSerializer来序列化和反序列化redis的key值
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

}
