package com.vms.supplies.LandingProperties;

public interface LandingPropertiesService {

	public LandingPropertiesResultBean save(LandingPropertiesBean bean);

	public LandingPropertiesResultBean list();

	public LandingPropertiesResultBean edit(Integer id);

	public LandingPropertiesResultBean update(LandingPropertiesBean bean);

	public LandingPropertiesResultBean delete(String id);

}
