package com.vms.crew.maintainRank;

import java.util.List;

import com.vms.master.vesselType.VesselTypeBean;

public class MaintainRankBean {
	private List<MaintainRankBean> maintainRankBeanDtls;
	private String groupagename;
	public String getGroupagename() {
		return groupagename;
	}
	public void setGroupagename(String groupagename) {
		this.groupagename = groupagename;
	}
	public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}



	private String departmentname;
	private String code;
	private String description;
	private Integer groupage;
	private Boolean oAndt;
	private Integer department;
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
	public Integer getDepartment() {
		return department;
	}
	public void setDepartment(Integer department) {
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
	
	private Boolean isActive;

	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	private Integer rankid;

	public Integer getRankid() {
		return rankid;
	}
	public void setRankid(Integer rankid) {
		this.rankid = rankid;
	}
}
