package com.vms.crew.rankGroup;

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

import com.vms.crew.certificates.CertificatesQueryutil;
import com.vms.vessel.vesselOwner.VesselOwnerQueryUtil;



@Repository
public class RankGroupDaoImpl implements RankGroupDao {

	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public RankGroupResultBean save(RankGroupBean bean) {
		RankGroupResultBean resultBean = new RankGroupResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			
			int code =  jdbcTemplate.queryForObject(RankGroupQueryUtil.get_code,new Object[] { bean.getCode() },Integer.class);

		    int desc =  jdbcTemplate.queryForObject(RankGroupQueryUtil.get_desc,new Object[] { bean.getDescription() },Integer.class);

			
            if(code==0 && desc==0) {
			Map<String, Object> rankgroup = new HashMap<String, Object>();
			
				rankgroup.put("userName", userDetails.getUsername());
				rankgroup.put("code", bean.getCode());
				rankgroup.put("desc", bean.getDescription());
				rankgroup.put("remarks", bean.getRemarks());

				
				namedParameterJdbcTemplate.update(RankGroupQueryUtil.SAVE_rank_group,rankgroup);
			
			
		   resultBean.setSuccess(true);
             }
        else {
 		   resultBean.setMessage("These details already exist");

        }
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
	 		   resultBean.setMessage("Not Updated");

		}
		return resultBean;
	}

	@Override
	public RankGroupResultBean getList() {
		RankGroupResultBean resultBean = new RankGroupResultBean();
		List<RankGroupBean> listBean = new ArrayList<RankGroupBean>();
		
		try {
			listBean = jdbcTemplate.query(RankGroupQueryUtil.getList,new BeanPropertyRowMapper<RankGroupBean>(RankGroupBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public RankGroupResultBean edit(Integer id) {		
		RankGroupResultBean resultBean = new RankGroupResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(RankGroupQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<RankGroupBean>(RankGroupBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}

	@Override
	public RankGroupResultBean delete(Integer id) {
		RankGroupResultBean resultBean = new RankGroupResultBean();
		try {
			jdbcTemplate.update(RankGroupQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			   String errorMessage = e.getMessage();
		        if (errorMessage.contains("violates foreign key constraint")) {
		            resultBean.setSuccess(false);
		            resultBean.setMessage("Cannot delete this rank group because it is referenced in another");
		        } else {
		            e.printStackTrace();
		            resultBean.setSuccess(false);
		            resultBean.setMessage("Error in Delete");
		        }
		}	
		return resultBean;
	}

	@Override
	public RankGroupResultBean update(RankGroupBean bean) {
		RankGroupResultBean resultBean = new RankGroupResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			
			String rankGroupcode =  jdbcTemplate.queryForObject(RankGroupQueryUtil.rankGroup_code,new Object[] { bean.getRankgroupid() },String.class);
			String rankGroupdesc =  jdbcTemplate.queryForObject(RankGroupQueryUtil.rankGroup_desc,new Object[] { bean.getRankgroupid() },String.class);

			
			
			int code =  jdbcTemplate.queryForObject(RankGroupQueryUtil.get_code_edit,new Object[] { bean.getCode(),rankGroupcode },Integer.class);

		    int desc =  jdbcTemplate.queryForObject(RankGroupQueryUtil.get_desc_edit,new Object[] { bean.getDescription(),rankGroupdesc },Integer.class);

			
            if(code==0 && desc==0) {
		    
			Map<String, Object> rankgroup = new HashMap<String, Object>();
			
				rankgroup.put("userName", userDetails.getUsername());
				rankgroup.put("code", bean.getCode());
				rankgroup.put("desc", bean.getDescription());
				rankgroup.put("remarks", bean.getRemarks());

				rankgroup.put("rankgroupid", bean.getRankgroupid());

				namedParameterJdbcTemplate.update(RankGroupQueryUtil.UPDATE_rank_group,rankgroup);
		
		   resultBean.setSuccess(true);
            }
            else {
     		   resultBean.setMessage("These details already exist");

            }
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
	 		   resultBean.setMessage("Not Updated");

		}
		return resultBean;
	}
	
	
}
