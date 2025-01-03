package com.mg.springboot_project.controller;

import com.mg.mgdemospringbootstarter.service.MgDemoService;
import com.mg.springboot_project.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mg
 * @date 2023-06-19
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    MgDemoService mgDemoService;

    @Autowired
    private TestService testService;

    @GetMapping("str")
    public String getString(){
        return mgDemoService.getAllMessage();
    }

    @GetMapping("/thread/local")
    public String getThread(){
        return testService.getThreadLocal();
    }
}
