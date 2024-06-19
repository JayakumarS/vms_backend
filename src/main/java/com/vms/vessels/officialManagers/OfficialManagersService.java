package com.vms.vessels.officialManagers;



public interface OfficialManagersService {
	
	public OfficialManagersResultBean save(OfficialManagersBean bean);

	public OfficialManagersResultBean getList();

	public OfficialManagersResultBean edit(String id);

	public OfficialManagersResultBean delete(String id);

	public OfficialManagersResultBean update(OfficialManagersBean bean);

}
