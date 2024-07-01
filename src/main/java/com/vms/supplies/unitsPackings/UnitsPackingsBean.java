package com.vms.supplies.unitsPackings;

import java.util.List;


public class UnitsPackingsBean {
	private String id;
	private String impaUnit;
	private String abbreviation;
	private double conversionFactor;
	private String interfaceCode;
	private String shipservUnit;
	private String procureShipUnit;
	private String mespasUnit;
	private String unitGroup;
	private List<UnitsPackingsBean> list;
	
	public List<UnitsPackingsBean> getList() {
		return list;
	}
	public void setList(List<UnitsPackingsBean> list) {
		this.list = list;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImpaUnit() {
		return impaUnit;
	}
	public void setImpaUnit(String impaUnit) {
		this.impaUnit = impaUnit;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public double getConversionFactor() {
		return conversionFactor;
	}
	public void setConversionFactor(double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}
	public String getInterfaceCode() {
		return interfaceCode;
	}
	public void setInterfaceCode(String interfaceCode) {
		this.interfaceCode = interfaceCode;
	}
	public String getShipservUnit() {
		return shipservUnit;
	}
	public void setShipservUnit(String shipservUnit) {
		this.shipservUnit = shipservUnit;
	}
	public String getProcureShipUnit() {
		return procureShipUnit;
	}
	public void setProcureShipUnit(String procureShipUnit) {
		this.procureShipUnit = procureShipUnit;
	}
	public String getMespasUnit() {
		return mespasUnit;
	}
	public void setMespasUnit(String mespasUnit) {
		this.mespasUnit = mespasUnit;
	}
	public String getUnitGroup() {
		return unitGroup;
	}
	public void setUnitGroup(String unitGroup) {
		this.unitGroup = unitGroup;
	}
	
}
