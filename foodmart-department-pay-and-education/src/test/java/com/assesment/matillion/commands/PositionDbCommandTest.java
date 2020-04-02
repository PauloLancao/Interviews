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
import com.assesment.matillion.services.PositionService;
import com.assesment.matillion.services.PositionTemplateService;

@ExtendWith(MockitoExtension.class)
public class PositionDbCommandTest {

	@InjectMocks
	private PositionDbCommand positionDbCommand;
	
	@Spy
	private ILogger log;
	
	@Mock
	private PositionTemplateService positionTemplateService;
	
	@Mock
	private PositionService positionService;
	
	@Test
	public void executeJdbcTemplateTest() {
		
		ConsoleContext consoleContext = new ConsoleContext(log);
		consoleContext.setJdbcSelector(ConsoleActions.JDBC_TEMPLATE);
		
		Mockito.when(positionTemplateService.findAll()).thenReturn(new ArrayList<>());
		
		positionDbCommand.execute(consoleContext);
		
		Mockito.verify(consoleContext.getLog(), times(2)).log(new LoggerContext(Mockito.any()));
	}
	
	@Test
	public void executeJdbcDefaultTest() {
		
		ConsoleContext consoleContext = new ConsoleContext(log);
		consoleContext.setJdbcSelector(ConsoleActions.JDBC_DEFAULT);
		
		Mockito.when(positionService.findAll()).thenReturn(new ArrayList<>());
		
		positionDbCommand.execute(consoleContext);
		
		Mockito.verify(consoleContext.getLog(), times(2)).log(new LoggerContext(Mockito.any()));
	}
}
