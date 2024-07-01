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


}
