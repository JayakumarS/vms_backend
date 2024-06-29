package com.vms.crew.utilities.MultiSeamen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.vms.crew.maintain.OffSign.OffSignBean;
import com.vms.crew.maintain.OffSign.OffSignQueryUtil;

@Repository
public class MultiSeamenDaoImpl implements MultiSeamenDao{
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public MultiSeamenResultBean saveMultiSeamen(MultiSeamenBean bean) {
		MultiSeamenResultBean resultBean = new MultiSeamenResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> multiSeamen = new HashMap<String, Object>();
			
			multiSeamen.put("userName", userDetails.getUsername());
			multiSeamen.put("vessel", bean.getVessel());
			multiSeamen.put("startdate", bean.getStartdate());
			multiSeamen.put("joinPort", bean.getJoinPort());
				
			Integer code = namedParameterJdbcTemplate.queryForObject(MultiSeamenQueryUtil.SAVE_MULTI_SEAMEN_HDR,multiSeamen,Integer.class);
			
			savedetail(bean,code);
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
	
	@Override
	public MultiSeamenResultBean savedetail(MultiSeamenBean bean,Integer code) {
		MultiSeamenResultBean resultBean = new MultiSeamenResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> multiSeamenDtl = new HashMap<String, Object>();
			
			for(MultiSeamenBean listBean : bean.getMultiseamendetail()) {
				multiSeamenDtl.put("userName", userDetails.getUsername());
				multiSeamenDtl.put("code", code);
				multiSeamenDtl.put("name", listBean.getName());
				multiSeamenDtl.put("rank", listBean.getRank());
				multiSeamenDtl.put("pay", listBean.getPay());
				multiSeamenDtl.put("currency", listBean.getCurrency());
				multiSeamenDtl.put("joiningDate", listBean.getJoiningDate());
				multiSeamenDtl.put("estSignOff", listBean.getEstSignOff());
				multiSeamenDtl.put("nationality", listBean.getNationality());
			
				
				namedParameterJdbcTemplate.update(MultiSeamenQueryUtil.SAVE_MULTI_SEAMEN_DTL,multiSeamenDtl);
			}
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
	
	@Override
	public MultiSeamenResultBean listMultiSeamen() {
		MultiSeamenResultBean resultBean = new MultiSeamenResultBean();
		List<MultiSeamenBean> listBean = new ArrayList<MultiSeamenBean>();
		
		try {
			listBean = jdbcTemplate.query(MultiSeamenQueryUtil.GET_MULTISEAMEN_LIST,new BeanPropertyRowMapper<MultiSeamenBean>(MultiSeamenBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	
	@Override
	public MultiSeamenResultBean editMultiSeamen(Integer id) {		
		MultiSeamenResultBean resultBean = new MultiSeamenResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(MultiSeamenQueryUtil.GET_EDIT_MULTISEAMEN,new Object[] { id }, new BeanPropertyRowMapper<MultiSeamenBean>(MultiSeamenBean.class)));
		
			List<MultiSeamenBean> sampleDtl = jdbcTemplate.query(MultiSeamenQueryUtil.GET_EDIT_MUlTISEAMEN_DTL,new Object[] { id },new BeanPropertyRowMapper<MultiSeamenBean>(MultiSeamenBean.class));	
			resultBean.setMultiseamendetail(sampleDtl);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}
	
	
	@Override
	public MultiSeamenResultBean deleteMultiSeamen(Integer id) {
		MultiSeamenResultBean resultBean = new MultiSeamenResultBean();
		try {
			jdbcTemplate.update(MultiSeamenQueryUtil.DELETE_MULTISEAMEN_Dtl,id);
			jdbcTemplate.update(MultiSeamenQueryUtil.DELETE_MULTISEAMEN,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			  String errorMessage = e.getMessage();
		        if (errorMessage.contains("violates foreign key constraint")) {
		            resultBean.setSuccess(false);
		            resultBean.setMessage("Cannot delete this country id because it is referenced in another table");
		        } else {
		            e.printStackTrace();
		            resultBean.setSuccess(false);
		            resultBean.setMessage(errorMessage);
		        }
		}	
		return resultBean;
	}

	@Override
	public MultiSeamenResultBean updateMultiSeamen(MultiSeamenBean bean) {
		MultiSeamenResultBean resultBean = new MultiSeamenResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {

			
			Map<String, Object> multiSeamenDtl = new HashMap<String, Object>();
			
			multiSeamenDtl.put("userName", userDetails.getUsername());
			multiSeamenDtl.put("vessel", bean.getVessel());
			multiSeamenDtl.put("startdate", bean.getStartdate());
			multiSeamenDtl.put("joinPort", bean.getJoinPort());
			multiSeamenDtl.put("seamenCode", bean.getSeamenCode());

			
			Integer headerId= namedParameterJdbcTemplate.queryForObject(MultiSeamenQueryUtil.UPDATE_OFFSIGN,multiSeamenDtl,Integer.class);

					
			if(headerId !=null) {
				jdbcTemplate.update(MultiSeamenQueryUtil.DELETE_OFFSIGN_DTL, headerId);
				
				for(MultiSeamenBean listBean : bean.getMultiseamendetail()) {
					multiSeamenDtl.put("userName", userDetails.getUsername());
					multiSeamenDtl.put("code", headerId);
					multiSeamenDtl.put("name", listBean.getName());
					multiSeamenDtl.put("rank", listBean.getRank());
					multiSeamenDtl.put("pay", listBean.getPay());
					multiSeamenDtl.put("currency", listBean.getCurrency());
					multiSeamenDtl.put("joiningDate", listBean.getJoiningDate());
					multiSeamenDtl.put("estSignOff", listBean.getEstSignOff());
					multiSeamenDtl.put("nationality", listBean.getNationality());
				
					
					namedParameterJdbcTemplate.update(MultiSeamenQueryUtil.SAVE_MULTI_SEAMEN_DTL,multiSeamenDtl);
				}
				
			}
				
		   resultBean.setSuccess(true);
        
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public MultiSeamenResultBean checkValid(Integer id) {
		MultiSeamenResultBean resultBean = new MultiSeamenResultBean();
		List<MultiSeamenBean> listBean = new ArrayList<MultiSeamenBean>();
		
		try {
			listBean = jdbcTemplate.query(MultiSeamenQueryUtil.GET_MULTISEAMEN_LIST(id),new BeanPropertyRowMapper<MultiSeamenBean>(MultiSeamenBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

}
