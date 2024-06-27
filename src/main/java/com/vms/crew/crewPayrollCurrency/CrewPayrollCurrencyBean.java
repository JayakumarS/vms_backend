package com.vms.crew.crewPayrollCurrency;

public class CrewPayrollCurrencyBean {
	private Integer currencyid;
	private String currencycode;
	private String countryname;
	private Boolean validation;
	public Integer getCurrencyid() {
		return currencyid;
	}
	public void setCurrencyid(Integer currencyid) {
		this.currencyid = currencyid;
	}
	public String getCurrencycode() {
		return currencycode;
	}
	public void setCurrencycode(String currencycode) {
		this.currencycode = currencycode;
	}
	public String getCountryname() {
		return countryname;
	}
	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}
	public Boolean getValidation() {
		return validation;
	}
	public void setValidation(Boolean validation) {
		this.validation = validation;
	}

}
