package com.vms.userRights;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.formProperty.FormPropertyBean;

@Service
public class UserRightsServiceImpl implements UserRightsService {
	@Autowired
	UserRightsDao userRightsDao;

	
   @Override
	public List<UserRightsBean> getuserList() throws Exception {
		// TODO Auto-generated method stub
		return userRightsDao.getuserList();
	}

   @Override
  	public List<UserRightsBean> getCompanyList() throws Exception {
  		// TODO Auto-generated method stub
  		return userRightsDao.getCompanyList();
  	}
   
	@Override
	public UserRightsResultBean save(UserRightsBean bean) throws Exception {
		return userRightsDao.save(bean);
	}
	
   @Override
 	public List<UserRightsBean> getModuleList() throws Exception {
 		// TODO Auto-generated method stub
 		return userRightsDao.getModuleList();
 	}
   

   
   @Override
	public List<UserRightsBean> getPropertyList() throws Exception {
		// TODO Auto-generated method stub
		return userRightsDao.getPropertyList();
	}
   
   @Override
 	public List<UserRightsBean> getuserFormList() throws Exception {
 		// TODO Auto-generated method stub
 		return userRightsDao.getuserFormList();
 	}
	
   
   @Override
	public List<FormMasterBean> getFormMasterListByCompanyUser(String userId, String companyCode, String moduleCode)
			throws Exception {
		return userRightsDao.getFormMasterListByCompanyUser(userId, companyCode, moduleCode);
	}
   
	@Override
	public UserRightsResultBean getFormList(String userId) throws Exception {
		// TODO Auto-generated method stub
		return userRightsDao.getFormList(userId);
	}
	
	@Override
	public UserRightsResultBean getFormByModuleList(String userId, String moduleCode) throws Exception {
		// TODO Auto-generated method stub
		return userRightsDao.getFormByModuleList(userId,moduleCode);
	}

	@Override
	public PermissionResultBean getAllPagePermissionList(PermissionBean permissionBean, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return userRightsDao.getAllPagePermissionList(permissionBean,request);
	}
	
	
	//Mobile User Rigts

	@Override
	public UserRightsResultBean getPermissionList(String userId) throws Exception {
		// TODO Auto-generated method stub
		return userRightsDao.getPermissionList(userId);
	}

	/*
	 * //MVJ
	 * 
	 * 
	 * @Override public List<FormMasterBean>
	 * getFormMasterListFiltered(List<FormMasterBean> lFormMasterBean, List<Integer>
	 * lFormPropertyIdActive) throws Exception { List<FormMasterBean>
	 * lFormMasterBeanReturn = new ArrayList<FormMasterBean>(); for (FormMasterBean
	 * formMasterBean : lFormMasterBean) { List<FormPropertyBean> lFormPropertyBean
	 * = userRightsDao.getFormPropertyBeanList(formMasterBean.getFormCode()); for
	 * (FormPropertyBean formPropertyBean : lFormPropertyBean) { if
	 * (lFormPropertyIdActive.contains(formPropertyBean.getFormPropertyId())) {
	 * formPropertyBean.setEnabled(true); } }
	 * formMasterBean.setlFormPropertyBean(lFormPropertyBean); }
	 * System.out.println(lFormMasterBean.toString()); Map<String, FormMasterBean>
	 * hmFormMasterBean = new HashMap<String, FormMasterBean>(); for (FormMasterBean
	 * objFormMasterBean : lFormMasterBean) {
	 * hmFormMasterBean.put(objFormMasterBean.getFormCode(), objFormMasterBean); }
	 * 
	 * Map<String, List<FormMasterBean>> hmFormMasterBeanNew = new TreeMap<String,
	 * List<FormMasterBean>>(Collections.reverseOrder()); for (FormMasterBean
	 * objFormMasterBean : lFormMasterBean) { List<FormMasterBean>
	 * lFormMasterBeanNew = new ArrayList<FormMasterBean>(); for (FormMasterBean
	 * objFormMasterBeanNew : lFormMasterBean) {
	 * System.out.println(objFormMasterBean.getFormCode() + "==" +
	 * objFormMasterBeanNew.getFormCodeParent()); if
	 * (objFormMasterBean.getFormCode().equalsIgnoreCase(objFormMasterBeanNew.
	 * getFormCodeParent())) { lFormMasterBeanNew.add(objFormMasterBeanNew); } } if
	 * (lFormMasterBeanNew.size() > 0) {
	 * hmFormMasterBeanNew.put(objFormMasterBean.getFormCode(), lFormMasterBeanNew);
	 * } }
	 * 
	 * for (Iterator<Map.Entry<String, List<FormMasterBean>>> itHmFormMasterBeanNew
	 * = hmFormMasterBeanNew.entrySet().iterator();
	 * itHmFormMasterBeanNew.hasNext();) { Map.Entry<String, List<FormMasterBean>>
	 * mFormMasterEntry = itHmFormMasterBeanNew.next(); FormMasterBean
	 * objFormMasterBean = hmFormMasterBean.get(mFormMasterEntry.getKey());
	 * objFormMasterBean.setlFormMasterBean(mFormMasterEntry.getValue()); if
	 * (hmFormMasterBeanNew.containsKey(objFormMasterBean.getFormCodeParent())) {
	 * List<FormMasterBean> lFormMasterBeanNew =
	 * hmFormMasterBeanNew.get(objFormMasterBean.getFormCodeParent()); for
	 * (Iterator<FormMasterBean> itlFormMasterBeanNew =
	 * lFormMasterBeanNew.iterator(); itlFormMasterBeanNew.hasNext();) { if
	 * (itlFormMasterBeanNew.next().getFormCode().equalsIgnoreCase(objFormMasterBean
	 * .getFormCode())) { itlFormMasterBeanNew.remove(); } }
	 * lFormMasterBeanNew.add(objFormMasterBean);
	 * Collections.sort(lFormMasterBeanNew, new FormMasterBeanComparator());
	 * itHmFormMasterBeanNew.remove(); } }
	 * System.out.println(hmFormMasterBeanNew.toString()); if
	 * (hmFormMasterBeanNew.size() > 0) { for (FormMasterBean formMasterBean1 :
	 * hmFormMasterBeanNew.get("F1000")) {
	 * lFormMasterBeanReturn.add(formMasterBean1); for (FormMasterBean
	 * formMasterBean2 : formMasterBean1.getlFormMasterBean()) {
	 * lFormMasterBeanReturn.add(formMasterBean2); for (FormMasterBean
	 * formMasterBean3 : formMasterBean2.getlFormMasterBean()) {
	 * lFormMasterBeanReturn.add(formMasterBean3); for (FormMasterBean
	 * formMasterBean4 : formMasterBean3.getlFormMasterBean()) {
	 * lFormMasterBeanReturn.add(formMasterBean4); for (FormMasterBean
	 * formMasterBean5 : formMasterBean4.getlFormMasterBean()) {
	 * lFormMasterBeanReturn.add(formMasterBean5); for (FormMasterBean
	 * formMasterBean6 : formMasterBean5.getlFormMasterBean()) {
	 * lFormMasterBeanReturn.add(formMasterBean6); for (FormMasterBean
	 * formMasterBean7 : formMasterBean6.getlFormMasterBean()) {
	 * lFormMasterBeanReturn.add(formMasterBean7); for (FormMasterBean
	 * formMasterBean8 : formMasterBean7.getlFormMasterBean()) {
	 * lFormMasterBeanReturn.add(formMasterBean8); }
	 * formMasterBean7.getlFormMasterBean().clear(); }
	 * formMasterBean6.getlFormMasterBean().clear(); }
	 * formMasterBean5.getlFormMasterBean().clear(); }
	 * formMasterBean4.getlFormMasterBean().clear(); }
	 * formMasterBean3.getlFormMasterBean().clear(); }
	 * formMasterBean2.getlFormMasterBean().clear(); }
	 * formMasterBean1.getlFormMasterBean().clear(); } } return
	 * lFormMasterBeanReturn; }
	 * 
	 * 
	 * 
	 * @Override public int getCompanyUserId(String companyCode, String userId)
	 * throws Exception { return userRightsDao.getCompanyUserId(companyCode,
	 * userId); }
	 * 
	 * @Override public List<FormMasterBean> getFormMasterList(int companyUserId,
	 * String moduleCode, String formCode) throws Exception { List<Integer>
	 * lFormPropertyIdActive = userRightsDao.getFormPropertyIdList(companyUserId);
	 * List<FormMasterBean> lFormMasterBean =
	 * userRightsDao.getFormMasterList(moduleCode, formCode); return
	 * getFormMasterListFiltered(lFormMasterBean, lFormPropertyIdActive); }
	 */
}
