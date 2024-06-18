package com.vms.crew.rankGroup;

import java.util.List;


public class RankGroupResultBean {

	
	public boolean success;
	private List<RankGroupBean> list;
	private RankGroupBean rankGroupBean;



	public List<RankGroupBean> getList() {
		return list;
	}

	public void setList(List<RankGroupBean> list) {
		this.list = list;
	}

	

	public RankGroupBean getRankGroupBean() {
		return rankGroupBean;
	}

	public void setRankGroupBean(RankGroupBean rankGroupBean) {
		this.rankGroupBean = rankGroupBean;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
