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

import com.assesment.matillion.entity.Employee;
import com.assesment.matillion.entity.EmployeeDepartmentPosition;

@ExtendWith(SpringExtension.class)
public class EmployeeRepositoryTest extends AbstractRepositoryTest {

	@InjectMocks
	private EmployeeRepository employeeRepository;
	
	@Test
	public void findAllTest() {
		// act
		List<Employee> listEmployees = employeeRepository.findAll();
		
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
		List<EmployeeDepartmentPosition> listEmployeeDepartmentPosition = 
				employeeRepository.findAllByEducationLevelPayTypeDepartment(educationLevel, payType, department);
		
		// assert
		assertNotNull(listEmployeeDepartmentPosition);
		assertThat(listEmployeeDepartmentPosition, not(IsEmptyCollection.empty()));
	}
	
	@Test
	public void findAllByEducationLevelPayTypeDepartmentNoDataTest() {
		String educationLevel = "dummy";
		String payType = "dummy";
		String department = "dummy";
		
		// act
		List<EmployeeDepartmentPosition> listEmployeeDepartmentPosition = 
				employeeRepository.findAllByEducationLevelPayTypeDepartment(educationLevel, payType, department);
		
		// assert
		assertNotNull(listEmployeeDepartmentPosition);
		assertThat(listEmployeeDepartmentPosition, IsEmptyCollection.empty());
	}
}
