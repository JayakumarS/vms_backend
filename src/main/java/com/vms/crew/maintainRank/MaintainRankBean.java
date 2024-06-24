package com.vms.crew.maintainRank;

import java.util.List;

import com.vms.master.vesselType.VesselTypeBean;

public class MaintainRankBean {
	private List<MaintainRankBean> maintainRankBeanDtls;
	
	private String code;
	private String description;
	private Integer groupage;
	private Boolean oAndt;
	private String department;
	private Integer sno;
	private String remarks;
	
	public List<MaintainRankBean> getMaintainRankBeanDtls() {
		return maintainRankBeanDtls;
	}
	public void setMaintainRankBeanDtls(List<MaintainRankBean> maintainRankBeanDtls) {
		this.maintainRankBeanDtls = maintainRankBeanDtls;
	}
	public Integer getSno() {
		return sno;
	}
	public void setSno(Integer sno) {
		this.sno = sno;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	public Integer getGroupage() {
		return groupage;
	}
	public void setGroupage(Integer groupage) {
		this.groupage = groupage;
	}

	public Boolean getoAndt() {
		return oAndt;
	}
	public void setoAndt(Boolean oAndt) {
		this.oAndt = oAndt;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}


	
	private String id;
	private String text;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
