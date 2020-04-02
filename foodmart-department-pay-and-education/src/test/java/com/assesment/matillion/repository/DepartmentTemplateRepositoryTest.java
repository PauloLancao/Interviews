package com.assesment.matillion.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.assesment.matillion.entity.Department;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(SpringExtension.class)
public class DepartmentTemplateRepositoryTest extends AbstractRepositoryTest {

	@InjectMocks
	private DepartmentTemplateRepository departmentTemplateRepository;
	
	@Spy
	private JdbcTemplate jdbcTemplate;
		
	@Test
	public void findAllTest() {
		// arrange
		jdbcTemplate.setDataSource(dataSource());
		
		// act
		List<Department> listDepartments = departmentTemplateRepository.findAll();
		
		// assert
		assertNotNull(listDepartments);
		assertThat(listDepartments, not(IsEmptyCollection.empty()));
	}
}
