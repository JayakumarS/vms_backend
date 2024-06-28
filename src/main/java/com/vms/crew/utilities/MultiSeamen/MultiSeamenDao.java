package com.vms.crew.utilities.MultiSeamen;

public interface MultiSeamenDao {

	public MultiSeamenResultBean saveMultiSeamen(MultiSeamenBean bean);

	MultiSeamenResultBean savedetail(MultiSeamenBean bean, Integer code);

	public MultiSeamenResultBean listMultiSeamen();

	public MultiSeamenResultBean editMultiSeamen(Integer id);

	public MultiSeamenResultBean deleteMultiSeamen(Integer id);

	public MultiSeamenResultBean updateMultiSeamen(MultiSeamenBean bean);
	

}
