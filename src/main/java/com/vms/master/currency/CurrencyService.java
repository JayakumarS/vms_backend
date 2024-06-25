package com.vms.master.currency;

public interface CurrencyService {
	
	public CurrencyResultBean save(CurrencyBean bean);

	public CurrencyResultBean getList();

	public CurrencyResultBean edit(Integer id);

	public CurrencyResultBean delete(Integer id);

	public CurrencyResultBean update(CurrencyBean bean);


}
