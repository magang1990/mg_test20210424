package com.mg.springboot_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootApplication
public class SpringbootProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootProjectApplication.class, args);
	}

}
