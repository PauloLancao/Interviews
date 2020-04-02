package com.assesment.matillion.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.assesment.matillion.entity.Position;

@ExtendWith(SpringExtension.class)
public class PositionTemplateRepositoryTest extends AbstractRepositoryTest {

	@InjectMocks
	private PositionTemplateRepository positionTemplateRepository;
	
	@Spy
	private JdbcTemplate jdbcTemplate;
		
	@Test
	public void findAllTest() {
		// arrange
		jdbcTemplate.setDataSource(dataSource());
		
		// act
		List<Position> listPositions = positionTemplateRepository.findAll();
		
		// assert
		assertNotNull(listPositions);
		assertThat(listPositions, not(IsEmptyCollection.empty()));
	}
}
