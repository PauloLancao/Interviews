package com.assesment.matillion.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractRepository {
	
	@Autowired
	DatabaseConfig databaseConfig;

    @Autowired
    JdbcTemplate jdbcTemplate;
	
	public Connection getConnection() {
		try {
			// Register JDBC driver
		    Class.forName(databaseConfig.getClassname());
			
			return DriverManager.getConnection(
					databaseConfig.getUrl(), 
					databaseConfig.getUsername(),
					databaseConfig.getPassword());

		} catch (SQLException ex) {
			throw new RuntimeException("Error connecting to the database", ex);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Error connecting to the database", e);
		}
	}
}
