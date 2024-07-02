package com.vms.supplies.LandingProperties;

public interface LandingPropertiesDao {

	public LandingPropertiesResultBean save(LandingPropertiesBean bean);

	public LandingPropertiesResultBean list();

	public LandingPropertiesResultBean edit(Integer id);

	public LandingPropertiesResultBean delete(String id);

	public LandingPropertiesResultBean update(LandingPropertiesBean bean);

}
