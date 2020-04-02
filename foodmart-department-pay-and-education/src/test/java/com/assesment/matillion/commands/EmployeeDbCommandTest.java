package com.assesment.matillion.commands;

import static org.mockito.Mockito.times;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.assesment.matillion.console.ConsoleActions;
import com.assesment.matillion.console.ConsoleContext;
import com.assesment.matillion.logger.ILogger;
import com.assesment.matillion.logger.LoggerContext;
import com.assesment.matillion.services.EmployeeService;
import com.assesment.matillion.services.EmployeeTemplateService;

@ExtendWith(MockitoExtension.class)
public class EmployeeDbCommandTest {

	@InjectMocks
	private EmployeeDbCommand employeeDbCommand;
	
	@Spy
	private ILogger log;
	
	@Mock
	private EmployeeTemplateService employeeTemplateService;
	
	@Mock
	private EmployeeService employeeService;
	
	@Test
	public void executeJdbcTemplateTest() {
		
		ConsoleContext consoleContext = new ConsoleContext(log);
		consoleContext.setJdbcSelector(ConsoleActions.JDBC_TEMPLATE);
		
		Mockito.when(employeeTemplateService.findAll()).thenReturn(new ArrayList<>());
		
		employeeDbCommand.execute(consoleContext);
		
		Mockito.verify(consoleContext.getLog(), times(2)).log(new LoggerContext(Mockito.any()));
	}
	
	@Test
	public void executeJdbcDefaultTest() {
		
		ConsoleContext consoleContext = new ConsoleContext(log);
		consoleContext.setJdbcSelector(ConsoleActions.JDBC_DEFAULT);
		
		Mockito.when(employeeService.findAll()).thenReturn(new ArrayList<>());
		
		employeeDbCommand.execute(consoleContext);
		
		Mockito.verify(consoleContext.getLog(), times(2)).log(new LoggerContext(Mockito.any()));
	}
}
