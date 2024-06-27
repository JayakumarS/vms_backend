package com.vms.crew.maintain.OffSign;

import java.util.List;


public class OffSignBean {
	
	public String offSignVesselType;
	private String remarks;
	
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	private List<OffSignBean> offSignDetail;


	//// Detail Bean
	
	public List<OffSignBean> getOffSignDetail() {
		return offSignDetail;
	}
	public void setOffSignDetail(List<OffSignBean> offSignDetail) {
		this.offSignDetail = offSignDetail;
	}
	public Integer offSignNationality;
	public Integer offSignRank;
	public Integer offSignMonth;
	public String createdDate;
	public String createdBy;
	public Integer offSignId;

	public Integer getOffSignId() {
		return offSignId;
	}
	public void setOffSignId(Integer offSignId) {
		this.offSignId = offSignId;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getOffSignVesselType() {
		return offSignVesselType;
	}
	public void setOffSignVesselType(String offSignVesselType) {
		this.offSignVesselType = offSignVesselType;
	}
	public Integer getOffSignNationality() {
		return offSignNationality;
	}
	public void setOffSignNationality(Integer offSignNationality) {
		this.offSignNationality = offSignNationality;
	}
	public Integer getOffSignRank() {
		return offSignRank;
	}
	public void setOffSignRank(Integer offSignRank) {
		this.offSignRank = offSignRank;
	}
	public Integer getOffSignMonth() {
		return offSignMonth;
	}
	public void setOffSignMonth(Integer offSignMonth) {
		this.offSignMonth = offSignMonth;
	}
	
}
