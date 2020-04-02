package com.assesment.matillion.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.assesment.matillion.entity.Position;

@ExtendWith(SpringExtension.class)
public class PositionRepositoryTest extends AbstractRepositoryTest {

	@InjectMocks
	private PositionRepository positionRepository;
				
	@Test
	public void getConnectionTest() throws SQLException {
		Connection connection = positionRepository.getConnection();
	    
		assertNotNull(connection);
	}
	
	@Test
	public void getConnectionClassNameException() {
		// arrange
		databaseConfig.setUrl("soemthing incorrect");
		
		Assertions.assertThrows(RuntimeException.class, () -> {
			positionRepository.getConnection();
		});
	}
	
	@Test
	public void getConnectionSqlException() {
		// arrange
		databaseConfig.setClassname("soemthing incorrect");
		
		Assertions.assertThrows(RuntimeException.class, () -> {
			positionRepository.getConnection();
		});
	}
	
	@Test
	public void findAllTest() {
		// act
		List<Position> listPositions = positionRepository.findAll();
		
		assertNotNull(listPositions);
		assertThat(listPositions, not(IsEmptyCollection.empty()));
	}
}
