package com.assesment.matillion.console;

import com.assesment.matillion.logger.ILogger;

public final class ConsoleContext {

	private ConsoleActions jdbcSelector;
	private int consoleOption;
	private ILogger log;

	public ConsoleContext(ILogger log) {
		this.log = log;
		this.setJdbcSelector(ConsoleActions.JDBC_DEFAULT);
	}

	public ILogger getLog() {
		return log;
	}

	public int getConsoleOption() {
		return consoleOption;
	}

	public void setConsoleOption(int consoleOption) {
		this.consoleOption = consoleOption;
	}

	public ConsoleActions getJdbcSelector() {
		return jdbcSelector;
	}

	public void setJdbcSelector(ConsoleActions jdbcSelector) {
		this.jdbcSelector = jdbcSelector;
	}
}
