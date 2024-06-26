package com.vms.master.religion;

public interface ReligionDao {

	public ReligionResultBean save(ReligionBean bean);

	public ReligionResultBean getList();

	public 	ReligionResultBean edit(String id);

	public ReligionResultBean update(ReligionBean bean);

	public ReligionResultBean delete(String id);

	public ReligionBean getSequenceCode();

	
}
