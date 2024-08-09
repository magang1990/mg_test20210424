package com.mg.springboot_project.config;

import com.mg.springboot_project.interceptor.UserInfoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * MVC配置类
 *
 * @author mg
 * @date 2024-08-08
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Bean
    public UserInfoInterceptor userInfoInterceptor() {
        return new UserInfoInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 用户信息拦截器
        registry.addInterceptor(userInfoInterceptor()).addPathPatterns("/**").excludePathPatterns("/user/login",
            "/user/login/out", "/user/send/logmessage");
    }
}
