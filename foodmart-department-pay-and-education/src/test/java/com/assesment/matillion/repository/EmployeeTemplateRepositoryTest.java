package com.assesment.matillion.repository;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.assesment.matillion.entity.Employee;

@ExtendWith(SpringExtension.class)
public class EmployeeTemplateRepositoryTest extends AbstractRepositoryTest {

	@InjectMocks
	private EmployeeTemplateRepository employeeTemplateRepository;
	
	@Spy
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void findAllTest() {
		// arrange
		jdbcTemplate.setDataSource(dataSource());
		
		// act
		List<Employee> listEmployees = employeeTemplateRepository.findAll();
		
		// assert
		assertNotNull(listEmployees);
		assertThat(listEmployees, not(IsEmptyCollection.empty()));
	}
	
	@Test
	public void findAllByEducationLevelPayTypeDepartmentTest() {
		String educationLevel = "Graduate Degree";
		String payType = "Monthly";
		String department = "Store Information Systems";
		
		// act
		Assertions.assertThrows(NotImplementedException.class, () -> {
			employeeTemplateRepository.findAllByEducationLevelPayTypeDepartment(educationLevel, payType, department);
		});
	}
}
