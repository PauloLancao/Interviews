package com.assesment.matillion.commands;

import org.springframework.stereotype.Component;

import com.assesment.matillion.console.ConsoleActions;
import com.assesment.matillion.console.ConsoleContext;
import com.assesment.matillion.logger.LoggerContext;

@Component
public class JdbcSelectorCommand implements IConsoleCommand<ConsoleContext> {

	@Override
	public void execute(ConsoleContext command) {
		command.setJdbcSelector(ConsoleActions.getConsoleAction(command.getConsoleOption()));
		
		command.getLog().log(new LoggerContext(
				String.format("Jdbc selector selected was %s", command.getJdbcSelector().toString())));
	}
}
