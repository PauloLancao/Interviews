package com.assesment.matillion.repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.assesment.matillion.entity.Employee;

public final class EmployeeResultSetMap {

	public static Employee map(ResultSet rs) throws SQLException {
		Employee employee = new Employee();
		
		int id = rs.getInt("employee_id");
		String fullName = rs.getString("full_name");
		String firstName = rs.getString("first_name");
		String lastName = rs.getString("last_name");
		int positionId = rs.getInt("position_id");
		String positionTitle = rs.getString("position_title");
		int storeId = rs.getInt("store_id");
		int departmentId = rs.getInt("department_id");
		Date dob = rs.getDate("birth_date");
		Date hireDate = rs.getDate("hire_date");
		Date endDate = rs.getDate("end_date");
		BigDecimal salary = rs.getBigDecimal("salary");
		int supervisorId = rs.getInt("supervisor_id");
		String educationLevel = rs.getString("education_level");
		String maritalStatus = rs.getString("marital_status");
		String gender = rs.getString("gender");
		String managementRole = rs.getString("management_role");

		employee.setEmployeeId(id);
		employee.setFullName(fullName);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setPositionId(positionId);
		employee.setPositionTitle(positionTitle);
		employee.setStoreId(storeId);
		employee.setDepartmentId(departmentId);
		employee.setBirthDate(dob);
		employee.setHireDate(hireDate);
		employee.setEndDate(endDate);
		employee.setSalary(salary);
		employee.setSupervisorId(supervisorId);
		employee.setEducationLevel(educationLevel);
		employee.setMaritalStatus(maritalStatus);
		employee.setGender(gender);
		employee.setManagementRole(managementRole);
		
		return employee;
	}
}
