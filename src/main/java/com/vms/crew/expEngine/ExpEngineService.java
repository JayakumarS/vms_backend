package com.vms.crew.expEngine;

public interface ExpEngineService {
	
	public ExpEngineResultBean save(ExpEngineBean bean);

	public ExpEngineResultBean getList();

	public ExpEngineResultBean edit(int id);

	public ExpEngineResultBean delete(int id);

	public ExpEngineResultBean update(ExpEngineBean bean);

}
