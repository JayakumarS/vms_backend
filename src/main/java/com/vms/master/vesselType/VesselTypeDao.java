package com.vms.master.vesselType;

public interface VesselTypeDao {

	public VesselTypeResultBean save(VesselTypeBean bean);

	public VesselTypeResultBean getList();

	public VesselTypeResultBean edit(String id);

	public VesselTypeResultBean delete(String id);

	public VesselTypeResultBean update(VesselTypeBean bean);

}
