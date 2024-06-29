package com.vms.master.vesselType;

public interface VesselTypeService {

	public VesselTypeResultBean save(VesselTypeBean bean);

	public VesselTypeResultBean getList();

	public VesselTypeResultBean edit(Integer id);

	public VesselTypeResultBean delete(Integer id);

	public VesselTypeResultBean update(VesselTypeBean bean);

}
