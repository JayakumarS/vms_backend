package com.vms.common.Languages;



public interface LanguagesDao {

	
	public LanguagesResultBean save(LanguagesBean bean);

	public LanguagesResultBean getList();

	public LanguagesResultBean edit(String id);

	public LanguagesResultBean delete(String id);

	public LanguagesResultBean update(LanguagesBean bean);
}
