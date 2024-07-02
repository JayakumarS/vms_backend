package com.vms.crew.crewPayrollCurrency;

public class CrewPayrollCurrencyBean {
	private Integer currencyid;
	private String currencycode;
	private String countryname;
	private Boolean validation;
	private String nationality;
	private String countryname1;
	
	public String getCountryname1() {
		return countryname1;
	}
	public void setCountryname1(String countryname1) {
		this.countryname1 = countryname1;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
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
