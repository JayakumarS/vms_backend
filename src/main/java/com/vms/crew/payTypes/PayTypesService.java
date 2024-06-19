package com.vms.crew.payTypes;



public interface PayTypesService {
	
	public PayTypesResultBean save(PayTypesBean bean);

	public PayTypesResultBean getList();

	public PayTypesResultBean edit(String id);

	public PayTypesResultBean delete(String id);

	public PayTypesResultBean update(PayTypesBean bean);

}
