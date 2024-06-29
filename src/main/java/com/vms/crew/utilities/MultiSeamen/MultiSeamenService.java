package com.vms.crew.utilities.MultiSeamen;

import com.vms.master.Country.CountryBean;

public interface MultiSeamenService {

	public MultiSeamenResultBean saveMultiSeamen(MultiSeamenBean bean);

	public MultiSeamenResultBean listMultiSeamen();

	public MultiSeamenResultBean editMultiSeamen(Integer id);

	public MultiSeamenResultBean deleteMultiSeamen(Integer id);

	public MultiSeamenResultBean updateMultiSeamen(MultiSeamenBean bean);

	public MultiSeamenResultBean checkValid(Integer id);

}
