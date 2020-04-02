package com.assesment.matillion.logger;

import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SystemOutLoggerTest {

	@Mock
	private SystemOutLogger systemOutLogger;
	
	@Test
	public void logTest() {
		// arrange
		LoggerContext loggerContext = new LoggerContext("test sl4j logger");
		
		// act
		systemOutLogger.log(loggerContext);
		
		// assert
		Mockito.verify(systemOutLogger, times(1)).log(loggerContext);
	}
}
