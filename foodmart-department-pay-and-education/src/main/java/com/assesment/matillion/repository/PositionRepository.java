package com.assesment.matillion.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.assesment.matillion.entity.Position;

@Repository
public class PositionRepository extends AbstractRepository implements IPositionRepository {

	private static Logger log = LoggerFactory.getLogger(PositionRepository.class);
	
	@Override
	public List<Position> findAll() {

		List<Position> listPositions = new ArrayList<>();
		
		try {

			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM position");
			
			while (rs.next()) {
				listPositions.add(PositionResultSetMap.map(rs));
			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		
		return listPositions;
	}
}
