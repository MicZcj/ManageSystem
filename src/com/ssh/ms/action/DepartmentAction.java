package com.ssh.ms.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.ms.po.Department;
import com.ssh.ms.po.PageBean;
import com.ssh.ms.service.DepartmentService;

public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {
	private Department department = new Department();
	// Action中注入Service
	private DepartmentService departmentService;

	@Override
	public Department getModel() {
		return department;
	}

	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	public String findAll() {
		PageBean<Department> pageBean = departmentService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

}
