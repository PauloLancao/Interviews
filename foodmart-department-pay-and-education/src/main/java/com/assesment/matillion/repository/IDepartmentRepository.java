package com.assesment.matillion.repository;

import java.util.List;

import com.assesment.matillion.entity.Department;

public interface IDepartmentRepository {
	List<Department> findAll();
}
