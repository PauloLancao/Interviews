package com.assesment.matillion.console;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ConsoleProcessorTests {

	@InjectMocks
	private ConsoleProcessor consoleProcessor;
	
	@Mock
	private ConsoleExecutor consoleExecutor;
	
	@Test
	public void consoleProcessorScannerWhenInputsIsntNumber() {
				
		String initialString = "a\na\n";
		InputStream stdin = System.in;
		
		try {
						
			System.setIn(new ByteArrayInputStream(initialString.getBytes()));
		  
			consoleProcessor.run();
		  
		} finally {
			System.setIn(stdin);
		}
	}
	
	@Test
	public void consoleProcessorScannerWhenInputsIsNumberCorrectRange() {
				
		String initialString = "1\n2\n\n3";
		InputStream stdin = System.in;
		
		try {
						
			System.setIn(new ByteArrayInputStream(initialString.getBytes()));
		  
			consoleProcessor.run();
		  
		} finally {
			System.setIn(stdin);
		}
	}
	
	@Test
	public void consoleProcessorScannerWhenInputsIsNumberButNotInCorrectRange() {
				
		String initialString = "0\n9\n";
		InputStream stdin = System.in;
		
		try {
						
			System.setIn(new ByteArrayInputStream(initialString.getBytes()));
		  
			consoleProcessor.run();
		  
		} finally {
			System.setIn(stdin);
		}
	}
}
