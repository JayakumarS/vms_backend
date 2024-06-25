package com.vms.vessels.shipManagers;

import java.util.List;



public class ShipManagersBean {
	
	private String shipman;
	private Integer shipmanid;


	public String getShipman() {
		return shipman;
	}

	public Integer getShipmanid() {
		return shipmanid;
	}

	public void setShipmanid(Integer shipmanid) {
		this.shipmanid = shipmanid;
	}

	public void setShipman(String shipman) {
		this.shipman = shipman;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getVatreg() {
		return vatreg;
	}

	public void setVatreg(String vatreg) {
		this.vatreg = vatreg;
	}

	public List<ShipManagersBean> getShipManagersBeanDtls() {
		return shipManagersBeanDtls;
	}

	public void setShipManagersBeanDtls(List<ShipManagersBean> shipManagersBeanDtls) {
		this.shipManagersBeanDtls = shipManagersBeanDtls;
	}

	private String name;
	private String remarks;
	private String vatreg;
	
	private List<ShipManagersBean> shipManagersBeanDtls;


}
