package com.assesment.matillion.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.assesment.matillion.entity.Employee;

@ExtendWith(MockitoExtension.class)
public class EmployeeResultSetMapTest {

	@Test
	public void mapTest() throws SQLException {
		
		// arrange
		LocalDate date = LocalDate.parse("1942-06-01");
		LocalDateTime localDateTime = LocalDateTime.parse("1998-01-01T00:00:00");
		
		ResultSet resultSetMock = Mockito.mock(ResultSet.class);
		Mockito.when(resultSetMock.getInt("employee_id")).thenReturn(132);
		Mockito.when(resultSetMock.getString("full_name")).thenReturn("Amir Oss");
		Mockito.when(resultSetMock.getString("first_name")).thenReturn("Amir");
		Mockito.when(resultSetMock.getDate("birth_date")).thenReturn(Date.valueOf(date));
		Mockito.when(resultSetMock.getDate("hire_date")).thenReturn(Date.valueOf(localDateTime.toLocalDate()));
		Mockito.when(resultSetMock.getBigDecimal("salary")).thenReturn(BigDecimal.valueOf(9000.0000));
						
		// act
		Employee employee = EmployeeResultSetMap.map(resultSetMock);
		
		// assert
		assertEquals(132, employee.getEmployeeId());
		assertEquals("Amir Oss", employee.getFullName());
		assertEquals("Amir", employee.getFirstName());
		assertEquals(Date.valueOf(date), employee.getBirthDate());
		assertEquals(Date.valueOf(localDateTime.toLocalDate()), employee.getHireDate());
		assertEquals(BigDecimal.valueOf(9000.0000), employee.getSalary());
	}
}
