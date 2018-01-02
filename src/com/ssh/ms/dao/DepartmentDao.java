package com.ssh.ms.dao;

import java.util.List;

import com.ssh.ms.po.Department;

public interface DepartmentDao {

	int findCount();

	List<Department> findByPage(int begin, int pageSize);

}
