package com.assesment.matillion.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.assesment.matillion.entity.Department;

@Repository
public class DepartmentTemplateRepository extends AbstractRepository implements IDepartmentRepository {

	@Override
	public List<Department> findAll() {

		return jdbcTemplate.query(
                "select * from department",
                (rs, rowNum) -> DepartmentResultSetMap.map(rs)
        );
	}
}
