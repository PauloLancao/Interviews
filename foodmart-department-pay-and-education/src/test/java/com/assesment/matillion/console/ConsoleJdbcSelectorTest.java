package com.assesment.matillion.console;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ConsoleJdbcSelectorTest {

	@Test
	public void consoleJdbcSelectorTest() {
		
		String[] value = { "DEFAULT_JDBC", "SPRING_JDBC" };
		int i = 0;
		
		for (ConsoleJdbcSelector jdbcSelector : ConsoleJdbcSelector.values()) {
			assertEquals(value[i], jdbcSelector.toString());
			++i;
		}
	}
}
