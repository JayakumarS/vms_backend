package com.vms.crew.utilities.MultiSeamen;

public interface MultiSeamenDao {

	public MultiSeamenResultBean saveMultiSeamen(MultiSeamenBean bean);

	MultiSeamenResultBean savedetail(MultiSeamenBean bean, Integer code);
	

}
