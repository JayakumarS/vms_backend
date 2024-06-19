package com.vms.master.currency;

import java.util.List;


public class CurrencyBean {
	private String code;
	private String name;
	private Double fromcurren;
	private Double tocurren;
	private Double dvalue;
	public Double getFromcurren() {
		return fromcurren;
	}
	public void setFromcurren(Double fromcurren) {
		this.fromcurren = fromcurren;
	}
	public Double getTocurren() {
		return tocurren;
	}
	public void setTocurren(Double tocurren) {
		this.tocurren = tocurren;
	}
	public Double getDvalue() {
		return dvalue;
	}
	public void setDvalue(Double dvalue) {
		this.dvalue = dvalue;
	}
	public Double getFractpart() {
		return fractpart;
	}
	public void setFractpart(Double fractpart) {
		this.fractpart = fractpart;
	}
	private Double fractpart;
	private String active;
	private String currency;
	private List<CurrencyBean> currencydtls;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<CurrencyBean> getCurrencydtls() {
		return currencydtls;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public void setCurrencydtls(List<CurrencyBean> currencydtls) {
		this.currencydtls = currencydtls;
	}
	
}
