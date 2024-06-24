package com.vms.crew.rankGroup;

import java.util.List;


public class RankGroupBean {
	public Integer getRankgroupid() {
		return rankgroupid;
	}
	public void setRankgroupid(Integer rankgroupid) {
		this.rankgroupid = rankgroupid;
	}
	private Integer rankgroupid;
	private String remarks;
	
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	private String code;
	private String description;
	private List<RankGroupBean> rankGroupDtls;


	public String getCode() {
		return code;
	}
	public List<RankGroupBean> getRankGroupDtls() {
		return rankGroupDtls;
	}
	public void setRankGroupDtls(List<RankGroupBean> rankGroupDtls) {
		this.rankGroupDtls = rankGroupDtls;
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
