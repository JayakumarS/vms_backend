package com.vms.vessels.wageScale;


public interface WageScaleService {

	public WageScaleResultBean save(WageScaleBean bean);

	public WageScaleResultBean getList();

	public WageScaleResultBean edit(String id);

	public WageScaleResultBean delete(String id);

	public WageScaleResultBean update(WageScaleBean bean);
}
