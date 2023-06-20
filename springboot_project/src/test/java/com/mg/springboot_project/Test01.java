package com.mg.springboot_project;

import com.mg.mgdemospringbootstarter.service.MgDemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author mg
 * @date 2023-06-19
 */
@SpringBootTest
public class Test01 {

    @Autowired
    MgDemoService mgDemoService;

    @Value("${mg.demo.name}")
    private String name;

    @Test
    public void run(){
        String message = mgDemoService.getAllMessage();
    }

    @Test
    public void run2(){
        System.out.println(name);
    }
}
