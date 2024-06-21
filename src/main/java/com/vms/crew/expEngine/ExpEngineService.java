package com.vms.crew.expEngine;

public interface ExpEngineService {
	
	public ExpEngineResultBean save(ExpEngineBean bean);

	public ExpEngineResultBean getList();

	public ExpEngineResultBean edit(String id);

	public ExpEngineResultBean delete(String id);

	public ExpEngineResultBean update(ExpEngineBean bean);

}
