package com.mg.fanshe;

import java.lang.reflect.Field;

/**
 * @author mg
 * @Date 2021-04-25
 * @Version 1.0
 * 反射的实现形式
 */
public class Reflection {
	public static void main(String[] args) throws Exception {
		//方法一
		Class<User> userClass = User.class;
		//方法二
		Class<? extends Class> getUserClass = userClass.getClass();
		//方法三,推荐用
		Class<?> forUserClass =null;
		try {
			forUserClass = Class.forName("com.mg.fanshe.User");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		User user = userClass.newInstance();
		System.out.println(user);
		System.out.println(userClass);
		Long userId = user.getUserId();
		System.out.println(userId);

		/*Field age = userClass.getDeclaredField("age");
		Field userName = userClass.getField("userName");
		System.out.println(age);
		System.out.println(userName);*/
		Field age2 = userClass.getDeclaredField("age");
		System.out.println(age2);


	}
}
