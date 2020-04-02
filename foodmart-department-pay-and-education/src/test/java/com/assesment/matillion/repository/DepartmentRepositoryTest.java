package com.assesment.matillion.repository;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.assesment.matillion.entity.Department;

@ExtendWith(SpringExtension.class)
public class DepartmentRepositoryTest extends AbstractRepositoryTest {

	@InjectMocks
	private DepartmentRepository departmentRepository;
	
	@Test
	public void findAllTest() {
		// act
		List<Department> listDepartments = departmentRepository.findAll();
		
		assertNotNull(listDepartments);
		assertThat(listDepartments, not(IsEmptyCollection.empty()));
	}
}
