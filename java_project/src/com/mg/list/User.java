package com.mg.list;

/**
 * @author mg
 * @Date 2021-08-08
 * @Version 1.0
 */
public class User {
	private String userName;
	private Integer userAge;

	public User() {

	}

	public User(String userName, Integer userAge) {
		this.userName = userName;
		this.userAge = userAge;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}
}
