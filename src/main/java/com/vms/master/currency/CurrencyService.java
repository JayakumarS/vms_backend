package com.vms.master.currency;

public interface CurrencyService {
	
	public CurrencyResultBean save(CurrencyBean bean);

	public CurrencyResultBean getList();

	public CurrencyResultBean edit(String id);

	public CurrencyResultBean delete(String id);

	public CurrencyResultBean update(CurrencyBean bean);


}
