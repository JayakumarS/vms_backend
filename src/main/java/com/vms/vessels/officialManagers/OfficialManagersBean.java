package com.vms.vessels.officialManagers;

import java.util.List;



public class OfficialManagersBean {
	private String code;
	private String description;
	private String city;
	private String address;
	private String poscode;
	private String phone;
	private String remarks;
    private String blogofilePath;
	public String getBlogofilePath() {
		return blogofilePath;
	}
	public void setBlogofilePath(String blogofilePath) {
		this.blogofilePath = blogofilePath;
	}
	public String getBlogofileName() {
		return blogofileName;
	}
	public void setBlogofileName(String blogofileName) {
		this.blogofileName = blogofileName;
	}
	public String getPlogofilePath() {
		return plogofilePath;
	}
	public void setPlogofilePath(String plogofilePath) {
		this.plogofilePath = plogofilePath;
	}
	public String getPlogofileName() {
		return plogofileName;
	}
	public void setPlogofileName(String plogofileName) {
		this.plogofileName = plogofileName;
	}
	private String blogofileName;
	private String plogofilePath;
	private String plogofileName;
		
	
	
    private List<OfficialManagersBean>officialManagersBeanDtls;

	public List<OfficialManagersBean> getOfficialManagersBeanDtls() {
		return officialManagersBeanDtls;
	}
	public void setOfficialManagersBeanDtls(List<OfficialManagersBean> officialManagersBeanDtls) {
		this.officialManagersBeanDtls = officialManagersBeanDtls;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPoscode() {
		return poscode;
	}
	public void setPoscode(String poscode) {
		this.poscode = poscode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
