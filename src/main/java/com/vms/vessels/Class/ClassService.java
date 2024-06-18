package com.vms.vessels.Class;



public interface ClassService {

	public ClassResultBean save(ClassBean bean);

	public ClassResultBean getList();

	public ClassResultBean edit(String id);

	public ClassResultBean delete(String id);

	public ClassResultBean update(ClassBean bean);
}
