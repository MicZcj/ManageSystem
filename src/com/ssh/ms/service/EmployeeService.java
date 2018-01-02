package com.ssh.ms.service;

import com.ssh.ms.po.*;

public interface EmployeeService {
	Employee login(Employee employee);

	PageBean<Employee> findByPage(Integer currPage);

	void save(Employee employee);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);

}
