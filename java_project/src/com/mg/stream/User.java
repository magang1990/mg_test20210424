package com.mg.stream;

/**
 * @author mg
 * @Date 2021-08-29
 * @Version 1.0
 */
public class User {
	private String name;
	private Integer age;
	private Integer salary;

	public User() {

	}

	public User(String name, Integer age, Integer salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", age=" + age +
				", salary=" + salary +
				'}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
		result = prime * result + ((getSalary() == null) ? 0 : getSalary().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		User user = (User) obj;
		return (this.getName() == null ? user.getName() == null : this.getName().equals(user.getName()))
				&& (this.getAge() == null ? user.getAge() == null : this.getAge().equals(user.getAge()))
				&& (this.getSalary() == null ? user.getSalary() == null : this.getSalary().equals(user.getSalary()));
	}

}
