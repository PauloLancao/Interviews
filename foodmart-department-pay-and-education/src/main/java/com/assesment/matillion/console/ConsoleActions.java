package com.assesment.matillion.console;

public enum ConsoleActions {
	MENU(1), 
	JDBC_DEFAULT(2), 
	JDBC_TEMPLATE(3), 
	SHOW_DEPARTMENT(4), 
	SHOW_EMPLOYEE(5), 
	SHOW_POSITION(6),
	EXECUTE_DB_OPERATION(7), 
	QUIT(8);

	private int option;

	ConsoleActions(int option) {
		this.option = option;
	}

	public int getOption() {
		return option;
	}

	public static ConsoleActions getConsoleAction(int action) {
		for (ConsoleActions a : values()) {
			if (a.option == action) {
				return a;
			}
		}
		return MENU;
	}
}
