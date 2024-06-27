package com.vms.crew.maintain.OffSign;

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

@Repository
public class OffSignDaoImpl implements OffSignDao{
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public OffSignResultBean saveOffSign(OffSignBean bean) {
		OffSignResultBean resultBean = new OffSignResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> offSign = new HashMap<String, Object>();
			
			offSign.put("userName", userDetails.getUsername());
			offSign.put("vesselType", bean.getOffSignVesselType());
			offSign.put("remarks", bean.getRemarks());
				
			Integer code = namedParameterJdbcTemplate.queryForObject(OffSignQueryUtil.SAVE_OFF_SIGN_HDR,offSign,Integer.class);
			
			savedetail(bean,code);
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
	
	@Override
	public OffSignResultBean savedetail(OffSignBean bean,Integer code) {
		OffSignResultBean resultBean = new OffSignResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> offSignDtl = new HashMap<String, Object>();
			
			for(OffSignBean listBean : bean.getOffSignDetail()) {
				offSignDtl.put("userName", userDetails.getUsername());
				offSignDtl.put("code", code);
				offSignDtl.put("nationality", listBean.getOffSignNationality());
				offSignDtl.put("rank", listBean.getOffSignRank());
				offSignDtl.put("month", listBean.getOffSignMonth());
			
				
				namedParameterJdbcTemplate.update(OffSignQueryUtil.SAVE_OFF_SIGN_DTL,offSignDtl);
			}
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public OffSignResultBean listOffSign() {
		OffSignResultBean resultBean = new OffSignResultBean();
		List<OffSignBean> listBean = new ArrayList<OffSignBean>();
		
		try {
			listBean = jdbcTemplate.query(OffSignQueryUtil.GET_OFFSIGN_LIST,new BeanPropertyRowMapper<OffSignBean>(OffSignBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}
	
	@Override
	public OffSignResultBean editOffSign(Integer id) {		
		OffSignResultBean resultBean = new OffSignResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(OffSignQueryUtil.GET_EDIT_OFFSIGN,new Object[] { id }, new BeanPropertyRowMapper<OffSignBean>(OffSignBean.class)));
			
			List<OffSignBean> sampleDtl = jdbcTemplate.query(OffSignQueryUtil.GET_EDIT_OFFSIGN_DTL,new Object[] { id },new BeanPropertyRowMapper<OffSignBean>(OffSignBean.class));	
			resultBean.setOffSignDetail(sampleDtl);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}
	
	
	@Override
	public OffSignResultBean deleteOffSign(Integer id) {
		OffSignResultBean resultBean = new OffSignResultBean();
		try {
			jdbcTemplate.update(OffSignQueryUtil.DELETE_OFFSIGN,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
		          e.printStackTrace();
		          resultBean.setSuccess(false);

		}	
		return resultBean;
	}

	@Override
	public OffSignResultBean updateOffSign(OffSignBean bean) {
		OffSignResultBean resultBean = new OffSignResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {

			Map<String, Object> offSignDtl = new HashMap<String, Object>();
			
			offSignDtl.put("userName", userDetails.getUsername());
			offSignDtl.put("vesselType", bean.getOffSignVesselType());
			offSignDtl.put("offSignId", bean.getOffSignId());
			offSignDtl.put("remarks", bean.getRemarks());

			
			Integer headerId= namedParameterJdbcTemplate.queryForObject(OffSignQueryUtil.UPDATE_OFFSIGN,offSignDtl,Integer.class);

					
			if(headerId !=null) {
				jdbcTemplate.update(OffSignQueryUtil.DELETE_OFFSIGN_DTL, headerId);
				
				for(OffSignBean listBean : bean.getOffSignDetail()) {
					offSignDtl.put("nationality",listBean.getOffSignNationality());
					offSignDtl.put("rank", listBean.getOffSignRank());
					offSignDtl.put("month", listBean.getOffSignMonth());
					offSignDtl.put("month", listBean.getOffSignMonth());
					offSignDtl.put("code", headerId);
				
					
					namedParameterJdbcTemplate.update(OffSignQueryUtil.SAVE_OFF_SIGN_DTL,offSignDtl);
				}
				
//				for(int i=0;i<bean.getOffSignDetail().size();i++) {			
//					
//					offSignDtl.put("nationality",bean.getOffSignNationality());
//					offSignDtl.put("rank", bean.getOffSignRank());
//					offSignDtl.put("month", bean.getOffSignMonth());
//					offSignDtl.put("month", bean.getOffSignMonth());
//					offSignDtl.put("code", headerId);
//
//
//					namedParameterJdbcTemplate.update(OffSignQueryUtil.SAVE_OFF_SIGN_DTL,offSignDtl);
//				}
			  }
				
		   resultBean.setSuccess(true);
         
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
}
