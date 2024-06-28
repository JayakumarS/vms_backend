package com.vms.vessels.bunkerTanks;



public interface BunkerTankDao {
	
	public BunkerTankResultBean save(BunkerTankBean bean);

	public BunkerTankResultBean getList();

	public BunkerTankResultBean edit(Integer id);

	public BunkerTankResultBean delete(Integer id);

	public BunkerTankResultBean update(BunkerTankBean bean);


}
