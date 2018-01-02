package com.ssh.ms.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.ms.po.Employee;
import com.ssh.ms.po.PageBean;
import com.ssh.ms.service.*;

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {
	// 模型驱动使用对象
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
		Employee existEmployee = employeeService.login(employee);
		if (existEmployee == null) {
			this.addActionError("用户名或密码错误！");
			return INPUT;
		} else {
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
	}

	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	// 分页查询员工的执行方法
	public String findAll() {
		PageBean<Employee> pageBean = employeeService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
}
