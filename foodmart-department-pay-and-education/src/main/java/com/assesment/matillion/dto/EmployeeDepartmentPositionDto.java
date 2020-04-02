package com.assesment.matillion.dto;

public final class EmployeeDepartmentPositionDto {

	private EmployeeDto employeeDto;
	private DepartmentDto departmentDto;
	private PositionDto positonDto;
	
	public EmployeeDto getEmployeeDto() {
		return employeeDto;
	}
	
	public void setEmployeeDto(EmployeeDto employeeDto) {
		this.employeeDto = employeeDto;
	}
	
	public DepartmentDto getDepartmentDto() {
		return departmentDto;
	}
	
	public void setDepartmentDto(DepartmentDto departmentDto) {
		this.departmentDto = departmentDto;
	}
	
	public PositionDto getPositonDto() {
		return positonDto;
	}
	
	public void setPositonDto(PositionDto positonDto) {
		this.positonDto = positonDto;
	}
}
