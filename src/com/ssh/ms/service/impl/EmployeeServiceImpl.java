package com.ssh.ms.service.impl;

import com.ssh.ms.dao.EmployeeDao;
import com.ssh.ms.service.EmployeeService;
/*
 * 员工管理业务层实现类
 */
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao employeeDao;

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
}
