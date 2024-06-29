package com.vms.master.vesselType;

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

import com.vms.crew.rankGroup.RankGroupQueryUtil;


@Repository
public class VesselTypeDaoImpl implements VesselTypeDao{
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public VesselTypeResultBean save(VesselTypeBean bean) {
		VesselTypeResultBean resultBean = new VesselTypeResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			
			int code =  jdbcTemplate.queryForObject(VesselTypeQueryUtil.get_code,new Object[] { bean.getCode() },Integer.class);

			 if(code==0) {
			Map<String, Object> vesselType = new HashMap<String, Object>();
			
				vesselType.put("userName", userDetails.getUsername());
				vesselType.put("code", bean.getCode());
				vesselType.put("desc", bean.getDescription());
				namedParameterJdbcTemplate.update(VesselTypeQueryUtil.SAVE_VESSEL_TYPE,vesselType);
			
			
		   resultBean.setSuccess(true);
	            }
		        else {
			 		   resultBean.setMessage(  bean.getCode() +" already exists,please enter a different Vessel Type Code");

		        }
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
	 		   resultBean.setMessage("Not Updated");

		}
		return resultBean;
	}

	@Override
	public VesselTypeResultBean getList() {
		VesselTypeResultBean resultBean = new VesselTypeResultBean();
		List<VesselTypeBean> listBean = new ArrayList<VesselTypeBean>();
		
		try {
			listBean = jdbcTemplate.query(VesselTypeQueryUtil.getList,new BeanPropertyRowMapper<VesselTypeBean>(VesselTypeBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public VesselTypeResultBean edit(Integer id) {		
		VesselTypeResultBean resultBean = new VesselTypeResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(VesselTypeQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<VesselTypeBean>(VesselTypeBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public VesselTypeResultBean delete(Integer id) {
		VesselTypeResultBean resultBean = new VesselTypeResultBean();
		String code = null;

		try {
			code = jdbcTemplate.queryForObject(VesselTypeQueryUtil.getCodeById, new Object[]{id}, String.class);

			
			
			jdbcTemplate.update(VesselTypeQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public VesselTypeResultBean update(VesselTypeBean bean) {
		VesselTypeResultBean resultBean = new VesselTypeResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			
		String vessetypecode =  jdbcTemplate.queryForObject(VesselTypeQueryUtil.vessetype_code,new Object[] { bean.getVessetypeid() },String.class);
			
			
			int code =  jdbcTemplate.queryForObject(VesselTypeQueryUtil.get_code_edit,new Object[] { bean.getCode(),vessetypecode },Integer.class);


			
            if(code==0) {
			Map<String, Object> vesselType = new HashMap<String, Object>();
			
				vesselType.put("userName", userDetails.getUsername());
				vesselType.put("code", bean.getCode());
				vesselType.put("desc", bean.getDescription());				
				vesselType.put("vessetypeid", bean.getVessetypeid());

					namedParameterJdbcTemplate.update(VesselTypeQueryUtil.UPDATE_VESSEL_TYPE,vesselType);
			
					   resultBean.setSuccess(true);
            }
            else {
 	 		   resultBean.setMessage(  bean.getCode() +" already exists,please enter a different Rank Group Code");

            }		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
	 		   resultBean.setMessage("Not Updated");

		}
		return resultBean;
	}
	
	

}
