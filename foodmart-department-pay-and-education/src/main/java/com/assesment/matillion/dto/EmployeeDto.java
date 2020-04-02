package com.assesment.matillion.dto;

import java.math.BigDecimal;
import java.sql.Date;

public final class EmployeeDto {

	private Date birthDate;
	private int departmentId;
	private String educationLevel;
	private int employeeId;
	private Date endDate;
	private String firstName;
	private String fullName;
	private String gender;
	private Date hireDate;
	private String lastName;
	private String managementRole;
	private String maritalStatus;
	private int positionId;
	private String positionTitle;
	private BigDecimal salary;
	private int storeId;
	private int supervisorId;
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public int getDepartmentId() {
		return departmentId;
	}
	
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	
	public String getEducationLevel() {
		return educationLevel;
	}
	
	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Date getHireDate() {
		return hireDate;
	}
	
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getManagementRole() {
		return managementRole;
	}
	
	public void setManagementRole(String managementRole) {
		this.managementRole = managementRole;
	}
	
	public String getMaritalStatus() {
		return maritalStatus;
	}
	
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	
	public int getPositionId() {
		return positionId;
	}
	
	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}
	
	public String getPositionTitle() {
		return positionTitle;
	}
	
	public void setPositionTitle(String positionTitle) {
		this.positionTitle = positionTitle;
	}
	
	public BigDecimal getSalary() {
		return salary;
	}
	
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	
	public int getStoreId() {
		return storeId;
	}
	
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	
	public int getSupervisorId() {
		return supervisorId;
	}
	
	public void setSupervisorId(int supervisorId) {
		this.supervisorId = supervisorId;
	}
}
