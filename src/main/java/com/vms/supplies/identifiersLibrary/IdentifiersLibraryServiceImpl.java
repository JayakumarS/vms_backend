package com.vms.supplies.identifiersLibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.crew.certificates.CertificatesBean;
import com.vms.crew.trainings.TrainingsResultBean;
import com.vms.supplies.freightType.FreightTypeBean;
import com.vms.supplies.freightType.FreightTypeResultBean;




@Service
public class IdentifiersLibraryServiceImpl implements IdentifiersLibraryService {
	
	@Autowired
	IdentifiersLibraryDao IdentifiersLibraryDao;
	
	@Override
	public IdentifiersLibraryResultBean save(IdentifiersLibraryBean bean) {
		// TODO Auto-generated method stub
		return IdentifiersLibraryDao.save(bean);
	}
	
	@Override
	public IdentifiersLibraryResultBean savestorage(IdentifiersLibraryBean bean) {
		// TODO Auto-generated method stub
		return IdentifiersLibraryDao.savestorage(bean);
	}
	
	@Override
	public IdentifiersLibraryResultBean savefunction(IdentifiersLibraryBean bean) {
		// TODO Auto-generated method stub
		return IdentifiersLibraryDao.savefunction(bean);
	}
	
	@Override
	public IdentifiersLibraryResultBean saveitemdelilvery(IdentifiersLibraryBean bean) {
		// TODO Auto-generated method stub
		return IdentifiersLibraryDao.saveitemdelilvery(bean);
	}
	
	@Override
	public IdentifiersLibraryResultBean savelocation(IdentifiersLibraryBean bean) {
		// TODO Auto-generated method stub
		return IdentifiersLibraryDao.savelocation(bean);
	}
	
	@Override
	public IdentifiersLibraryResultBean saveluboil(IdentifiersLibraryBean bean) {
		// TODO Auto-generated method stub
		return IdentifiersLibraryDao.saveluboil(bean);
	}
	
	@Override
	public IdentifiersLibraryResultBean edit(Integer id) {
		// TODO Auto-generated method stub
		return IdentifiersLibraryDao.edit(id);
	}
	
	@Override
	public IdentifiersLibraryResultBean editstorage(Integer id) {
		// TODO Auto-generated method stub
		return IdentifiersLibraryDao.editstorage(id);
	}
	
	@Override
	public IdentifiersLibraryResultBean editfunction(Integer id) {
		// TODO Auto-generated method stub
		return IdentifiersLibraryDao.editfunction(id);
	}
	
	@Override
	public IdentifiersLibraryResultBean editdelivery(Integer id) {
		// TODO Auto-generated method stub
		return IdentifiersLibraryDao.editdelivery(id);
	}
	
	@Override
	public IdentifiersLibraryResultBean editlocation(Integer id) {
		// TODO Auto-generated method stub
		return IdentifiersLibraryDao.editlocation(id);
	}
	
	@Override
	public IdentifiersLibraryResultBean editluboil(Integer id) {
		// TODO Auto-generated method stub
		return IdentifiersLibraryDao.editluboil(id);
	}
	
	
	@Override
	public IdentifiersLibraryResultBean getList() {
		// TODO Auto-generated method stub
		return IdentifiersLibraryDao.getList();
	}
	
	@Override
	public IdentifiersLibraryResultBean getList1() {
		// TODO Auto-generated method stub
		return IdentifiersLibraryDao.getList1();
	}
	
	@Override
	public IdentifiersLibraryResultBean getList2() {
		// TODO Auto-generated method stub
		return IdentifiersLibraryDao.getList2();
	}
	
	@Override
	public IdentifiersLibraryResultBean getList3() {
		// TODO Auto-generated method stub
		return IdentifiersLibraryDao.getList3();
	}
	
	@Override
	public IdentifiersLibraryResultBean getLocationlist() {
		// TODO Auto-generated method stub
		return IdentifiersLibraryDao.getLocationlist();
	}
	
	@Override
	public IdentifiersLibraryResultBean getLuboillist() {
		// TODO Auto-generated method stub
		return IdentifiersLibraryDao.getLuboillist();
	}
	
	@Override
	public IdentifiersLibraryBean getCodemax() {
		// TODO Auto-generated method stub
		return IdentifiersLibraryDao.getCodemax();
	}
	
	@Override
	public IdentifiersLibraryBean getSequenceCode() {
		return IdentifiersLibraryDao.getSequenceCode();
	}
	
	
	@Override
	public IdentifiersLibraryResultBean update(IdentifiersLibraryBean bean) {
		// TODO Auto-generated method stub
		return IdentifiersLibraryDao.update(bean);
	}
	
	@Override
	public IdentifiersLibraryResultBean updatestorage(IdentifiersLibraryBean bean) {
		// TODO Auto-generated method stub
		return IdentifiersLibraryDao.updatestorage(bean);
	}
	
	@Override
	public IdentifiersLibraryResultBean updatefunction(IdentifiersLibraryBean bean) {
		// TODO Auto-generated method stub
		return IdentifiersLibraryDao.updatefunction(bean);
	}
	@Override
	public IdentifiersLibraryResultBean updatedelivery(IdentifiersLibraryBean bean) {
		// TODO Auto-generated method stub
		return IdentifiersLibraryDao.updatedelivery(bean);
	}
	
	@Override
	public IdentifiersLibraryResultBean updatelocation(IdentifiersLibraryBean bean) {
		// TODO Auto-generated method stub
		return IdentifiersLibraryDao.updatelocation(bean);
	}
	
	@Override
	public IdentifiersLibraryResultBean updateluboil(IdentifiersLibraryBean bean) {
		// TODO Auto-generated method stub
		return IdentifiersLibraryDao.updateluboil(bean);
	}
	
	
	@Override
	public IdentifiersLibraryResultBean delete(int id) {
		// TODO Auto-generated method stub
		return IdentifiersLibraryDao.delete(id);
	}

	

	@Override
	public IdentifiersLibraryResultBean deletestorage(int id) {
		// TODO Auto-generated method stub
		return IdentifiersLibraryDao.deletestorage(id);
	}
	
	@Override
	public IdentifiersLibraryResultBean deletefunction(int id) {
		// TODO Auto-generated method stub
		return IdentifiersLibraryDao.deletefunction(id);
	}
	
	@Override
	public IdentifiersLibraryResultBean deletedelivery(int id) {
		// TODO Auto-generated method stub
		return IdentifiersLibraryDao.deletedelivery(id);
	}
	
	@Override
	public IdentifiersLibraryResultBean deletelocation(int id) {
		// TODO Auto-generated method stub
		return IdentifiersLibraryDao.deletelocation(id);
	}
	
	@Override
	public IdentifiersLibraryResultBean deleteluboil(int id) {
		// TODO Auto-generated method stub
		return IdentifiersLibraryDao.deleteluboil(id);
	}


}
