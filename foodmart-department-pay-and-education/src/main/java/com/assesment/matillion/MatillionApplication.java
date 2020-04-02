package com.assesment.matillion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.assesment.matillion.console.ConsoleProcessor;

@SpringBootApplication
public class MatillionApplication implements CommandLineRunner {

	@Autowired
	private ConsoleProcessor consoleProcessor;

	public static void main(String[] args) {
		new SpringApplicationBuilder(MatillionApplication.class)
        	.logStartupInfo(false)
        	.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		consoleProcessor.run();
	}
}
