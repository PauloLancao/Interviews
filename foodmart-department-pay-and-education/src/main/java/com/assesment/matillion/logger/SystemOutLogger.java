package com.assesment.matillion.logger;

import org.springframework.stereotype.Component;

@Component
public final class SystemOutLogger implements ILogger {

	@Override
	public void log(LoggerContext context) {
		System.out.print(context.getMessage());
	}
}
