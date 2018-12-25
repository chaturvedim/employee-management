package com.test.employee.model;

import java.util.Arrays;

import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Employee {

	private static int ID = 1;
	private final int id;
	private final String name;
	private final Department department;

	public Employee() {
		this.id = ID++;
		this.name = null;
		this.department = null;
	}

	public Employee(String name, Department department) {
		this.id = ID++;
		this.name = name;
		this.department = department;
	}

	public Employee(int id, String name, Department department) {
		this.id = id;
		this.name = name;
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Department getDepartment() {
		return department;
	}

	@Override
	public boolean equals(Object obj) {
		return obj != null && obj instanceof Employee && ((Employee) obj).getId() == id;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, Arrays.asList("name", "department"));
	}
}
