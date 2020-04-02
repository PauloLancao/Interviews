package com.assesment.matillion.mapper;

import org.springframework.stereotype.Component;

import com.assesment.matillion.dto.PositionDto;
import com.assesment.matillion.entity.Position;

@Component
public final class PositionMapper extends AbstractMapper {

	public PositionDto convertToDto(Position position) {
		return modelMapper.map(position, PositionDto.class);
	}
}
