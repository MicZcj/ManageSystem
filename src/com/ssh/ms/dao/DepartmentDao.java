package com.ssh.ms.dao;

import java.util.List;

import com.ssh.ms.po.Department;
import com.ssh.ms.po.Employee;

public interface DepartmentDao {

	int findCount();

	List<Department> findByPage(int begin, int pageSize);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

}
