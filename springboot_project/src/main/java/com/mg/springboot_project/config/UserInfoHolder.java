package com.mg.springboot_project.config;

import com.mg.springboot_project.entity.UserInfo;

/**
 * 解决ThreadLocal主子异步线程间数据不传递问题
 * 1、手动设置。直接传参给子线程。
 * 2、线程池设置TaskDecorator（推荐）
 * 3、InheritableThreadLocal。线程池使用会有复用问题
 * （可继承的线程变量只是在线程被创建的时候进行了初始化工作，后续线程池线程不会取父线程的值。
 * 这也就能解释为什么在线程池中发生线程复用时不能获取到父线程线程变量的原因）
 * 4、TransmittableThreadLocal（推荐）
 *
 * @author mg
 * @date 2024-08-08
 */
public class UserInfoHolder {

    private static final ThreadLocal<UserInfo> USER_HOLDER = new ThreadLocal<>();
//    private static final ThreadLocal<UserInfo> USER_HOLDER = new InheritableThreadLocal<>();

    private UserInfoHolder() {
    }

    public static void addUserInfo(UserInfo userInfo) {
        USER_HOLDER.set(userInfo);
    }

    public static UserInfo getCurrentUser() {
        return USER_HOLDER.get();
    }

    public static void remove() {
        USER_HOLDER.remove();
    }

}
