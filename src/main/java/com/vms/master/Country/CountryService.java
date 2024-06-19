package com.vms.master.Country;

public interface CountryService {

	public CountryResultBean saveCountry(CountryBean bean);

	public CountryResultBean listCountry();

	public CountryResultBean editCountry(String id);

	public CountryResultBean updateCountry(CountryBean bean);

	public CountryResultBean deleteCountry(String id);

}
