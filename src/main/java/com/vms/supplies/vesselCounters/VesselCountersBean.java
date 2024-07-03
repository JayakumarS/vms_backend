package com.vms.supplies.vesselCounters;

import java.util.List;


public class VesselCountersBean {
	
	private String vessel;
	private String option;
	private Integer startFrom;
	private String type;
	private String id;
	private String dep;
	private List<VesselCountersBean> list;
	
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getVessel() {
		return vessel;
	}
	public void setVessel(String vessel) {
		this.vessel = vessel;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public Integer getStartFrom() {
		return startFrom;
	}
	public void setStartFrom(Integer startFrom) {
		this.startFrom = startFrom;
	}
	public List<VesselCountersBean> getList() {
		return list;
	}
	public void setList(List<VesselCountersBean> list) {
		this.list = list;
	}
}
