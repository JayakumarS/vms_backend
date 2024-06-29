package com.vms.vessels.iceClass;

import java.util.List;



public class IceClassBean {
	
	private  Integer iceId;
	private Integer code;
	private String desc;
	private List<IceClassBean> iceClassdtls;
	
	public Integer getIceId() {
		return iceId;
	}
	public List<IceClassBean> getIceClassdtls() {
		return iceClassdtls;
	}
	public void setIceClassdtls(List<IceClassBean> iceClassdtls) {
		this.iceClassdtls = iceClassdtls;
	}
	public void setIceId(Integer iceId) {
		this.iceId = iceId;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	

}
