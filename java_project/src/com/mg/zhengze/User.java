package com.mg.zhengze;

import java.io.Serializable;

/**
 * @author mg
 * @Date 2021-05-23
 * @Version 1.0
 */
public class User implements Serializable {

	private static final long serialVersionUID = -1915466832812550997L;

	private String userName;

	private Integer age;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
