package com.java.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class EmployeeDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Employee[] employees = new Employee[] {
			new Employee(1432, "Frank Brown", "625-345-2635", 45089.5),
			new Employee(1321, "John Doe", "625-345-3321", 56003.0),
			new Employee(1634, "Mary Jones", "625-345-3421", 73998.3) };

	private Employee activeEmployee;

	public Employee[] getEmployees() {
		return employees;
	}

	public Employee getActiveEmployee() {
		return activeEmployee;
	}

	public void setActiveEmployee(Employee employee) {
		this.activeEmployee = employee;
	}

	public String processNextPage() {
		return "next";
	}

	public String processPrevPage() {
		return "index";
	}
}
