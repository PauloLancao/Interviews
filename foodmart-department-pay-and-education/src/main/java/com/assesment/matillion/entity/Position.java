package com.assesment.matillion.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "position")
public class Position implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "position_id")
	private int positionId;

	@Column(name = "position_title")
	private String positionTitle;

	@Column(name = "pay_type")
	private String payType;

	@Column(name = "min_scale")
	private BigDecimal minScale;

	@Column(name = "max_scale")
	private BigDecimal maxScale;

	@Column(name = "management_role")
	private String managementRole;

	public Position() {
	}

	public String getManagementRole() {
		return this.managementRole;
	}

	public void setManagementRole(String managementRole) {
		this.managementRole = managementRole;
	}

	public BigDecimal getMaxScale() {
		return this.maxScale;
	}

	public void setMaxScale(BigDecimal maxScale) {
		this.maxScale = maxScale;
	}

	public BigDecimal getMinScale() {
		return this.minScale;
	}

	public void setMinScale(BigDecimal minScale) {
		this.minScale = minScale;
	}

	public String getPayType() {
		return this.payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public int getPositionId() {
		return this.positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

	public String getPositionTitle() {
		return this.positionTitle;
	}

	public void setPositionTitle(String positionTitle) {
		this.positionTitle = positionTitle;
	}
}
