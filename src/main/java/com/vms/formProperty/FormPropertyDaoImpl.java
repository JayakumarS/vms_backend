package com.vms.formProperty;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vms.common.ErrorMessage;
import com.vms.core.util.CustomException;
import com.vms.usermanagement.User;

@Repository
public class FormPropertyDaoImpl implements FormPropertyDao{
	private final static Logger LOGGER = LoggerFactory.getLogger(FormPropertyDaoImpl.class);
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public FormPropertyResultBean getFormProperty(String userId) throws CustomException {
		FormPropertyResultBean objEmployeeMasterResultBean = new FormPropertyResultBean();
		objEmployeeMasterResultBean.setSuccess(false);
		List<FormPropertyBean> formList = new ArrayList<FormPropertyBean>();
		try {
			
			formList = jdbcTemplate.query(FormPropertyQueryUtil.getFormPropertyList, new BeanPropertyRowMapper<FormPropertyBean>(FormPropertyBean.class), userId);
			List<FormPropertyBean> moduleList = formList
			  .stream()
			  .filter(c -> c.getFormcodeparent().equals("F00001"))
			  .sorted(Comparator.comparing(FormPropertyBean::getDisplayorder))
			  .collect(Collectors.toList());

			for(FormPropertyBean moduleBean:moduleList) {List<FormPropertyBean> firstLevelFormList = formList
					  .stream()
					  .filter(c -> c.getFormcodeparent().equals(moduleBean.getForm_code()))
					  .sorted(Comparator.comparing(FormPropertyBean::getDisplayorder))
					  .collect(Collectors.toList());
		    for(FormPropertyBean firstLevelBean:firstLevelFormList) {
		    	
		    	List<FormPropertyBean> secondLevelFormList = formList
						  .stream()
						  .filter(c -> c.getFormcodeparent().equals(firstLevelBean.getForm_code()))
						  .sorted(Comparator.comparing(FormPropertyBean::getDisplayorder))
						  .collect(Collectors.toList());
		    	firstLevelBean.setSubMenuList(secondLevelFormList);
		    	
		    	for (FormPropertyBean secondLevelBean : secondLevelFormList) {
			        List<FormPropertyBean> thirdLevelFormList = formList
			            .stream()
			            .filter(c -> c.getFormcodeparent().equals(secondLevelBean.getForm_code()))
			            .sorted(Comparator.comparing(FormPropertyBean::getDisplayorder))
			            .collect(Collectors.toList());

			        secondLevelBean.setSubMenuList(thirdLevelFormList);
			        
			        for (FormPropertyBean thirdLevelBean : thirdLevelFormList) {
				        List<FormPropertyBean> fourLevelFormList = formList
				            .stream()
				            .filter(c -> c.getFormcodeparent().equals(thirdLevelBean.getForm_code()))
				            .sorted(Comparator.comparing(FormPropertyBean::getDisplayorder))
				            .collect(Collectors.toList());

				        thirdLevelBean.setSubMenuList(fourLevelFormList);
				        
				        for (FormPropertyBean fifthLevelBean : fourLevelFormList) {
					        List<FormPropertyBean> fifthLevelFormList = formList
					            .stream()
					            .filter(c -> c.getFormcodeparent().equals(fifthLevelBean.getForm_code()))
					            .sorted(Comparator.comparing(FormPropertyBean::getDisplayorder))
					            .collect(Collectors.toList());

					        fifthLevelBean.setSubMenuList(fifthLevelFormList);
					    }
				    }
			        
			        
			        
			        
			    }
		    	
		    }
		      moduleBean.setSubMenuList(firstLevelFormList);		    
			}
					
			objEmployeeMasterResultBean.setModuleLevelList(moduleList);
			
			Integer getUserId =  jdbcTemplate.queryForObject(FormPropertyQueryUtil.getCompanyUserId,new Object[] {userId },Integer.class);

			 List<FormPropertyBean> firstLevelFormList=	jdbcTemplate.query(FormPropertyQueryUtil.getDashBoardList,new Object[] { getUserId }, new BeanPropertyRowMapper<FormPropertyBean>(FormPropertyBean.class));
						
			objEmployeeMasterResultBean.setDashboardList(firstLevelFormList);

			
			objEmployeeMasterResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error in Menu Property", e);
			objEmployeeMasterResultBean.setSuccess(false);
			objEmployeeMasterResultBean.setMessage(ErrorMessage.ERROR_MenuList);
			throw new CustomException(ErrorMessage.ERROR_MenuList);
		}
		
		return objEmployeeMasterResultBean;
	}
	
	
}
