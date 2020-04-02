package com.assesment.matillion.logger;

public final class LoggerContext {

	private final String message;

	public LoggerContext(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
