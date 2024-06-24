package com.vms.master.UOM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.master.Port.PortService;

@Service
public class UOMServiceImpl implements UOMService{
	
	@Autowired
	UOMDao uomDao;
	
	@Override
	public UOMResultBean saveUom(UOMBean bean) {
		// TODO Auto-generated method stub
		return uomDao.saveUom(bean);
	}
	
	@Override
	public UOMResultBean listUom() {
		// TODO Auto-generated method stub
		return uomDao.listUom();
	}
	
	@Override
	public UOMResultBean editUom(Integer id) {
		// TODO Auto-generated method stub
		return uomDao.editUom(id);
	}
	

	@Override
	public UOMResultBean deleteUom(String id) {
		// TODO Auto-generated method stub
		return uomDao.deleteUom(id);
	}

	@Override
	public UOMResultBean updateUom(UOMBean bean) {
		// TODO Auto-generated method stub
		return uomDao.updateUom(bean);
	
	}


}
