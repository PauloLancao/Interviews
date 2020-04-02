package com.assesment.matillion.console;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assesment.matillion.commands.DepartmentDbCommand;
import com.assesment.matillion.commands.EmployeeDbCommand;
import com.assesment.matillion.commands.IConsoleCommand;
import com.assesment.matillion.commands.JdbcOperationCommand;
import com.assesment.matillion.commands.JdbcSelectorCommand;
import com.assesment.matillion.commands.MenuCommand;
import com.assesment.matillion.commands.PositionDbCommand;
import com.assesment.matillion.commands.QuitCommand;
import com.assesment.matillion.logger.Sl4jLogger;

@Component
class ConsoleExecutor implements IConsoleExecutor {

	private Map<Integer, IConsoleCommand<ConsoleContext>> consoleStates = new HashMap<>(8);
	private ConsoleContext consoleContext;
	
	private JdbcOperationCommand jdbcOperationCommand;
	private JdbcSelectorCommand jdbcSelectorCommand;
	private DepartmentDbCommand departmentDbCommand;
	private EmployeeDbCommand employeeDbCommand;
	private PositionDbCommand positionDbCommand;
	private MenuCommand menuCommand;
	private QuitCommand quitCommand;
	private Sl4jLogger sl4jLogger;
	
	@Autowired
	public ConsoleExecutor(JdbcOperationCommand jdbcOperationCommand,
			JdbcSelectorCommand jdbcSelectorCommand,
			DepartmentDbCommand departmentDbCommand,
			EmployeeDbCommand employeeDbCommand,
			PositionDbCommand positionDbCommand,
			MenuCommand menuCommand,
			QuitCommand quitCommand,
			Sl4jLogger sl4jLogger) {
		
		this.jdbcOperationCommand = jdbcOperationCommand;
		this.jdbcSelectorCommand = jdbcSelectorCommand;
		this.departmentDbCommand = departmentDbCommand;
		this.employeeDbCommand = employeeDbCommand;
		this.positionDbCommand = positionDbCommand;
		this.menuCommand = menuCommand;
		this.quitCommand = quitCommand;
		this.sl4jLogger = sl4jLogger;
		
		createConsoleCommands();
		executor(ConsoleActions.MENU.getOption());
	}
	
	@Override
	public void executor(int consoleOption) {
		consoleStates.get(consoleOption).execute(createConsoleContext(consoleOption));
	}

	void createConsoleCommands() {
		consoleStates.put(ConsoleActions.MENU.getOption(), menuCommand);
		consoleStates.put(ConsoleActions.JDBC_DEFAULT.getOption(), jdbcSelectorCommand);
		consoleStates.put(ConsoleActions.JDBC_TEMPLATE.getOption(), jdbcSelectorCommand);
		consoleStates.put(ConsoleActions.SHOW_DEPARTMENT.getOption(), departmentDbCommand);
		consoleStates.put(ConsoleActions.SHOW_EMPLOYEE.getOption(), employeeDbCommand);
		consoleStates.put(ConsoleActions.SHOW_POSITION.getOption(), positionDbCommand);
		consoleStates.put(ConsoleActions.EXECUTE_DB_OPERATION.getOption(), jdbcOperationCommand);
		consoleStates.put(ConsoleActions.QUIT.getOption(), quitCommand);

		consoleStates = Collections.synchronizedMap(consoleStates);
	}

	/*
	 * Controls when landing on Menu option we create a new execution context.
	 */
	private ConsoleContext createConsoleContext(int consoleOption) {
		if (ConsoleActions.MENU.getOption() == consoleOption) {
			consoleContext = new ConsoleContext(sl4jLogger);
		}

		// Keep track of option selected
		consoleContext.setConsoleOption(consoleOption);

		return consoleContext;
	}
}
