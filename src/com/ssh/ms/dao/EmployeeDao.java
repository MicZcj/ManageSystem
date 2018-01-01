package com.ssh.ms.dao;

import java.util.List;

import com.ssh.ms.po.Employee;

public interface EmployeeDao {
	Employee findByUsernameAnaPassword(Employee employee);
}
