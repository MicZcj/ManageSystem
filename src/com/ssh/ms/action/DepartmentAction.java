package com.ssh.ms.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.ms.po.Department;
import com.ssh.ms.po.Employee;
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

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	// 查询所有部门信息页面
	public String findAll() {
		PageBean<Department> pageBean = departmentService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}

	// 跳转到添加部门
	public String saveUI() {
		return "saveUI";

	}

	// 添加部门
	public String save() {
		departmentService.save(department);
		return "save";
	}

	// 编辑部门
	public String edit() {
		department = departmentService.findById(department.getDid());
		return "edit";
	}
	//修改部门信息方法
	public String update() {
		departmentService.update(department);
		return "update";
	}

}
