package com.design.structural.proxy;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public void create(String client, EmployeeDto obj) throws Exception {
		System.out.println("create new Employee row");
	}

	@Override
	public void delete(String client, int empID) throws Exception {
		System.out.println("Delete employee row in table");
	}

	@Override
	public EmployeeDto get(String client, int empID) throws Exception {
		System.out.println("fetching row from db");
		return new EmployeeDto();
	}

}
