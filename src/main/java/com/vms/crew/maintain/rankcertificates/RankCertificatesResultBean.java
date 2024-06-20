package com.vms.crew.maintain.rankcertificates;

import java.util.List;


public class RankCertificatesResultBean {

	public boolean success;


	private List<RankCertificatesBean> list;


	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}


	public List<RankCertificatesBean> getList() {
		return list;
	}


	public void setList(List<RankCertificatesBean> list) {
		this.list = list;
	}
}
