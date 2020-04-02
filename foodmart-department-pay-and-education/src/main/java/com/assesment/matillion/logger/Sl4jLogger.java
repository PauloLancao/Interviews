package com.assesment.matillion.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public final class Sl4jLogger implements ILogger {

	private static Logger log = LoggerFactory.getLogger(Sl4jLogger.class);

	@Override
	public void log(LoggerContext context) {
		log.info(context.getMessage());
	}
}
