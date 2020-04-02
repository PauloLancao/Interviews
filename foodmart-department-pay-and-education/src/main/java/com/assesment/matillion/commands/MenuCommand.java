package com.assesment.matillion.commands;

import org.springframework.stereotype.Component;

import com.assesment.matillion.console.ConsoleContext;
import com.assesment.matillion.logger.LoggerContext;

@Component
public class MenuCommand implements IConsoleCommand<ConsoleContext> {

	@Override
	public void execute(ConsoleContext command) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\n\nChoose from these options\n");
		sb.append("-------------------------\n");		
		sb.append("(1) - Menu\n");
		sb.append("JDBC Options:\n");		
		sb.append("(2) - JDBC (Default)\n");
		sb.append("(3) - JDBC Spring Template\n");
		sb.append("Operations:\n Department \n Employee \n Position \n");
		sb.append("(4) - Show Department table \n");
		sb.append("(5) - Show Employee table \n");
		sb.append("(6) - Show Position table \n");
		sb.append("(7) - Execute DB operation \n");
		sb.append("(8) - Quit\n");
		
		command.getLog().log(new LoggerContext(sb.toString()));
	}
}
