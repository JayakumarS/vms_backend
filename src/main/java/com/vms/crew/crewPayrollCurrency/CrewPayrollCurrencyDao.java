package com.vms.crew.crewPayrollCurrency;



public interface CrewPayrollCurrencyDao {
	
	public CrewPayrollCurrencyResultBean save(CrewPayrollCurrencyBean bean);

	public CrewPayrollCurrencyResultBean getList();

	public CrewPayrollCurrencyResultBean edit(int id);

	public CrewPayrollCurrencyResultBean delete(int id);
	
	public CrewPayrollCurrencyResultBean getCountry(Integer id);
	
	public CrewPayrollCurrencyResultBean getNationality(String id);


	public CrewPayrollCurrencyResultBean update(CrewPayrollCurrencyBean bean);

}
