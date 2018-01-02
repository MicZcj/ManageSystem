package com.ssh.ms.service.impl;

import com.ssh.ms.service.DepartmentService;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ssh.ms.dao.*;
import com.ssh.ms.po.Department;
import com.ssh.ms.po.Employee;
import com.ssh.ms.po.PageBean;

@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	// service中注入dao
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public PageBean<Department> findByPage(Integer currPage) {
		PageBean<Department> pageBean = new PageBean<Department>();
		pageBean.setCurrPage(currPage);// 当前页
		int pageSize = 3;// 每页显示多少条
		pageBean.setPageSize(pageSize);
		int totalCount = departmentDao.findCount();// 总记录数
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());// 总页数
		int begin = (currPage - 1) * pageSize;
		List<Department> list = departmentDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public void save(Department department) {
		departmentDao.save(department);

	}

}
