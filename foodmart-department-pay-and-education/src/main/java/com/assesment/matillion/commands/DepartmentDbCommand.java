package com.assesment.matillion.commands;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assesment.matillion.console.ConsoleActions;
import com.assesment.matillion.console.ConsoleContext;
import com.assesment.matillion.dto.DepartmentDto;
import com.assesment.matillion.logger.LoggerContext;
import com.assesment.matillion.services.DepartmentService;
import com.assesment.matillion.services.DepartmentTemplateService;
import com.assesment.matillion.utils.JsonUtil;

@Component
public class DepartmentDbCommand implements IConsoleCommand<ConsoleContext> {

	@Autowired
	private DepartmentTemplateService departmentTemplateService;
	
	@Autowired
	private DepartmentService departmentService;

	@Override
	public void execute(ConsoleContext command) {

		// Check which JDBC selector and call the correct service
		// Will use a normal if else, but if we had more than five types
		// of services, i would consider creating a factory.

		ConsoleActions jdbcSelector = command.getJdbcSelector();
		List<DepartmentDto> listDepartments = new ArrayList<>();

		if (jdbcSelector == ConsoleActions.JDBC_TEMPLATE) {
			command.getLog().log(new LoggerContext(ConsoleActions.JDBC_TEMPLATE.toString()));
			listDepartments = departmentTemplateService.findAll();
		} else {
			command.getLog().log(new LoggerContext(ConsoleActions.JDBC_DEFAULT.toString()));
			listDepartments = departmentService.findAll();
		}

		command.getLog().log(new LoggerContext(JsonUtil.convertToJson(listDepartments)));
	}
}
