package com.vms.master.vesselPrefix;

public interface VesselPrefixDao {

	public VesselPrefixResultBean save(VesselPrefixBean bean);

	public VesselPrefixResultBean getList();

	public VesselPrefixResultBean edit(String id);

	public VesselPrefixResultBean delete(String id);

	public VesselPrefixResultBean update(VesselPrefixBean bean);

}
