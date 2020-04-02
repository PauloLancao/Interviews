package com.assesment.matillion.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.assesment.matillion.entity.Department;

@ExtendWith(MockitoExtension.class)
public class DepartmentResultSetMapTest {

	@Test
	public void mapTest() throws SQLException {
		
		// arrange
		ResultSet resultSetMock = Mockito.mock(ResultSet.class);
		Mockito.when(resultSetMock.getInt("department_id")).thenReturn(132);
		Mockito.when(resultSetMock.getString("department_description")).thenReturn("HQ Marketing");
						
		// act
		Department department = DepartmentResultSetMap.map(resultSetMock);
		
		// assert
		assertEquals(132, department.getDepartmentId());
		assertEquals("HQ Marketing", department.getDepartmentDescription());
	}
}
