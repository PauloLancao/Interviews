package com.assesment.matillion.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assesment.matillion.dto.PositionDto;
import com.assesment.matillion.mapper.PositionMapper;
import com.assesment.matillion.repository.PositionRepository;

@Service
public class PositionService implements IPositionService {

	@Autowired
	private PositionRepository positionRepository;
	
	@Autowired
	private PositionMapper positionMapper;
	
	@Override
	public List<PositionDto> findAll() {
		return positionRepository.findAll().stream()
		          .map(positionMapper::convertToDto)
		          .collect(Collectors.toList());
	}
}
