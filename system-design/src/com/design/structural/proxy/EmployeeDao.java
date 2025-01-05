package com.design.structural.proxy;

public interface EmployeeDao {

	public void create(String client, EmployeeDto obj) throws Exception;

	public void delete(String client, int empID) throws Exception;

	public EmployeeDto get(String client, int empID) throws Exception;
}
