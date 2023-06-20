package com.mg.mgdemospringbootstarter.config;

import com.mg.mgdemospringbootstarter.service.MgDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author mg
 * @date 2023-06-19
 */
@Configuration
@EnableConfigurationProperties(DemoConfig.class)
public class DemoAutoConfiguration {

    @Autowired
    private DemoConfig demoConfig;

    @Bean
    public MgDemoService mgDemoService(){
        return new MgDemoService(demoConfig.getName(),demoConfig.getAge(),demoConfig.getPhone());
    }

}
