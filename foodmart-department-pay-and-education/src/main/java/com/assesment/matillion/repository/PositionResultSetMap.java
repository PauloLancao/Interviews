package com.assesment.matillion.repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.assesment.matillion.entity.Position;

public final class PositionResultSetMap {

	public static Position map(ResultSet rs) throws SQLException {
		Position position = new Position();
		
		int id = rs.getInt("position_id");
		String positionTitle = rs.getString("position_title");
		String payType = rs.getString("pay_type");
		BigDecimal minScale = rs.getBigDecimal("min_scale");
		BigDecimal maxScale = rs.getBigDecimal("max_scale");
		String managementRole = rs.getString("management_role");
		
		position.setPositionId(id);
		position.setPositionTitle(positionTitle);
		position.setPayType(payType);
		position.setMinScale(minScale);
		position.setMaxScale(maxScale);
		position.setManagementRole(managementRole);
		
		return position;
	}
}
