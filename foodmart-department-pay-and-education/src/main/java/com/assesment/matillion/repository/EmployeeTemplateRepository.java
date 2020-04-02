package com.assesment.matillion.repository;

import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Repository;

import com.assesment.matillion.entity.Employee;
import com.assesment.matillion.entity.EmployeeDepartmentPosition;

@Repository
public class EmployeeTemplateRepository extends AbstractRepository implements IEmployeeRepository {

	@Override
	public List<Employee> findAll() {

		return jdbcTemplate.query(
                "select * from employee",
                (rs, rowNum) -> EmployeeResultSetMap.map(rs)
        );
	}

	@Override
	public List<EmployeeDepartmentPosition> findAllByEducationLevelPayTypeDepartment(String educationLevel, String payType,
			String department) {
		throw new NotImplementedException("Not implemented exception");
	}
}
