package com.impace.farmERP.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FarmRegistration")
public class FarmRegistration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "farmId")
	private int farmId;
	@Column(name = "farmName")
	private String farmName;
	@Column(name = "gatNo")
	private int gatNo;
	
	public int getFarmId() {
		return farmId;
	}
	public void setFarmId(int farmId) {
		this.farmId = farmId;
	}
	public String getFarmName() {
		return farmName;
	}
	public void setFarmName(String farmName) {
		this.farmName = farmName;
	}
	public int getGatNo() {
		return gatNo;
	}
	public void setGatNo(int gatNo) {
		this.gatNo = gatNo;
	}
}
