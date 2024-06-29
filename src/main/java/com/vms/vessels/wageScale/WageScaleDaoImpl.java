package com.vms.vessels.wageScale;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.vms.crew.certificates.CertificatesBean;
import com.vms.crew.certificates.CertificatesQueryutil;





@Repository
public class WageScaleDaoImpl implements WageScaleDao{


@Autowired
NamedParameterJdbcTemplate namedParameterJdbcTemplate;

@Autowired
JdbcTemplate jdbcTemplate;

@Override
public WageScaleResultBean save(WageScaleBean bean) {
	WageScaleResultBean resultBean = new WageScaleResultBean();
	UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	
	try {

		int code =  jdbcTemplate.queryForObject(WageScaleQueryUtil.get_code,new Object[] { bean.getCode() },Integer.class);


	    if(code==0) {
		Map<String, Object> wagescale = new HashMap<String, Object>();
		
			wagescale.put("userName", userDetails.getUsername());
			wagescale.put("code", bean.getCode());
			wagescale.put("desc", bean.getDescription());
			namedParameterJdbcTemplate.update(WageScaleQueryUtil.SAVE_WAGE,wagescale);
		
	   resultBean.setSuccess(true);
	    }
		  else {
	 		   resultBean.setMessage(bean.getCode() + " already exists,please enter a different wage Scale Code");

	        }
	}catch(Exception e) {
		e.printStackTrace();
		resultBean.setSuccess(false);
		 resultBean.setMessage("Not Updated");
	}
	return resultBean;
}

@Override
public WageScaleResultBean getList() {
	WageScaleResultBean resultBean = new WageScaleResultBean();
	List<WageScaleBean> listBean = new ArrayList<WageScaleBean>();
	
	try {
		listBean = jdbcTemplate.query(WageScaleQueryUtil.getList,new BeanPropertyRowMapper<WageScaleBean>(WageScaleBean.class));
		resultBean.setList(listBean);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return resultBean;
}

@Override
public WageScaleResultBean edit(int id) {		
	WageScaleResultBean resultBean = new WageScaleResultBean();
	resultBean.setSuccess(false);
	try {
		resultBean.setList(jdbcTemplate.query(WageScaleQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<WageScaleBean>(WageScaleBean.class)));
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return resultBean; 
}

@Override
public WageScaleResultBean delete(int id) {
	WageScaleResultBean resultBean = new WageScaleResultBean();
	 String code = null;
	try {
		code = jdbcTemplate.queryForObject(WageScaleQueryUtil.getCodeById, new Object[]{id}, String.class);

		jdbcTemplate.update(WageScaleQueryUtil.delete,id);
		resultBean.setSuccess(true);
	}
	catch(DataAccessException e) {
		String errorMessage = e.getMessage();
        if (errorMessage.contains("violates foreign key constraint")) {
            resultBean.setSuccess(false);
            resultBean.setMessage(code + " code cannot be deleted as it is already used in system.");
        } else {
            e.printStackTrace();
            resultBean.setSuccess(false);
            resultBean.setMessage(errorMessage);
        }
	}	
	return resultBean;
}

@Override
public WageScaleResultBean update(WageScaleBean bean) {
	WageScaleResultBean resultBean = new WageScaleResultBean();
	UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	
	try {
		String scalecode =  jdbcTemplate.queryForObject(WageScaleQueryUtil.scale_code,new Object[] { bean.getWagescaleid() },String.class);
		String scaledesc =  jdbcTemplate.queryForObject(WageScaleQueryUtil.scale_desc,new Object[] { bean.getWagescaleid() },String.class);


		int code =  jdbcTemplate.queryForObject(WageScaleQueryUtil.get_code_edit,new Object[] { bean.getCode(),scalecode },Integer.class);


		
        if(code==0) {
		Map<String, Object> wagescale = new HashMap<String, Object>();
		
			wagescale.put("userName", userDetails.getUsername());
			wagescale.put("code", bean.getCode());
			wagescale.put("desc", bean.getDescription());
			wagescale.put("wagescaleid", bean.getWagescaleid());
			
				namedParameterJdbcTemplate.update(WageScaleQueryUtil.UPDATE_WAGE,wagescale);
			
	   resultBean.setSuccess(true);
        }
		  else {
	 		   resultBean.setMessage(bean.getCode() + " already exists,please enter a different wage Scale Code");

	        }	 
	}catch(Exception e) {
		e.printStackTrace();
		resultBean.setSuccess(false);
		 resultBean.setMessage("Not Updated");
	}
	return resultBean;
}


@Override
public WageScaleBean getSequenceCode() {
	WageScaleBean WageScaleBean = new WageScaleBean();

    try {
        String WageScaleId = jdbcTemplate.queryForObject(WageScaleQueryUtil.WageScaleId, String.class);
        WageScaleBean.setCode(WageScaleId);
    } catch (Exception e) {
        // Log the exception
        e.printStackTrace();
    }

    return WageScaleBean;
}



}