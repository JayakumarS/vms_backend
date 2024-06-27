package com.vms.crew.maintain.OffSign;

public interface OffSignService {

	public OffSignResultBean saveOffSign(OffSignBean bean);

	public OffSignResultBean listOffSign();

	public OffSignResultBean editOffSign(Integer id);

	public OffSignResultBean updateOffSign(OffSignBean bean);

	public OffSignResultBean deleteOffSign(Integer id);

}
