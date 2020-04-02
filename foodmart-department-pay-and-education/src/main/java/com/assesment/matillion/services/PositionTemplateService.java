package com.assesment.matillion.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assesment.matillion.dto.PositionDto;
import com.assesment.matillion.mapper.PositionMapper;
import com.assesment.matillion.repository.PositionTemplateRepository;

@Service
public class PositionTemplateService implements IPositionService {

	@Autowired
	private PositionTemplateRepository positionTemplateRepository;
	
	@Autowired
	private PositionMapper positionMapper;
	
	@Override
	public List<PositionDto> findAll() {
		return positionTemplateRepository.findAll().stream()
		          .map(positionMapper::convertToDto)
		          .collect(Collectors.toList());
	}
}
