package com.assesment.matillion.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.assesment.matillion.entity.Department;

public final class DepartmentResultSetMap {

	public static Department map(ResultSet rs) throws SQLException {
		Department department = new Department();
		
		int id = rs.getInt("department_id");
		String departmentDescription = rs.getString("department_description");
		
		department.setDepartmentId(id);
		department.setDepartmentDescription(departmentDescription);
		
		return department;
	}
}
