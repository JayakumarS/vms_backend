package com.vms.supplies.unitsPackings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UnitsPackingsServiceImpl implements UnitsPackingsService{
	
	@Autowired
	UnitsPackingsDao unitsPackingsService;
	
	@Override
	public UnitsPackingsResultBean save(UnitsPackingsBean bean) {
		// TODO Auto-generated method stub
		return unitsPackingsService.save(bean);
	}

	@Override
	public UnitsPackingsResultBean getList() {
		// TODO Auto-generated method stub
		return unitsPackingsService.getList();
	}

	@Override
	public UnitsPackingsResultBean delete(String id) {
		// TODO Auto-generated method stub
		return unitsPackingsService.delete(id);
	}

	@Override
	public UnitsPackingsResultBean edit(String id) {
		// TODO Auto-generated method stub
		return unitsPackingsService.edit(id);
	}

	@Override
	public UnitsPackingsResultBean update(UnitsPackingsBean bean) {
		// TODO Auto-generated method stub
		return unitsPackingsService.update(bean);
	}

	@Override
	public String generateCode() {
		// TODO Auto-generated method stub
		return unitsPackingsService.generateCode();
	}

}
