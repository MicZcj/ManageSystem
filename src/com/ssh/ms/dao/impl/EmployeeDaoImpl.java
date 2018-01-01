package com.ssh.ms.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.ssh.ms.dao.EmployeeDao;
import com.ssh.ms.po.Employee;

public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

	@Override
	public Employee findByUsernameAnaPassword(Employee employee) {
		String username = employee.getUsername();
		String password = employee.getPassword();
		String hql = "from Employee where username ='" + username + "' and password ='" + password + "'";
		List<Employee> list = (List<Employee>) this.getHibernateTemplate().find(hql);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
