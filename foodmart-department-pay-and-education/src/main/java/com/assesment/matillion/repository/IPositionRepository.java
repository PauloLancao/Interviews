package com.assesment.matillion.repository;

import java.util.List;

import com.assesment.matillion.entity.Position;

public interface IPositionRepository {
	List<Position> findAll();
}
