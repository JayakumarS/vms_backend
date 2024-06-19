package com.vms.crew.certificates;

import java.util.List;


public class CertificatesResultBean {

	

	
	public boolean success;


	private List<CertificatesBean> list;
	public List<CertificatesBean> getList() {
		return list;
	}

	public void setList(List<CertificatesBean> list) {
		this.list = list;
	}

	public CertificatesBean getCertificatesBean() {
		return certificatesBean;
	}

	public void setCertificatesBean(CertificatesBean certificatesBean) {
		this.certificatesBean = certificatesBean;
	}

	private CertificatesBean certificatesBean;

	



	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}
