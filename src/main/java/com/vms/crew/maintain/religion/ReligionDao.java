package com.vms.crew.maintain.religion;

public interface ReligionDao {

	public ReligionResultBean save(ReligionBean bean);

	public ReligionResultBean getList();

	public 	ReligionResultBean edit(String id);

	public ReligionResultBean update(ReligionBean bean);

	public ReligionResultBean delete(String id);

	
}
