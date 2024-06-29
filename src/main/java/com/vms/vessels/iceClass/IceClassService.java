package com.vms.vessels.iceClass;

public interface IceClassService {
	
	public IceClassBean getSequenceCode();
	
	public IceClassResultBean save(IceClassBean bean);
	
	public IceClassResultBean getList();

	public IceClassResultBean edit(Integer id);
	
	public IceClassResultBean delete(Integer id);
	
	public IceClassResultBean update(IceClassBean bean);
	

}
