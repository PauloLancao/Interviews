package com.assesment.matillion.commands;

import org.springframework.stereotype.Component;

import com.assesment.matillion.console.ConsoleContext;
import com.assesment.matillion.logger.LoggerContext;

@Component
public class QuitCommand implements IConsoleCommand<ConsoleContext> {
	
	private static final String QUIT_LOG = "Quitting console application";
		
	@Override
	public void execute(ConsoleContext command) {
		command.getLog().log(new LoggerContext(QUIT_LOG));
		System.exit(0);
	}
}
