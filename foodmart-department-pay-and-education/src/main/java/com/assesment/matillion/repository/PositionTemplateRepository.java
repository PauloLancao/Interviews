package com.assesment.matillion.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.assesment.matillion.entity.Position;

@Repository
public class PositionTemplateRepository extends AbstractRepository implements IPositionRepository {

	@Override
	public List<Position> findAll() {

		return jdbcTemplate.query(
                "select * from position",
                (rs, rowNum) -> PositionResultSetMap.map(rs)
        );
	}
}
