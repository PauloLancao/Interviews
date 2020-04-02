package com.assesment.matillion.console;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsoleProcessor {

	private static Logger log = LoggerFactory.getLogger(ConsoleProcessor.class);

	@Autowired
	private ConsoleExecutor consoleExecutor;

	public void run() {
		
		try (Scanner scanner = new Scanner(System.in)) {

			try {
				
				do {
					
					while (!scanner.hasNextInt()) {
						log.warn("Please select between 1 - 8");
				        scanner.next();
				    }
					
					int optionSelected = scanner.nextInt();
					
					if(optionSelected > 0 && optionSelected < 9) {
						consoleExecutor.executor(optionSelected);
					} else {
						log.warn("Please select between 1 - 8");
					}
					
				} while (scanner.hasNext());

			} catch (Exception ex) {
				log.error(ex.getMessage());
			}
		}
	}
}
