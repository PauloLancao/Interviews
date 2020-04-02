package com.assesment.matillion.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.util.Assert;

import com.assesment.matillion.dto.PositionDto;
import com.assesment.matillion.entity.Position;

@ExtendWith(MockitoExtension.class)
public class PositionMapperTest {

	@InjectMocks
    private PositionMapper positionMapper = new PositionMapper();
	
	@Spy
	private ModelMapper modelMapper;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		modelMapper = new ModelMapper();
	}
	
	@Test
	public void modelMapperTest() {
		ModelMapper modelMapper = positionMapper.modelMapper();
		assertNotNull(modelMapper);
	}
	
	@Test
	public void convertToDtoTest() {
		// arrange
		Position position = new Position();
		position.setManagementRole("managementRole");
		position.setPayType("payType");
		position.setPositionId(111);
		position.setPositionTitle("positionTitle");
		position.setMinScale(BigDecimal.valueOf(12.11));
						
		// act
		PositionDto positionDto = modelMapper.map(position, PositionDto.class);
				
		// assert
		Assert.isInstanceOf(PositionDto.class, positionDto);
		assertEquals("managementRole", positionDto.getManagementRole());
		assertEquals("payType", positionDto.getPayType());
		assertEquals(111, positionDto.getPositionId());
		assertEquals("positionTitle", positionDto.getPositionTitle());
		assertEquals(BigDecimal.valueOf(12.11), positionDto.getMinScale());
		assertNull(positionDto.getMaxScale());
	}
	
	@Test
	public void convertToDtoCallTest() {
		// arrange
		Position position = new Position();
		position.setManagementRole("managementRole");
		position.setPayType("payType");
		position.setPositionId(111);
		
		// act
		PositionDto positionDto = positionMapper.convertToDto(position);
		
		// assert
		Assert.isInstanceOf(PositionDto.class, positionDto);
		assertEquals("managementRole", positionDto.getManagementRole());
		assertEquals("payType", positionDto.getPayType());
		assertEquals(111, positionDto.getPositionId());
		assertNull(positionDto.getMaxScale());
	}
}
