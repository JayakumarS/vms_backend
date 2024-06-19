package com.vms.master.UOM;

public interface UOMDao {

	public UOMResultBean saveUom(UOMBean bean);

	public UOMResultBean listUom();

	public UOMResultBean editUom(String id);

	public UOMResultBean deleteUom(String id);

	public UOMResultBean updateUom(UOMBean bean);

}
