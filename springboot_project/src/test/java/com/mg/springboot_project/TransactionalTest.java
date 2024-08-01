package com.mg.springboot_project;

import com.mg.springboot_project.dao.StudentMapper;
import com.mg.springboot_project.entity.Student;
import com.mg.springboot_project.service.impl.TransactionalService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author mg
 * @date 2023-06-30
 */
@SpringBootTest
public class TransactionalTest {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    TransactionalService transactionalService;

    @Autowired
    TransactionTemplate transactionTemplate;

    private static final Logger logger = LoggerFactory.getLogger(TransactionalTest.class);

    @Test
    @Transactional(propagation = Propagation.MANDATORY, rollbackFor = Throwable.class)
    public void run() {
        studentMapper.deleteByPrimaryKey(168L);
        Student student = studentMapper.selectByPrimaryKey(168L);
        transactionalService.saveStudent();
    }

    @Test
    @Transactional(rollbackFor = Throwable.class)
    public void run2() throws InterruptedException {
        studentMapper.deleteByPrimaryKey(168L);
        Thread.sleep(20000);
        studentMapper.insert(new Student(3L, "mc", 2));
    }

    /**
     * 只要方法A和方法B在同一个类中，那么A和B就在同一个事务中。A加了@Transaction注解，那么无论是不是在同一个类中，无论B加不加注解，AB都在同一个事务中。
     * <p>
     * A不加注解，B加了注解，如果AB在同一个类中，则事务失效；如果AB不同类，则只有B有事务。
     */
    @Test
    @Transactional(rollbackFor = Throwable.class)// 声明式事务
    public void run3() {
        studentMapper.deleteByPrimaryKey(168L);
        studentMapper.insert(new Student(3L, "mc", 2));
        update();
    }

    public void update() {
        studentMapper.updateByPrimaryKeySelective(new Student(97035L, "mc2", 6));
        int num = 1 / 0;
    }

    /**
     * 编程式事务(手动提交事务)
     */
    @Test
    public void run4() {
        studentMapper.deleteByPrimaryKey(168L);
        transactionTemplate.execute(transactionStatus -> {
            studentMapper.insert(new Student(3L, "mc", 2));
            //int num=1/0;
            myMethod();//有事物
            return Boolean.TRUE;
        });
        //myMethod();无事物
    }

    /**
     * 当前代码是否开启事物
     */
    public void myMethod() {
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            // 如果有活动的实际事务，执行相应逻辑
            logger.info("当前存在活动的实际事务。");
        } else {
            // 如果没有活动的实际事务，执行相应逻辑
            logger.info("当前不存在活动的实际事务。");
        }
    }

    /**
     * try-catch异常后设置事物手动回滚的两种方式
     * 必须是在@Transactional注解方法内
     * TransactionStatus直接标记回滚所在类必须被Spring管理（例如@Service）
     */
    @Test
    public void run5() {
        transactionalService.handSubmit();
    }

    /**
     * 通过代理对象调用同类中的另一个方法，使被调用方法的事物生效。
     */
    @Test
    public void run7() {
        transactionalService.show();
    }

}
