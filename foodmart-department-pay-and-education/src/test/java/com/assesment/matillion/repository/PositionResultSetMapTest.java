package com.assesment.matillion.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.assesment.matillion.entity.Position;

@ExtendWith(MockitoExtension.class)
public class PositionResultSetMapTest {

	@Test
	public void mapTest( ) throws SQLException {
		
		// arrange
		ResultSet resultSetMock = Mockito.mock(ResultSet.class);
		Mockito.when(resultSetMock.getInt("position_id")).thenReturn(132);
		Mockito.when(resultSetMock.getString("position_title")).thenReturn("President");
		Mockito.when(resultSetMock.getString("pay_type")).thenReturn("Monthly");
		Mockito.when(resultSetMock.getBigDecimal("min_scale")).thenReturn(BigDecimal.valueOf(25000.0000));
		Mockito.when(resultSetMock.getBigDecimal("max_scale")).thenReturn(BigDecimal.valueOf(85000.0000));
		Mockito.when(resultSetMock.getString("management_role")).thenReturn("Senior Management");
						
		// act
		Position position = PositionResultSetMap.map(resultSetMock);
		
		// assert
		assertEquals(132, position.getPositionId());
		assertEquals("President", position.getPositionTitle());
		assertEquals("Monthly", position.getPayType());
		assertEquals(BigDecimal.valueOf(25000.0000), position.getMinScale());
		assertEquals(BigDecimal.valueOf(85000.0000), position.getMaxScale());
		assertEquals("Senior Management", position.getManagementRole());
	}
}
