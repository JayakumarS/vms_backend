package com.vms.crew.utilities.MultiSeamen;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.vms.crew.rankWorkingShift.RankWorkingShiftQueryUtil;

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
				
			namedParameterJdbcTemplate.update(MultiSeamenQueryUtil.SAVE_MULTI_SEAMEN_HDR,multiSeamen);
			
			savedetail(bean);
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
	
	@Override
	public MultiSeamenResultBean savedetail(MultiSeamenBean bean) {
		MultiSeamenResultBean resultBean = new MultiSeamenResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> multiSeamenDtl = new HashMap<String, Object>();
			
			for(MultiSeamenBean listBean : bean.getMultiseamendetail()) {
				multiSeamenDtl.put("userName", userDetails.getUsername());
				multiSeamenDtl.put("code", listBean.getCode());
				multiSeamenDtl.put("name", listBean.getName());
				multiSeamenDtl.put("rank", listBean.getRank());
				multiSeamenDtl.put("pay", listBean.getPay());
				multiSeamenDtl.put("currency", listBean.getCurrency());
				multiSeamenDtl.put("joiningDate", listBean.getJoiningDate());
				multiSeamenDtl.put("estSignOff", listBean.getEstSignOff());
			
				
				namedParameterJdbcTemplate.update(MultiSeamenQueryUtil.SAVE_MULTI_SEAMEN_DTL,multiSeamenDtl);
			}
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

}
