package com.design.structural.proxy;

public class EmployeeDaoProxy implements EmployeeDao {
	EmployeeDao dao;
	
	public EmployeeDaoProxy() {
		super();
		this.dao = new EmployeeDaoImpl();
	}

	@Override
	public void create(String client, EmployeeDto obj) throws Exception {
		if(client.equals("ADMIN")) {
			dao.create(client, obj);
			return;
		}	
		throw new Exception("Access Denied");
	}

	@Override
	public void delete(String client, int empID) throws Exception {
		if(client.equals("ADMIN")) {
			dao.delete(client, empID);
			return;
		}	
		throw new Exception("Access Denied");		
	}

	@Override
	public EmployeeDto get(String client, int empID) throws Exception {
		if(client.equals("ADMIN")|| client.equals("USER")) {
			return dao.get(client, empID);
		}	
		throw new Exception("Access Denied");		
	}

}
