package com.ssh.ms.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.ms.po.Department;
import com.ssh.ms.po.Employee;
import com.ssh.ms.po.PageBean;
import com.ssh.ms.service.*;

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {
	// 模型驱动使用对象
	private Employee employee = new Employee();
	private EmployeeService employeeService;
	private DepartmentService departmentService;

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

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
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

	// 跳转到添加员工页面
	public String saveUI() {
		// 查询所有部门
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}

	// 执行添加员工方法
	public String save() {
		employeeService.save(employee);
		return "save";
	}

	// 编辑员工信息方法
	public String edit() {
		// 根据员工id查员工
		employee = employeeService.findById(employee.getEid());
		// 查询所有部门
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "edit";
	}

	// 执行修改员工信息方法
	public String update() {
		employeeService.update(employee);
		return "update";
	}

	// 删除员工
	public String delete() {
		employeeService.delete(employee);
		return "delete";
	}
}
