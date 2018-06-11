package com.sasagavric.model;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "users", type="users", shards =1)
public class User {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String department;
	private Double salary;
	
	public User() {
		
	}

	public User(Long id, String firstName, String lastName, String department, Double salary) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	
	
	

}
