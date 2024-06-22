package com.vms.crew.certificates;

import java.util.List;


public class CertificatesBean {

	public String getCertificateId() {
		return certificateId;
	}
	public void setCertificateId(String certificateId) {
		this.certificateId = certificateId;
	}
	private String certificateId;
	private String code;
	private String description;
	private List<CertificatesBean> certificatesBeanDtls;


	
	

	public List<CertificatesBean> getCertificatesBeanDtls() {
		return certificatesBeanDtls;
	}
	public void setCertificatesBeanDtls(List<CertificatesBean> certificatesBeanDtls) {
		this.certificatesBeanDtls = certificatesBeanDtls;
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
	
	
}
