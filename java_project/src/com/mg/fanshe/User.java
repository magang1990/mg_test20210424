package com.mg.fanshe;

import java.util.Arrays;

/**
 * @author mg
 * @Date 2021-04-24
 * @Version 1.0
 */
public class User {

	private Long userId;
	private String userName;
	private Integer age;
	private String[] hobbies;

	public User() {

	}

	public User(Long userId, String userName, Integer age, String[] hobbies) {
		this.userId = userId;
		this.userName = userName;
		this.age = age;
		this.hobbies = hobbies;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

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

	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", userName='" + userName + '\'' +
				", age=" + age +
				", hobbies=" + Arrays.toString(hobbies) +
				'}';
	}


}
