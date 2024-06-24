package com.vms.vessels.Class;



public interface ClassService {

	public ClassResultBean save(ClassBean bean);

	public ClassResultBean getList();

	public ClassResultBean edit(int id);

	public ClassResultBean delete(int id);

	public ClassResultBean update(ClassBean bean);
}
