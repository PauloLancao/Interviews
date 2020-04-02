package com.assesment.matillion.commands;

import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assesment.matillion.console.ConsoleContext;
import com.assesment.matillion.dto.EmployeeDepartmentPositionDto;
import com.assesment.matillion.logger.LoggerContext;
import com.assesment.matillion.services.EmployeeService;
import com.assesment.matillion.utils.JsonUtil;

@Component
public class JdbcOperationCommand implements IConsoleCommand<ConsoleContext> {

	private static Logger log = LoggerFactory.getLogger(JdbcOperationCommand.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@Override
	public void execute(ConsoleContext command) {
		
		// Assumption command to run query with inner join
		// between employee, department and position

		try(Scanner scanner = new Scanner(System.in)) {
		
			boolean stopOperation = false;
			
			do {
				
				log.info("\nSpecify a department description?");
				String department = scanner.nextLine();
				
				log.info("\nSpecify a position pay type?");
				String payType = scanner.nextLine();				
				
				log.info("\nSpecify a employee education level?");
				String educationLevel = scanner.nextLine();
	
				if(StringUtils.isBlank(department) 
						|| StringUtils.isBlank(payType) 
						|| StringUtils.isBlank(educationLevel)) {
					log.info("\nSomething is wrong with input data, please try again...\n");
				} else {
					
					List<EmployeeDepartmentPositionDto> listEmployees = employeeService.findAllByEducationLevelPayTypeDepartment(
							educationLevel, payType, department);
					
					command.getLog().log(new LoggerContext(JsonUtil.convertToJson(listEmployees)));
				}
				
				log.info("\n(1) - Quit\n(2) - Continue\n");
				
				while (!scanner.hasNextInt()) {
					log.warn("Please select 1 or 2");
			        scanner.next();
			    }
				
				int operationOption = scanner.nextInt();
				scanner.nextLine();  // Consume newline left-over
				
				if(operationOption == 1) {
					stopOperation = true;
				}
				
			} while (!stopOperation);
		}
	}
}
