package com.assesment.matillion.commands;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assesment.matillion.console.ConsoleActions;
import com.assesment.matillion.console.ConsoleContext;
import com.assesment.matillion.dto.EmployeeDto;
import com.assesment.matillion.logger.LoggerContext;
import com.assesment.matillion.services.EmployeeService;
import com.assesment.matillion.services.EmployeeTemplateService;
import com.assesment.matillion.utils.JsonUtil;

@Component
public class EmployeeDbCommand implements IConsoleCommand<ConsoleContext> {

	@Autowired
	private EmployeeTemplateService employeeTemplateService;
	
	@Autowired
	private EmployeeService employeeService;

	@Override
	public void execute(ConsoleContext command) {

		// Check which JDBC selector and call the correct service
		// Will use a normal if else, but if we had more than five types
		// of services, i would consider creating a factory.

		ConsoleActions jdbcSelector = command.getJdbcSelector();
		List<EmployeeDto> listEmployees = new ArrayList<>();

		if (jdbcSelector == ConsoleActions.JDBC_TEMPLATE) {
			command.getLog().log(new LoggerContext(ConsoleActions.JDBC_TEMPLATE.toString()));
			listEmployees = employeeTemplateService.findAll();
		} else {
			command.getLog().log(new LoggerContext(ConsoleActions.JDBC_DEFAULT.toString()));
			listEmployees = employeeService.findAll();
		}

		command.getLog().log(new LoggerContext(JsonUtil.convertToJson(listEmployees)));
	}
}
