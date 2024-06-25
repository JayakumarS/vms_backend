package com.vms.common.Languages;


public interface LanguagesService {

	public LanguagesResultBean save(LanguagesBean bean);

	public LanguagesResultBean getList();

	public LanguagesResultBean edit(int id);

	public LanguagesResultBean delete(int id);

	public LanguagesResultBean update(LanguagesBean bean);
}
