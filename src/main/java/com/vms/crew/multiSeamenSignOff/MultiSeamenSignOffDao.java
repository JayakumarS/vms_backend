package com.vms.crew.multiSeamenSignOff;

import java.util.List;

public interface MultiSeamenSignOffDao {
	
	public  List<MultiSeamenSignOffBean> multiSemanlist(String date,String vessel ,Integer port);


	
	public boolean saveMultiSeamen(MultiSeamenSignOffBean MultiSeamenSignOffBean);



	boolean saveMultiSeamendetail(MultiSeamenSignOffBean multiSeamenSignOffBean, Integer headerId);

}
