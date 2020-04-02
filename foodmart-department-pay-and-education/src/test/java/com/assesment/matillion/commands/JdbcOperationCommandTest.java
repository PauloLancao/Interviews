package com.assesment.matillion.commands;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.assesment.matillion.console.ConsoleContext;
import com.assesment.matillion.logger.ILogger;
import com.assesment.matillion.services.EmployeeService;

@ExtendWith(MockitoExtension.class)
public class JdbcOperationCommandTest {

	@InjectMocks
	private JdbcOperationCommand jdbcOperationCommand;
	
	@Mock
	private EmployeeService employeeService;
	
	@Spy
	private ILogger log;
	
	@Test
	public void executeTest( ) {
		
		ConsoleContext consoleContext = new ConsoleContext(log);
		
		String initialString = "a\na\na\n1\n";
		InputStream stdin = System.in;
		
		try {
						
			System.setIn(new ByteArrayInputStream(initialString.getBytes()));
		  
			jdbcOperationCommand.execute(consoleContext);
		  
		} finally {
			System.setIn(stdin);
		}
	}	
	
	@Test
	public void executeRetryPathTest( ) {
		
		ConsoleContext consoleContext = new ConsoleContext(log);
		
		String initialString = "\n\n\na\n1\n";
		InputStream stdin = System.in;
		
		try {
						
			System.setIn(new ByteArrayInputStream(initialString.getBytes()));
		  
			jdbcOperationCommand.execute(consoleContext);
		  
		} finally {
			System.setIn(stdin);
		}
	}
}
