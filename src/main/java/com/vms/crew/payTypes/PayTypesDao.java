package com.vms.crew.payTypes;



public interface PayTypesDao {
	
	public PayTypesResultBean save(PayTypesBean bean);

	public PayTypesResultBean getList();

	public PayTypesResultBean edit(int id);

	public PayTypesResultBean delete(int id);

	public PayTypesResultBean update(PayTypesBean bean);

}
