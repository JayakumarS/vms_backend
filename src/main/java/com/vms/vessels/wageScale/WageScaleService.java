package com.vms.vessels.wageScale;


public interface WageScaleService {

	public WageScaleResultBean save(WageScaleBean bean);

	public WageScaleResultBean getList();

	public WageScaleResultBean edit(int id);

	public WageScaleResultBean delete(int id);

	public WageScaleResultBean update(WageScaleBean bean);
	
	WageScaleBean getSequenceCode();

}
