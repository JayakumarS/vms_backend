package com.vms.userRights;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vms.core.util.CustomException;
import com.vms.core.util.DropDownList;
import com.vms.formProperty.FormPropertyBean;

@Repository
public class UserRightsDaoImpl implements UserRightsDao {

	private final static Logger LOGGER = LoggerFactory.getLogger(UserRightsDaoImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<UserRightsBean> getuserList() throws Exception {
		List<UserRightsBean> userRightsBean = new ArrayList<UserRightsBean>();
		try {
			userRightsBean = jdbcTemplate.query(UserRightsQueryUtil.getUserList,
					new BeanPropertyRowMapper<UserRightsBean>(UserRightsBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userRightsBean;
	}

	@Override
	public List<UserRightsBean> getCompanyList() throws Exception {
		List<UserRightsBean> userRightsBean = new ArrayList<UserRightsBean>();
		try {
			userRightsBean = jdbcTemplate.query(UserRightsQueryUtil.getCompanyList,
					new BeanPropertyRowMapper<UserRightsBean>(UserRightsBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userRightsBean;
	}

	@Override
	public List<UserRightsBean> getModuleList() throws Exception {
		List<UserRightsBean> userRightsBean = new ArrayList<UserRightsBean>();
		try {
			userRightsBean = jdbcTemplate.query(UserRightsQueryUtil.getModuleList,
					new BeanPropertyRowMapper<UserRightsBean>(UserRightsBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userRightsBean;
	}

	@Override
	public List<UserRightsBean> getPropertyList() throws Exception {
		List<UserRightsBean> userRightsBean = new ArrayList<UserRightsBean>();
		try {
			userRightsBean = jdbcTemplate.query(UserRightsQueryUtil.getPropertyList,
					new BeanPropertyRowMapper<UserRightsBean>(UserRightsBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userRightsBean;
	}

	@Override
	public List<UserRightsBean> getuserFormList() throws Exception {
		List<UserRightsBean> userRightsBean = new ArrayList<UserRightsBean>();
		try {
			userRightsBean = jdbcTemplate.query(UserRightsQueryUtil.getuserFormList,
					new BeanPropertyRowMapper<UserRightsBean>(UserRightsBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userRightsBean;
	}

	@Override
	public List<FormMasterBean> getFormMasterListByCompanyUser(String userId, String companyCode, String moduleCode)
			throws CustomException {
		Integer companyUserId = getCompanyUserId(companyCode, userId);
		List<Integer> lFormPropertyIdActive = getlFormPropIdByCompUser(companyUserId);
		List<String> lFormCodeActive = getlFormCodeByCompUser(companyUserId);

		List<FormMasterBean> lFormMasterBean = new ArrayList<FormMasterBean>();
		List<PropertyMasterBean> lPropertyMasterBean = getPropertyMasterBeanList();
		try {

			int value = jdbcTemplate.queryForObject(UserRightsQueryUtil.sCheckEmployeeCompny, Integer.class,
					companyCode, userId);
			if (value > 0) {
				System.out.println("Base Company");
				for (FormMasterBean formMasterBean : getFormMasterListByModuleCode(moduleCode, "", true)) {
					lFormMasterBean.add(formMasterBean);
					for (FormMasterBean formMasterBeanChild : getFormMasterListByModuleCode(moduleCode,
							formMasterBean.getFormCode(), false)) {
						Map<String, FormPropertyBean> mFormPropertyBean = getFormPropertyBeanMapByFormCode(
								formMasterBeanChild.getFormCode());
						for (PropertyMasterBean propertyMasterBean : lPropertyMasterBean) {
							if (mFormPropertyBean.containsKey(propertyMasterBean.getPropertyCode())) {
								FormPropertyBean formPropertyBean = mFormPropertyBean
										.get(propertyMasterBean.getPropertyCode());
								formPropertyBean.setEnabled(
										lFormPropertyIdActive.contains(formPropertyBean.getFormPropertyId()));
								formMasterBeanChild.setFormPropertyBean(formPropertyBean);

							} else {
								FormPropertyBean formPropertyBean = new FormPropertyBean();
								formPropertyBean.setFormCode(formMasterBeanChild.getFormCode());
								formPropertyBean.setPropertyCode(propertyMasterBean.getPropertyCode());
								formPropertyBean.setFormPropertyId(0);
								formMasterBeanChild.setFormPropertyBean(formPropertyBean);
							}
						}

						lFormMasterBean.add(formMasterBeanChild);
					}
				}
			} else {
				System.out.println("Other Company");
				for (FormMasterBean formMasterBean : getFormMasterListByModuleCodeBase(moduleCode, "", true)) {

					lFormMasterBean.add(formMasterBean);
					for (FormMasterBean formMasterBeanChild : getFormMasterListByModuleCodeBase(moduleCode,
							formMasterBean.getFormCode(), false)) {
						Map<String, FormPropertyBean> mFormPropertyBean = getFormPropertyBeanMapByFormCode(
								formMasterBeanChild.getFormCode());
						for (PropertyMasterBean propertyMasterBean : lPropertyMasterBean) {
							if (mFormPropertyBean.containsKey(propertyMasterBean.getPropertyCode())) {
								FormPropertyBean formPropertyBean = mFormPropertyBean
										.get(propertyMasterBean.getPropertyCode());
								formPropertyBean.setEnabled(
										lFormPropertyIdActive.contains(formPropertyBean.getFormPropertyId()));
								formMasterBeanChild.setFormPropertyBean(formPropertyBean);
							} else {
								FormPropertyBean formPropertyBean = new FormPropertyBean();
								formPropertyBean.setFormCode(formMasterBeanChild.getFormCode());
								formPropertyBean.setPropertyCode(propertyMasterBean.getPropertyCode());
								formPropertyBean.setFormPropertyId(0);
								formMasterBeanChild.setFormPropertyBean(formPropertyBean);
							}
						}

						lFormMasterBean.add(formMasterBeanChild);
					}
				}
			}
		} catch (DataAccessException e) {

			e.printStackTrace();
		}
		return lFormMasterBean;
	}

	public List<PropertyMasterBean> getPropertyMasterBeanList() throws CustomException {
		List<PropertyMasterBean> lPropertyMasterBean = new ArrayList<PropertyMasterBean>();
		try {
			lPropertyMasterBean = jdbcTemplate.query(UserRightsQueryUtil.GET_PROPERTY_MASTER_LIST,
					new BeanPropertyRowMapper<PropertyMasterBean>(PropertyMasterBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lPropertyMasterBean;
	}

	public int getCompanyUserId(String companyCode, String userId) throws CustomException {
		String companyUserId = "";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(UserRightsQueryUtil.GET_COMPANY_USER_ID,
				new Object[] { companyCode, userId });

		companyUserId = companyUserId.equals("") ? "0" : companyUserId;
		return Integer.parseInt(companyUserId);
	}

	public List<Integer> getlFormPropIdByCompUser(int companyUserId) throws CustomException {
		List<Integer> formPropertyIdList = new ArrayList<Integer>();

		try {
			formPropertyIdList = jdbcTemplate.query(UserRightsQueryUtil.FORM_PROPERTY_LIST_FROM_USER_RIGHTS,
					new Object[] { companyUserId }, new RowMapper<Integer>() {
						@Override
						public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
							return rs.getInt(1);
						}
					});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return formPropertyIdList;
	}

	public List<String> getlFormCodeByCompUser(int companyUserId) throws CustomException {

		List<String> formCodeList = new ArrayList<String>();

		try {
			formCodeList = jdbcTemplate.query(UserRightsQueryUtil.FORM_CODE_LIST_FROM_USER_RIGHTS,
					new Object[] { companyUserId }, new RowMapper<String>() {
						@Override
						public String mapRow(ResultSet rs, int rowNum) throws SQLException {
							return rs.getString(1);
						}
					});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return formCodeList;
	}

	public List<FormMasterBean> getFormMasterListByModuleCode(String moduleCode, String formCode, boolean isParent)
			throws CustomException {
		List<Map<String, Object>> lRow = new ArrayList<>();
		List<FormMasterBean> lFormMasterBean = new ArrayList<FormMasterBean>();
		if (isParent) {
			lRow = jdbcTemplate.queryForList(UserRightsQueryUtil.GET_FORM_MASTER_PARENT_LIST,
					new Object[] { moduleCode, UserRightsQueryUtil.parentCode });
		} else {
			lRow = jdbcTemplate.queryForList(UserRightsQueryUtil.GET_FORM_MASTER_CHILD_LIST,
					new Object[] { moduleCode, formCode, UserRightsQueryUtil.childCode });
		}
		for (Map<String, Object> row : lRow) {
			FormMasterBean formMasterBean = new FormMasterBean();
			formMasterBean.setFormCode((String) row.get("FORM_CODE"));
			formMasterBean.setFormName((String) row.get("FORM_NAME"));
			formMasterBean.setDisplayOrder(Integer.valueOf(String.valueOf(row.get("DISPLAY_ORDER"))));
			formMasterBean.setImageIconUrl((String) row.get("IMAGE_ICON_URL"));
			formMasterBean.setModuleCode((String) row.get("MODULE_CODE"));
			formMasterBean.setFormCodeParent((String) row.get("FORM_CODE_PARENT"));
			formMasterBean.setFormUrl((String) row.get("FORM_URL"));
			formMasterBean.setIsParent((String) row.get("IS_PARENT"));
			lFormMasterBean.add(formMasterBean);
		}
		return lFormMasterBean;
	}

	public Map<String, FormPropertyBean> getFormPropertyBeanMapByFormCode(String formCode) {
		Map<String, FormPropertyBean> mFormPropertyBean = new HashMap<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(UserRightsQueryUtil.GET_FORM_PROPERTY_LIST,
					new Object[] { formCode });
			for (Map<String, Object> row : rows) {
				FormPropertyBean objFormPropertyBean = new FormPropertyBean();

				objFormPropertyBean.setFormPropertyId(Integer.valueOf(String.valueOf(row.get("FORM_PROPERTY_ID"))));
				objFormPropertyBean.setFormCode((String) row.get("FORM_CODE"));
				objFormPropertyBean.setPropertyCode((String) row.get("PROPERTY_CODE"));
				objFormPropertyBean.setAvailable(true);
				mFormPropertyBean.put(objFormPropertyBean.getPropertyCode(), objFormPropertyBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mFormPropertyBean;
	}

	public List<FormMasterBean> getFormMasterListByModuleCodeBase(String moduleCode, String formCode, boolean isParent)
			throws CustomException {
		List<Map<String, Object>> lRow = new ArrayList<>();
		List<FormMasterBean> lFormMasterBean = new ArrayList<FormMasterBean>();
		if (isParent) {
			lRow = jdbcTemplate.queryForList(UserRightsQueryUtil.GET_FORM_MASTER_PARENT_LIST_BASE,
					new Object[] { moduleCode });
		} else {
			lRow = jdbcTemplate.queryForList(UserRightsQueryUtil.GET_FORM_MASTER_CHILD_LIST,
					new Object[] { moduleCode, formCode, UserRightsQueryUtil.childCode });
		}
		for (Map<String, Object> row : lRow) {
			FormMasterBean formMasterBean = new FormMasterBean();
			formMasterBean.setFormCode((String) row.get("FORM_CODE"));
			formMasterBean.setFormName((String) row.get("FORM_NAME"));
			formMasterBean.setDisplayOrder(Integer.valueOf(String.valueOf(row.get("DISPLAY_ORDER"))));
			formMasterBean.setImageIconUrl((String) row.get("IMAGE_ICON_URL"));
			formMasterBean.setModuleCode((String) row.get("MODULE_CODE"));
			formMasterBean.setFormCodeParent((String) row.get("FORM_CODE_PARENT"));
			formMasterBean.setFormUrl((String) row.get("FORM_URL"));
			formMasterBean.setIsParent((String) row.get("IS_PARENT"));
			lFormMasterBean.add(formMasterBean);
		}
		return lFormMasterBean;
	}
	@Override
	public UserRightsResultBean getFormList(String userId) throws Exception {
		UserRightsResultBean resultBean =new UserRightsResultBean ();
		resultBean.setSuccess(false);
		try {
			resultBean.setFormList(jdbcTemplate.queryForList(UserRightsQueryUtil.GET_FORM_LIST));
			resultBean.setPropertyList(jdbcTemplate.query(UserRightsQueryUtil.GET_PROPERTYLIST, new BeanPropertyRowMapper<UserRightsBean>(UserRightsBean.class)));
			resultBean.setFormPropertyList(jdbcTemplate.query(UserRightsQueryUtil.GET_FORMPROPERTYLIST, new BeanPropertyRowMapper<UserRightsBean>(UserRightsBean.class)));
			if(userId!=null) {
				resultBean.setUserRightsPropertyList(jdbcTemplate.query(UserRightsQueryUtil.getUserBasedFormPropertyList(userId), new BeanPropertyRowMapper<UserRightsPropertyListBean>(UserRightsPropertyListBean.class)));
         		//resultBean.setRoleremarks(jdbcTemplate.queryForObject(UserRightsQueryUtil.GET_ROLE_REMARKS, new Object[]{ userId }, String.class));
			}
			resultBean.setSuccess(true);
			
		}catch(Exception e){
			resultBean.setSuccess(false);
			e.printStackTrace();
		}
		return resultBean;
	}
	
	@Override
	public UserRightsResultBean getFormByModuleList(String userId, String moduleCode) throws Exception {
		UserRightsResultBean resultBean =new UserRightsResultBean ();
		resultBean.setSuccess(false);
		try {
			String query="Select form_code as item_id,form_name as item_text from auth.form where is_parent='N' and is_active = 'Y' and module_code='"+ moduleCode+"' order by form_name";
//			String query2="Select property_code as propertyCode, property_name as propertyName from auth.property  where form_property_id in (Select form_property_id from auth.form_property aa inner join auth.form ar on ar.form_code=aa.form_code where module_code='"+ moduleCode+"') order by display_order asc";
			String query3="select form_property_id as formPropertyId, form_code as formCode, property_code as propertyCode from auth.form_property aa where form_code in (Select form_code from auth.form where module_code='"+ moduleCode+"') order by form_code asc";
			resultBean.setFormList(jdbcTemplate.queryForList(query));
			resultBean.setPropertyList(jdbcTemplate.query(UserRightsQueryUtil.GET_PROPERTYLIST, new BeanPropertyRowMapper<UserRightsBean>(UserRightsBean.class)));
			resultBean.setFormPropertyList(jdbcTemplate.query(query3, new BeanPropertyRowMapper<UserRightsBean>(UserRightsBean.class)));
			if(userId!=null) {
				resultBean.setUserRightsPropertyList(jdbcTemplate.query(UserRightsQueryUtil.getUserBasedFormPropertyList(userId,moduleCode), new BeanPropertyRowMapper<UserRightsPropertyListBean>(UserRightsPropertyListBean.class)));
         		//resultBean.setRoleremarks(jdbcTemplate.queryForObject(UserRightsQueryUtil.GET_ROLE_REMARKS, new Object[]{ userId }, String.class));
			}
			resultBean.setSuccess(true);
			
		}catch(Exception e){
			resultBean.setSuccess(false);
			e.printStackTrace();
		}
		return resultBean;
	}
	
//	@Override
//	public UserRightsResultBean save(UserRightsBean bean) throws Exception {
//		UserRightsResultBean resultBean = new UserRightsResultBean();
//		try {
//			resultBean.setSuccess(false);
//			if (bean.getSelectedFormPropertyList() != null && bean.getSelectedFormPropertyList().size() > 0 && !bean.getSelectedFormPropertyList().isEmpty()) {
//				jdbcTemplate.update(UserRightsQueryUtil.DELETE_ROLERIGHTS, bean.getUserId() );
//				Integer updatecount=0;
//				for(FormPropertyListBean selectedFormPropertyList:bean.getSelectedFormPropertyList()) {
//					Map<String, Object> saveMap = new HashMap<String, Object>();
//					String getUserId =  jdbcTemplate.queryForObject(UserRightsQueryUtil.Generate_user_id, 
//							String.class);
//					saveMap.put("userId",getUserId);
//					saveMap.put("formPropertyId", selectedFormPropertyList.getFormPropertyId());
//					updatecount=namedParameterJdbcTemplate.update(UserRightsQueryUtil.INSERT,saveMap);
//				}
//				
//			}
//		}catch (Exception e) {
//				resultBean.setSuccess(false);
//				e.printStackTrace();
//			}
//			return resultBean;
//			
//			}
	@Override
	public UserRightsResultBean save(UserRightsBean bean) throws Exception {
		UserRightsResultBean resultBean = new UserRightsResultBean();
		try {
			Integer getUserId =  jdbcTemplate.queryForObject(UserRightsQueryUtil.Generate_user_id,new Object[] {bean.getUserId() },Integer.class);

			if(getUserId !=null) {
	 			jdbcTemplate.update(UserRightsQueryUtil.DELETE_ROLERIGHTS, getUserId ,bean.getModuleId());

			for(FormPropertyListBean selectedFormPropertyList:bean.getSelectedFormPropertyList()) {
				
			Map<String, Object> saveMap = new HashMap<String, Object>();
			saveMap.put("userId",getUserId);
			saveMap.put("formPropertyId",selectedFormPropertyList.getFormPropertyId());
			namedParameterJdbcTemplate.update(UserRightsQueryUtil.INSERT,saveMap);
			}
			  resultBean.setSuccess(true);
			}
		 
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		
		return resultBean;
	}

	@Override
	public PermissionResultBean getAllPagePermissionList(PermissionBean permissionBean, HttpServletRequest request) {
		// TODO Auto-generated method stub
		PermissionResultBean pagePermissionList = new PermissionResultBean();
		pagePermissionList.setSuccess(false);
		pagePermissionList.setAdd(false);
		pagePermissionList.setModify(false);
		pagePermissionList.setDelete(false);
		pagePermissionList.setSearch(false);
		pagePermissionList.setExportXL(false);
		pagePermissionList.setView(false);
		pagePermissionList.setPrint(false);
		try {
			if (permissionBean.getFormCode() != null && permissionBean.getFormCode() != "" && !permissionBean.getFormCode().isEmpty() && permissionBean.getUserId() != null && !permissionBean.getUserId().isEmpty()) {
				Integer id =  jdbcTemplate.queryForObject(UserRightsQueryUtil.Get_user_id,new Object[] {permissionBean.getUserId()},Integer.class);
				
				List<PermissionFormPropertyList> formPropertyPermissionList = jdbcTemplate.query(UserRightsQueryUtil.getAllPagePermissionListByRoleAndFormcode(permissionBean.getFormCode(),id),
							new BeanPropertyRowMapper<PermissionFormPropertyList>(PermissionFormPropertyList.class));
					if (formPropertyPermissionList != null && formPropertyPermissionList.size() > 0
							&& !formPropertyPermissionList.isEmpty()) {
						for (PermissionFormPropertyList formProperty : formPropertyPermissionList) {
							if (formProperty.getPropertyCode() != null) {
								if (formProperty.getPropertyCode().equalsIgnoreCase("A")) {
									pagePermissionList.setAdd(true);
								}
								if (formProperty.getPropertyCode().equalsIgnoreCase("M")) {
									pagePermissionList.setModify(true);
								}
								if (formProperty.getPropertyCode().equalsIgnoreCase("D")) {
									pagePermissionList.setDelete(true);
								}
								if (formProperty.getPropertyCode().equalsIgnoreCase("S")) {
									pagePermissionList.setSearch(true);
								}
								if (formProperty.getPropertyCode().equalsIgnoreCase("E")) {
									pagePermissionList.setExportXL(true);
								}
								if (formProperty.getPropertyCode().equalsIgnoreCase("V")) {
									pagePermissionList.setView(true);
								}
								if (formProperty.getPropertyCode().equalsIgnoreCase("P")) {
									pagePermissionList.setPrint(true);
								}
							}
						}
					}
				pagePermissionList.setSuccess(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			pagePermissionList.setSuccess(false);
		}
		return pagePermissionList;
	}
	
	
	//Mobile User Rigts
	@Override
	public UserRightsResultBean getPermissionList(String userId) throws Exception {
		UserRightsResultBean pagePermissionList =new UserRightsResultBean ();
		pagePermissionList.setSuccess(false);
		try {
				pagePermissionList.setUserRightsPropertyList(jdbcTemplate.query(UserRightsQueryUtil.GET_PERMISSION_LIST(userId), new BeanPropertyRowMapper<UserRightsPropertyListBean>(UserRightsPropertyListBean.class)));
			
			pagePermissionList.setSuccess(true);
			for(UserRightsPropertyListBean str:pagePermissionList.getUserRightsPropertyList()) {
				
				switch(str.getForm_code()) {
				
				case "F6021":
					pagePermissionList.setF6021(true);
					break;
					
				case "F4003":
					pagePermissionList.setF4003(true);
					break;
					
				case "F3004":
					pagePermissionList.setF3004(true);
					break;
					
				case "F5009":
					pagePermissionList.setF5009(true);
					break;
					
				case "F2002":
					pagePermissionList.setF2002(true);
					break;
					
				case "F9057":
					pagePermissionList.setF9057(true);
					break;
					
				case "F5010":
					pagePermissionList.setF5010(true);
					break;
					
				default:
					break;
				
				}
			}
			
			
		}catch(Exception e){
			pagePermissionList.setSuccess(false);
			e.printStackTrace();
		}
		return pagePermissionList;
	}
	
				
	/*
	 * //MVJ
	 * 
	 * @Override public List<Integer> getFormPropertyIdList(int companyUserId)
	 * throws CustomException {
	 * 
	 * List<Integer> formPropertyIdList = new ArrayList<Integer>();
	 * 
	 * try { formPropertyIdList =
	 * jdbcTemplate.query(UserRightsQueryUtil.FORM_PROPERTY_LIST_FROM_USER_RIGHTS,
	 * new Object[] { companyUserId }, new RowMapper<Integer>() {
	 * 
	 * @Override public Integer mapRow(ResultSet rs, int rowNum) throws SQLException
	 * { return rs.getInt(1); } }); } catch (DataAccessException e) {
	 * LOGGER.error("Error in getFormPropertyIdList", e); } return
	 * formPropertyIdList; }
	 * 
	 * @Override public List<FormMasterBean> getFormMasterList(String moduleCode,
	 * String formCode) throws CustomException { List<FormMasterBean>
	 * lFormMasterBean = new ArrayList<FormMasterBean>(); FormMasterBean
	 * formMasterBeanObj = new FormMasterBean(); try { // formMasterBeanObj = //
	 * jdbcTemplate.queryForObject(UserMasterQueryUtil.GET_ROOT_FORM_MASTER, // new
	 * BeanPropertyRowMapper<FormMasterBean>(FormMasterBean.class)); lFormMasterBean
	 * = jdbcTemplate.query(UserRightsQueryUtil.GET_FORM_MASTER_LIST, new Object[] {
	 * moduleCode, formCode, formCode }, new
	 * BeanPropertyRowMapper<FormMasterBean>(FormMasterBean.class)); //
	 * lFormMasterBean.add(formMasterBeanObj); // Collections.sort(lFormMasterBean,
	 * new MySalaryComp()); } catch (DataAccessException e) {
	 * LOGGER.error("Error in getFormMasterList", e); } return lFormMasterBean; }
	 * 
	 * @Override public List<FormPropertyBean> getFormPropertyBeanList(String
	 * formCode) throws CustomException { List<FormPropertyBean> lFormPropertyBean =
	 * new ArrayList<FormPropertyBean>(); try { List<Map<String, Object>> rows =
	 * jdbcTemplate.queryForList(UserRightsQueryUtil.GET_FORM_PROPERTY_LIST, new
	 * Object[] { formCode }); for (Map row : rows) { FormPropertyBean
	 * objFormPropertyBean = new FormPropertyBean();
	 * objFormPropertyBean.setFormPropertyId((Integer) row.get("FORM_PROPERTY_ID"));
	 * objFormPropertyBean.setFormCode((String) row.get("FORM_CODE"));
	 * objFormPropertyBean.setPropertyCode((String) row.get("PROPERTY_CODE"));
	 * 
	 * if (row.get("AVAILABLE") != null) {
	 * objFormPropertyBean.setAvailable((Integer) row.get("AVAILABLE")); }
	 * 
	 * lFormPropertyBean.add(objFormPropertyBean); } } catch (Exception e) {
	 * LOGGER.error("Error in getFormPropertyBeanList", e); } return
	 * lFormPropertyBean; }
	 */
}
