package com.vms.crew.maintain.OffSign;

public interface OffSignDao {

	public OffSignResultBean saveOffSign(OffSignBean bean);

	public OffSignResultBean savedetail(OffSignBean bean, Integer code);

	public OffSignResultBean listOffSign();

	public OffSignResultBean editOffSign(Integer id);

	public OffSignResultBean deleteOffSign(Integer id);

	public OffSignResultBean updateOffSign(OffSignBean bean);

}
