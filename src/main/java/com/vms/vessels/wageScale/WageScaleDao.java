package com.vms.vessels.wageScale;


public interface WageScaleDao {

	
	public WageScaleResultBean save(WageScaleBean bean);

	public WageScaleResultBean getList();

	public WageScaleResultBean edit(int id);

	public WageScaleResultBean delete(int id);

	public WageScaleResultBean update(WageScaleBean bean);
}
