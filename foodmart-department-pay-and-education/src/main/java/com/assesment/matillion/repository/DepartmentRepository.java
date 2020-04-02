package com.assesment.matillion.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.assesment.matillion.entity.Department;

@Repository
public class DepartmentRepository extends AbstractRepository implements IDepartmentRepository {

	private static Logger log = LoggerFactory.getLogger(DepartmentRepository.class);
	
	@Override
	public List<Department> findAll() {

		List<Department> listDepartments = new ArrayList<>();
		
		try {

			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM department");
			
			while (rs.next()) {
				listDepartments.add(DepartmentResultSetMap.map(rs));
			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		
		return listDepartments;
	}
}
