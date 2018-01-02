package com.ssh.ms.dao;

import java.util.List;

import com.ssh.ms.po.Employee;

public interface EmployeeDao {
	Employee findByUsernameAnaPassword(Employee employee);

	Integer findCount();

	List<Employee> findByPage(Integer begin, Integer pageSize);

	void save(Employee employee);
}
