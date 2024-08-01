package com.mg.springboot_project.service.impl;

import com.mg.springboot_project.dao.StudentMapper;
import com.mg.springboot_project.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * @author mg
 * @date 2023-06-30
 */
@Slf4j
@Service
public class TransactionalService {

    @Autowired
    StudentMapper studentMapper;

    @Transactional(rollbackFor = Throwable.class)
    public void saveStudent() {
        studentMapper.insert(new Student(3L, "mc", 2));
        int i = 1 / 0;
    }

    @Transactional(rollbackFor = Throwable.class)
    public void save1(Long id) {
        //studentMapper.deleteByPrimaryKey(id);
        int num = studentMapper.deleteByPrimaryKey(id);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*if (num==0) {
            throw new RuntimeException("请重新刷新");
        }*/
        studentMapper.insertSelective(new Student("mc", 2));
    }

    /**
     * try-catch异常后设置事物手动回滚的两种方式
     * 必须是在@Transactional注解方法内
     * TransactionStatus直接标记回滚所在类必须被Spring管理（例如@Service）
     */
    @Transactional(rollbackFor = Throwable.class)// 声明式事务
    public void handSubmit() {
        try {
            studentMapper.deleteByPrimaryKey(168L);
            studentMapper.insert(new Student(3L, "mc", 2));
            int num = 1 / 0;
        } catch (Exception e) {
            log.info("handSubmit()发生异常", e);
            // 方法一，直接throw 可以回滚的异常对象
            //throw new RuntimeException(e);
            // 方法二，TransactionStatus直接标记回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }

    }

    /**
     * 通过代理对象调用同类中的另一个方法，使被调用方法的事物生效。
     */
    public void show() {
        //handSubmit();//handSubmit()方法的事物不生效
        TransactionalService proxy = (TransactionalService) AopContext.currentProxy();//获取代理对象
        proxy.handSubmit();
    }

}
