package com.vms.supplies.freightType;



public interface FreightTypeDao {
	
	public FreightTypeResultBean save(FreightTypeBean bean);

	public FreightTypeResultBean getList();

	public FreightTypeResultBean edit(int id);

	public FreightTypeResultBean delete(int id);

	public FreightTypeResultBean update(FreightTypeBean bean);

}
