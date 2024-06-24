package com.vms.master.UOM;

public interface UOMService {

	public UOMResultBean saveUom(UOMBean bean);

	public UOMResultBean listUom();

	public UOMResultBean editUom(Integer id);

	public UOMResultBean deleteUom(String id);

	public UOMResultBean updateUom(UOMBean bean);


}
