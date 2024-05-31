package com.vms.userRights;

import java.util.Comparator;

public class FormMasterBeanComparator implements Comparator<FormMasterBean>{

	@Override
	public int compare(FormMasterBean o1, FormMasterBean o2) {
		return o1.getDisplayOrder() - o2.getDisplayOrder();
	}
}
