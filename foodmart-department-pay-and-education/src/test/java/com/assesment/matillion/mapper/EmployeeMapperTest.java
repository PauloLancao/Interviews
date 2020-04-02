package com.assesment.matillion.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.util.Assert;

import com.assesment.matillion.dto.DepartmentDto;
import com.assesment.matillion.dto.EmployeeDepartmentPositionDto;
import com.assesment.matillion.dto.EmployeeDto;
import com.assesment.matillion.dto.PositionDto;
import com.assesment.matillion.entity.Department;
import com.assesment.matillion.entity.Employee;
import com.assesment.matillion.entity.EmployeeDepartmentPosition;
import com.assesment.matillion.entity.Position;

@ExtendWith(MockitoExtension.class)
public class EmployeeMapperTest {
		
	@InjectMocks
    private EmployeeMapper employeeMapper = new EmployeeMapper();
	
	@Spy
	private ModelMapper modelMapper;

    @BeforeEach
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
        modelMapper = new ModelMapper();
    }
    
    @Test
    public void employeeModelMapperTest() {
    	ModelMapper modelMapper = employeeMapper.employeeModelMapper();
    	assertNotNull(modelMapper);
    }
    
	@Test
	public void convertToDtoTest() {
		// arrange
		LocalDate localDate = LocalDate.of(1967, 06, 22);
		Date hireDate = Date.valueOf(localDate);
		
		Employee employee = new Employee();
		employee.setEducationLevel("educationLevel");
		employee.setFullName("fullName");
		employee.setDepartmentId(564);
		employee.setEmployeeId(1002);
		employee.setFirstName("firstName");
		employee.setGender("Male");
		employee.setLastName("TestLastName");
		employee.setManagementRole("Administrator");
		employee.setMaritalStatus("Single");
		employee.setPositionId(12);
		employee.setPositionTitle("positionTitle");
		employee.setSalary(BigDecimal.valueOf(33333.33));
		employee.setStoreId(555);
		employee.setSupervisorId(342);
		employee.setHireDate(hireDate);
		
		// act
		EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
				
		// assert
		Assert.isInstanceOf(EmployeeDto.class, employeeDto);
		assertEquals("educationLevel", employeeDto.getEducationLevel());
		assertEquals("fullName", employeeDto.getFullName());
		assertEquals(564, employeeDto.getDepartmentId());
		assertEquals(1002, employeeDto.getEmployeeId());
		assertEquals("firstName", employeeDto.getFirstName());
		assertEquals("Male", employeeDto.getGender());
		assertEquals("TestLastName", employeeDto.getLastName());
		assertEquals("Administrator", employeeDto.getManagementRole());
		assertEquals("Single", employeeDto.getMaritalStatus());
		assertEquals(12, employeeDto.getPositionId());
		assertEquals("positionTitle", employeeDto.getPositionTitle());
		assertEquals(BigDecimal.valueOf(33333.33), employeeDto.getSalary());
		assertEquals(555, employeeDto.getStoreId());
		assertEquals(342, employeeDto.getSupervisorId());
		assertEquals(hireDate, employeeDto.getHireDate());
		
		assertNull(employeeDto.getBirthDate());
		assertNull(employeeDto.getEndDate());
	}
	
	@Test
	public void convertToDtoEmployeeDepartmentPositionTest() {
		// arrange
		Employee employee = new Employee();
		employee.setEducationLevel("educationLevel");
		employee.setFullName("fullName");
		
		Position position = new Position();
		position.setManagementRole("managementRole");
		position.setPayType("payType");
		position.setPositionId(111);
		
		Department department = new Department();
		department.setDepartmentDescription("departmentDescription");
		department.setDepartmentId(999);
				
		// act
		EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
		PositionDto positionDto = modelMapper.map(position, PositionDto.class);
		DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);
				
		// assert		
		Assert.isInstanceOf(EmployeeDto.class, employeeDto);
		assertEquals("educationLevel", employeeDto.getEducationLevel());
		assertEquals("fullName", employeeDto.getFullName());
		assertNull(employeeDto.getBirthDate());
		assertNull(employeeDto.getEndDate());
				
		Assert.isInstanceOf(PositionDto.class, positionDto);
		assertEquals("managementRole", positionDto.getManagementRole());
		assertEquals("payType", positionDto.getPayType());
		assertEquals(111, positionDto.getPositionId());
		assertNull(positionDto.getMaxScale());
				
		Assert.isInstanceOf(DepartmentDto.class, departmentDto);
		assertEquals("departmentDescription", departmentDto.getDepartmentDescription());
		assertEquals(999, departmentDto.getDepartmentId());
	}
	
	@Test
	public void convertToDtoCallTest() {
		// arrange
		Employee employee = new Employee();
		employee.setEducationLevel("educationLevel");
		employee.setFullName("fullName");
		
		// act
		EmployeeDto employeeDto = employeeMapper.convertToDto(employee);

		// assert
		Assert.isInstanceOf(EmployeeDto.class, employeeDto);
		assertEquals("educationLevel", employeeDto.getEducationLevel());
		assertEquals("fullName", employeeDto.getFullName());
		assertNull(employeeDto.getBirthDate());
		assertNull(employeeDto.getEndDate());
	}
	
	@Test
	public void convertToDtoCallEmployeeDepartmentPositionTest() {
		// arrange
		Employee employee = new Employee();
		employee.setEducationLevel("educationLevel");
		employee.setFullName("fullName");
		
		Position position = new Position();
		position.setManagementRole("managementRole");
		position.setPayType("payType");
		position.setPositionId(111);
		
		Department department = new Department();
		department.setDepartmentDescription("departmentDescription");
		department.setDepartmentId(999);
		
		EmployeeDepartmentPosition edp = new EmployeeDepartmentPosition();
		edp.setDepartment(department);
		edp.setEmployee(employee);
		edp.setPosition(position);
		
		// act
		EmployeeDepartmentPositionDto edpDto = employeeMapper.convertToDto(edp);
		
		EmployeeDto employeeDto = edpDto.getEmployeeDto();
		PositionDto positionDto = edpDto.getPositonDto();
		DepartmentDto departmentDto = edpDto.getDepartmentDto();
		
		// assert		
		Assert.isInstanceOf(EmployeeDto.class, employeeDto);
		assertEquals("educationLevel", employeeDto.getEducationLevel());
		assertEquals("fullName", employeeDto.getFullName());
		assertNull(employeeDto.getBirthDate());
		assertNull(employeeDto.getEndDate());
				
		Assert.isInstanceOf(PositionDto.class, positionDto);
		assertEquals("managementRole", positionDto.getManagementRole());
		assertEquals("payType", positionDto.getPayType());
		assertEquals(111, positionDto.getPositionId());
		assertNull(positionDto.getMaxScale());
				
		Assert.isInstanceOf(DepartmentDto.class, departmentDto);
		assertEquals("departmentDescription", departmentDto.getDepartmentDescription());
		assertEquals(999, departmentDto.getDepartmentId());	
	}
}
