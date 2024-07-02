package com.vms.supplies.identifiersLibrary;

import com.vms.supplies.freightType.FreightTypeBean;
import com.vms.supplies.freightType.FreightTypeResultBean;

public interface IdentifiersLibraryDao {
	
	public IdentifiersLibraryResultBean save(IdentifiersLibraryBean bean);
	
	public IdentifiersLibraryResultBean savestorage(IdentifiersLibraryBean bean);
	
	public IdentifiersLibraryResultBean savefunction(IdentifiersLibraryBean bean);
	
	public IdentifiersLibraryResultBean saveitemdelilvery(IdentifiersLibraryBean bean);
	
	public IdentifiersLibraryResultBean savelocation(IdentifiersLibraryBean bean);
	
	public IdentifiersLibraryResultBean saveluboil(IdentifiersLibraryBean bean);
	
	public IdentifiersLibraryResultBean savepayment(IdentifiersLibraryBean bean);
	
	public IdentifiersLibraryResultBean saveoffice(IdentifiersLibraryBean bean);
	
	public IdentifiersLibraryResultBean edit(Integer id);
	
	public IdentifiersLibraryResultBean editstorage(Integer id);
	
	public IdentifiersLibraryResultBean editfunction(Integer id);
	
	public IdentifiersLibraryResultBean editdelivery(Integer id);
	
	public IdentifiersLibraryResultBean editlocation(Integer id);
	
	public IdentifiersLibraryResultBean editluboil(Integer id);
	
	public IdentifiersLibraryResultBean editpayment(Integer id);
	
	public IdentifiersLibraryResultBean editoffice(Integer id);
	
	public IdentifiersLibraryResultBean getList();
	
	public IdentifiersLibraryResultBean delete(int id);
	
	public IdentifiersLibraryResultBean deletestorage(int id);
	
	public IdentifiersLibraryResultBean deletefunction(int id);
	
	public IdentifiersLibraryResultBean deletedelivery(int id);
	
	public IdentifiersLibraryResultBean deletelocation(int id);
	
	public IdentifiersLibraryResultBean deleteluboil(int id);
	
	public IdentifiersLibraryResultBean deletepayment(int id);
	
	public IdentifiersLibraryResultBean deleteoffice(int id);
	
	public IdentifiersLibraryResultBean update(IdentifiersLibraryBean bean);
	
	public IdentifiersLibraryResultBean updatestorage(IdentifiersLibraryBean bean);
	
	public IdentifiersLibraryResultBean updatefunction(IdentifiersLibraryBean bean);
	
	public IdentifiersLibraryResultBean updatedelivery(IdentifiersLibraryBean bean);
	
	public IdentifiersLibraryResultBean updatelocation(IdentifiersLibraryBean bean);
	
	public IdentifiersLibraryResultBean updateluboil(IdentifiersLibraryBean bean);
	
	public IdentifiersLibraryResultBean updatepayment(IdentifiersLibraryBean bean);
	
	public IdentifiersLibraryResultBean updateoffice(IdentifiersLibraryBean bean);

	
	public IdentifiersLibraryResultBean getList1();
	
	public IdentifiersLibraryResultBean getList2();
	
	public IdentifiersLibraryResultBean getList3();
	
	public IdentifiersLibraryResultBean getLocationlist();
	
	public IdentifiersLibraryResultBean getLuboillist();
	
	public IdentifiersLibraryResultBean getPaymentlist();
	
	public IdentifiersLibraryResultBean getOfficelist();
	
	public IdentifiersLibraryBean getCodemax();
	
	IdentifiersLibraryBean getSequenceCode();





}
