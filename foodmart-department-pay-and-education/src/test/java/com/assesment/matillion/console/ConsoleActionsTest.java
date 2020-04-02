package com.assesment.matillion.console;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ConsoleActionsTest {

	@Test
	public void getConsoleActionTest() {
		
		ConsoleActions defaultMenu = ConsoleActions.getConsoleAction(0);
		int option = defaultMenu.getOption();
		assertEquals(ConsoleActions.MENU, defaultMenu);
		assertEquals(1, option);
		
		ConsoleActions menu = ConsoleActions.getConsoleAction(1);
		assertEquals(ConsoleActions.MENU, menu);
		
		ConsoleActions jdbcDefault = ConsoleActions.getConsoleAction(2);
		assertEquals(ConsoleActions.JDBC_DEFAULT, jdbcDefault);
		
		ConsoleActions jdbcTemplate = ConsoleActions.getConsoleAction(3);
		assertEquals(ConsoleActions.JDBC_TEMPLATE, jdbcTemplate);
		
		ConsoleActions showDepartment = ConsoleActions.getConsoleAction(4);
		assertEquals(ConsoleActions.SHOW_DEPARTMENT, showDepartment);
		
		ConsoleActions showEmployee = ConsoleActions.getConsoleAction(5);
		assertEquals(ConsoleActions.SHOW_EMPLOYEE, showEmployee);
	}
}
