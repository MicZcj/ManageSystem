package com.ssh.ms.service;

import com.ssh.ms.po.Department;
import com.ssh.ms.po.Employee;
import com.ssh.ms.po.PageBean;

public interface DepartmentService {

	PageBean<Department> findByPage(Integer currPage);

	void save(Department department);
	
}
