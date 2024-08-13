package com.mg.springboot_project.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @ConfigurationProperties实现多数据配置两种使用方式
 *
 * 1.@ConfigurationProperties单独使用的时候，需要在启动类或者其他类（含有@Component注解）加上@EnableConfigurationProperties(TestConfig.class)
 * 2.@ConfigurationProperties直接和@Component一起使用
 *
 *
 *
 * @author mg
 * @date 2024-08-09
 */
@Data
@Component
@ConfigurationProperties(prefix = "test")
public class TestConfig {

    private String username;
    private Integer age;
    private List<String> hobby;
    private Map<String,String> great;
    private Map<String,String> great3;

}
