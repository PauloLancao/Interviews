package com.assesment.matillion.commands;

@FunctionalInterface
public interface IConsoleCommand<I> {
	void execute(I command);
}
