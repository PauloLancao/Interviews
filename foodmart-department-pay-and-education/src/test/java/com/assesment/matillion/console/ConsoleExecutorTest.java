package com.assesment.matillion.console;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.lang.reflect.Field;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.assesment.matillion.commands.DepartmentDbCommand;
import com.assesment.matillion.commands.EmployeeDbCommand;
import com.assesment.matillion.commands.IConsoleCommand;
import com.assesment.matillion.commands.JdbcOperationCommand;
import com.assesment.matillion.commands.JdbcSelectorCommand;
import com.assesment.matillion.commands.MenuCommand;
import com.assesment.matillion.commands.PositionDbCommand;
import com.assesment.matillion.commands.QuitCommand;
import com.assesment.matillion.logger.Sl4jLogger;

@ExtendWith(MockitoExtension.class)
public class ConsoleExecutorTest {

	@InjectMocks
	private ConsoleExecutor consoleExecutor;
	
	@Mock
	private JdbcOperationCommand jdbcOperationCommand;
	
	@Mock
	private JdbcSelectorCommand jdbcSelectorCommand;
	
	@Mock
	private DepartmentDbCommand departmentDbCommand;
	
	@Mock
	private EmployeeDbCommand employeeDbCommand;
	
	@Mock
	private PositionDbCommand positionDbCommand;
	
	@Mock
	private MenuCommand menuCommand;
	
	@Mock
	private QuitCommand quitCommand;
	
	@Mock
	private Sl4jLogger sl4jLogger;
	
	@Test
	public void createConsoleCommandsTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		consoleExecutor.createConsoleCommands();
		
		// Assert Map was initialised
        Field consoleStatesField = consoleExecutor.getClass().getDeclaredField("consoleStates");
        consoleStatesField.setAccessible(true);
        @SuppressWarnings("unchecked")
		Map<Integer, IConsoleCommand<ConsoleContext>> consoleStates = (Map<Integer, IConsoleCommand<ConsoleContext>>) 
				consoleStatesField.get(consoleExecutor);
		
        assertNotNull(consoleStates);
        assertEquals(8, consoleStates.size());
	}
}
