package com.vms.supplies.identifiersLibrary;

public interface IdentifiersLibraryService {
	
	public IdentifiersLibraryResultBean save(IdentifiersLibraryBean bean);
	
	public IdentifiersLibraryResultBean savestorage(IdentifiersLibraryBean bean);
	
	public IdentifiersLibraryResultBean savefunction(IdentifiersLibraryBean bean);
	
	public IdentifiersLibraryResultBean edit(Integer id);
	
	public IdentifiersLibraryResultBean editstorage(Integer id);
	
	public IdentifiersLibraryResultBean editfunction(Integer id);
	
	public IdentifiersLibraryResultBean editdelivery(Integer id);
	
	public IdentifiersLibraryResultBean getList3();
	
	public IdentifiersLibraryResultBean saveitemdelilvery(IdentifiersLibraryBean bean);
	
	public IdentifiersLibraryResultBean getList();
	
	public IdentifiersLibraryResultBean getList1();
	
	public IdentifiersLibraryResultBean delete(int id);
	
	public IdentifiersLibraryResultBean deletestorage(int id);
	
	public IdentifiersLibraryResultBean deletefunction(int id);
	
	public IdentifiersLibraryResultBean deletedelivery(int id);

	
	public IdentifiersLibraryResultBean update(IdentifiersLibraryBean bean);
	
	public IdentifiersLibraryResultBean updatestorage(IdentifiersLibraryBean bean);
	
	public IdentifiersLibraryResultBean updatefunction(IdentifiersLibraryBean bean);
	
	public IdentifiersLibraryResultBean updatedelivery(IdentifiersLibraryBean bean);

	
	public IdentifiersLibraryResultBean getList2();
	
	public IdentifiersLibraryBean getCodemax();
	
	IdentifiersLibraryBean getSequenceCode();



}
