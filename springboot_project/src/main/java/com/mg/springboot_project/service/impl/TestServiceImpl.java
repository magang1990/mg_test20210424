package com.mg.springboot_project.service.impl;

import com.mg.springboot_project.config.UserInfoHolder;
import com.mg.springboot_project.entity.UserInfo;
import com.mg.springboot_project.service.TestService;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author mg
 * @date 2024-08-08
 */
@Service
//@EnableConfigurationProperties(TestConfig.class)
public class TestServiceImpl implements TestService {

    @Override
    public String getThreadLocal() {
        UserInfo currentUser = UserInfoHolder.getCurrentUser();

        /*Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //匿名内部类子线程
                UserInfo currentUser2 = UserInfoHolder.getCurrentUser();
            }
        };
        Thread thread = new Thread(runnable);*/
        Thread thread = new Thread(()->{
            //lambda表达式子线程
            UserInfo currentUser2 = UserInfoHolder.getCurrentUser();
            UserInfo currentUser3 = currentUser;
        },"子线程");
        thread.start();

        Thread thread2 = new Thread(()->{
            //lambda表达式子线程
            UserInfo currentUser3 = UserInfoHolder.getCurrentUser();
        },"子线程");
        thread2.start();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                4,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(200),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor.execute(()->{
            //lambda表达式子线程
            UserInfo currentUser4 = UserInfoHolder.getCurrentUser();
            UserInfo currentUser5 = UserInfoHolder.getCurrentUser();
            currentUser5.setName("mg2");
            UserInfoHolder.addUserInfo(currentUser5);
        });

        threadPoolExecutor.execute(()->{
            //lambda表达式子线程
            UserInfo currentUser6 = UserInfoHolder.getCurrentUser();
            currentUser6.setName("mg3");
            UserInfoHolder.addUserInfo(currentUser6);
        });


        return "牛掰";
    }
}
