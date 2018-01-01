package com.ssh.ms.service.impl;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.ssh.ms.dao.EmployeeDao;
import com.ssh.ms.po.Employee;
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

	@Override
	public Employee login(Employee employee) {
		// TODO Auto-generated method stub
		Employee existEmployee = employeeDao.findByUsernameAnaPassword(employee);
		return existEmployee;
	}

}
