package com.ssh.ms.service.impl;

import com.ssh.ms.service.DepartmentService;
import com.ssh.ms.dao.impl.DepartmentDaoImpl;

public class DepartmentServiceImpl implements DepartmentService {
	// service中注入dao
	private DepartmentDaoImpl departmentDaoImpl;

	public void setDepartmentDaoImpl(DepartmentDaoImpl departmentDaoImpl) {
		this.departmentDaoImpl = departmentDaoImpl;
	}

}
