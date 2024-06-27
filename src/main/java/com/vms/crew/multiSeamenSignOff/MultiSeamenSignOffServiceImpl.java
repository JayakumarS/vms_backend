package com.vms.crew.multiSeamenSignOff;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MultiSeamenSignOffServiceImpl implements MultiSeamenSignOffService{


	@Autowired
	MultiSeamenSignOffDao MultiSeamenSignOffDao;
	
	@Override
	public  List<MultiSeamenSignOffBean> multiSemanlist(String date,String vessel ,Integer port) {
		return MultiSeamenSignOffDao.multiSemanlist(date,vessel,port);
 	}
}
