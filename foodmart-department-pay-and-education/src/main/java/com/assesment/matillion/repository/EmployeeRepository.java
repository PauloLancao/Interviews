package com.assesment.matillion.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.assesment.matillion.entity.Employee;
import com.assesment.matillion.entity.EmployeeDepartmentPosition;

@Repository
public class EmployeeRepository extends AbstractRepository implements IEmployeeRepository {

	private static Logger log = LoggerFactory.getLogger(EmployeeRepository.class);
	
	@Override
	public List<Employee> findAll() {

		List<Employee> listEmployees = new ArrayList<>();

		try {

			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
			
			while (rs.next()) {
				listEmployees.add(EmployeeResultSetMap.map(rs));
			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			log.error(e.getMessage());
		}

		return listEmployees;
	}

	@Override
	public List<EmployeeDepartmentPosition> findAllByEducationLevelPayTypeDepartment(String educationLevel, String payType,
			String department) {
		
		List<EmployeeDepartmentPosition> listEmployees = new ArrayList<>();

		try {

			Connection conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement("select * \n" + 
					"from \n" + 
					"(SELECT * \n" + 
					"FROM employee \n" + 
					"where education_level = ?) q1 \n" + 
					"inner join \n" + 
					"(SELECT * \n" + 
					"FROM position \n" + 
					"where pay_type = ?) q2 \n" + 
					"on q1.position_id = q2.position_id \n" + 
					"inner join \n" + 
					"(SELECT * \n" + 
					"FROM department \n" + 
					"where department_description = ?) q3 \n" + 
					"on q1.department_id = q3.department_id");
			
			stmt.setString(1, educationLevel);
			stmt.setString(2, payType);
			stmt.setString(3, department);
			
			ResultSet rs = stmt.executeQuery();
			EmployeeDepartmentPosition employeeDepartmentPosition;
			
			while (rs.next()) {
				employeeDepartmentPosition = new EmployeeDepartmentPosition();
				
				employeeDepartmentPosition.setEmployee(EmployeeResultSetMap.map(rs));
				employeeDepartmentPosition.setDepartment(DepartmentResultSetMap.map(rs));
				employeeDepartmentPosition.setPosition(PositionResultSetMap.map(rs));
				
				listEmployees.add(employeeDepartmentPosition);
			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			log.error(e.getMessage());
		}

		return listEmployees;
	}
}
