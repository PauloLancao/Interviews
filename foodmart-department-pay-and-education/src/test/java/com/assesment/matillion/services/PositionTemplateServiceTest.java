package com.assesment.matillion.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.assesment.matillion.dto.PositionDto;
import com.assesment.matillion.entity.Position;
import com.assesment.matillion.mapper.PositionMapper;
import com.assesment.matillion.repository.DatabaseConfig;
import com.assesment.matillion.repository.PositionTemplateRepository;

@ExtendWith(MockitoExtension.class)
public class PositionTemplateServiceTest {

	@InjectMocks
	private PositionTemplateService positionTemplateService;
	
	@Spy
	private PositionTemplateRepository positionTemplateRepository;
	
	@Spy
	private PositionMapper positionMapper;
	
	@Mock
	private DatabaseConfig databaseConfig;
	
	@Test
	public void findAllTest() {
		// arrange
		PositionDto positionDto = new PositionDto();
		positionDto.setManagementRole("managementRole");
		positionDto.setPayType("payType");
		
		List<Position> mockPosition = new ArrayList<>();
		Position position = new Position();
		position.setManagementRole("managementRole");
		position.setPayType("payType");
		mockPosition.add(position);
		
		Mockito.doReturn(mockPosition).when(positionTemplateRepository).findAll();
		Mockito.doReturn(positionDto).when(positionMapper).convertToDto(position);
		
		// act
		List<PositionDto> listPositionDto = positionTemplateService.findAll();
		
		// assert
		assertNotNull(listPositionDto);
		assertThat(listPositionDto, containsInAnyOrder(positionDto));
	}
}
