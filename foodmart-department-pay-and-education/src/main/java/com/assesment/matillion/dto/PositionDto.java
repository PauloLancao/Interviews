package com.assesment.matillion.dto;

import java.math.BigDecimal;

public final class PositionDto {

	private int positionId;
	private String positionTitle;
	private String payType;
	private BigDecimal minScale;
	private BigDecimal maxScale;
	private String managementRole;

	public int getPositionId() {
		return positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

	public String getPositionTitle() {
		return positionTitle;
	}

	public void setPositionTitle(String positionTitle) {
		this.positionTitle = positionTitle;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public BigDecimal getMinScale() {
		return minScale;
	}

	public void setMinScale(BigDecimal minScale) {
		this.minScale = minScale;
	}

	public BigDecimal getMaxScale() {
		return maxScale;
	}

	public void setMaxScale(BigDecimal maxScale) {
		this.maxScale = maxScale;
	}

	public String getManagementRole() {
		return managementRole;
	}

	public void setManagementRole(String managementRole) {
		this.managementRole = managementRole;
	}
}
