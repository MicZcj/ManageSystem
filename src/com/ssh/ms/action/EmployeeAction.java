package com.ssh.ms.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.ms.po.Employee;
import com.ssh.ms.service.EmployeeService;

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {
	//模型驱动使用对象
	private Employee employee = new Employee();
	private EmployeeService employeeService;

	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public String login() {
		System.out.println("login执行了！");
		return NONE;
	}

}
