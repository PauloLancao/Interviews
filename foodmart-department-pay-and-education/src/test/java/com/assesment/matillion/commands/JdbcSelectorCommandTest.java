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
public class JdbcSelectorCommandTest {

	@InjectMocks
	private JdbcSelectorCommand jdbcSelectorCommand;
	
	@Spy
	private ILogger log;
	
	@Test
	public void executeInjectMockTest() {
		
		ConsoleContext context = new ConsoleContext(log);
		context.setConsoleOption(3);
		
		jdbcSelectorCommand.execute(context);
		
		Mockito.verify(context.getLog(), times(1)).log(new LoggerContext(Mockito.any()));
	}
}
