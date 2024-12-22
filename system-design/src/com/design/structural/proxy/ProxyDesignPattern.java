package com.design.structural.proxy;

public class ProxyDesignPattern {

	public static void main(String[] args) {
		try {
			EmployeeDao emp = new EmployeeDaoProxy();
//			emp.create("USER", new EmployeeDto());//access denied
			emp.create("ADMIN", new EmployeeDto());
			System.out.println("Operation successful");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
