package com.vms.master.vesselPrefix;

public interface VesselPrefixDao {

	public VesselPrefixResultBean save(VesselPrefixBean bean);

	public VesselPrefixResultBean getList();

	public VesselPrefixResultBean edit(Integer id);

	public VesselPrefixResultBean delete(Integer id);

	public VesselPrefixResultBean update(VesselPrefixBean bean);

}
