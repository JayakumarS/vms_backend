package com.vms.crew.expEngine;



public interface ExpEngineDao {
	
	public ExpEngineResultBean save(ExpEngineBean bean);

	public ExpEngineResultBean getList();

	public ExpEngineResultBean edit(String id);

	public ExpEngineResultBean delete(String id);

	public ExpEngineResultBean update(ExpEngineBean bean);

}
