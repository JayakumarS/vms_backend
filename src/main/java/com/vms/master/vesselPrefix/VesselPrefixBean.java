package com.vms.master.vesselPrefix;

import java.util.List;

public class VesselPrefixBean {
	private String code;
	private String description;
	private List<VesselPrefixBean> firstDetailRow;

	public List<VesselPrefixBean> getFirstDetailRow() {
		return firstDetailRow;
	}
	public void setFirstDetailRow(List<VesselPrefixBean> firstDetailRow) {
		this.firstDetailRow = firstDetailRow;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getVesselprefixid() {
		return vesselprefixid;
	}
	public void setVesselprefixid(Integer vesselprefixid) {
		this.vesselprefixid = vesselprefixid;
	}
	private Integer vesselprefixid;
}
