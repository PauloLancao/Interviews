package com.assesment.matillion.services;

import java.util.List;

import com.assesment.matillion.dto.PositionDto;

public interface IPositionService {
	List<PositionDto> findAll();
}
