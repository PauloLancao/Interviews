package com.assesment.matillion.commands;

import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.assesment.matillion.console.ConsoleContext;
import com.assesment.matillion.logger.ILogger;
import com.assesment.matillion.logger.LoggerContext;

@ExtendWith(MockitoExtension.class)
public class MenuCommandTest {
	
	@InjectMocks
	private MenuCommand menuCommand;
	
	@Spy
	private ILogger log;
	
	@Test
	public void executeTest() {
		// arrange
		MenuCommand menuCommand = Mockito.mock(MenuCommand.class);
		ConsoleContext command = Mockito.mock(ConsoleContext.class);
		
		// act
		menuCommand.execute(command);
	
		// verify
		Mockito.verify(menuCommand, times(1)).execute(command);
	}
	
	@Test
	public void executeInjectMockTest() {
		
		ConsoleContext context = new ConsoleContext(log);
		
		menuCommand.execute(context);
		
		Mockito.verify(context.getLog(), times(1)).log(new LoggerContext(Mockito.any()));
	}
}
