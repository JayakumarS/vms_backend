package com.vms.crew.maintain.ranktrainings;

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

@Repository
public class RankTrainingsDaoImpl implements RankTrainingsDao{


		@Autowired
		NamedParameterJdbcTemplate namedParameterJdbcTemplate;
		
		@Autowired
		JdbcTemplate jdbcTemplate;
		
		@Override
		public RankTrainingsResultBean getList() {
			RankTrainingsResultBean resultBean = new RankTrainingsResultBean();
			List<RankTrainingsBean> listBean = new ArrayList<RankTrainingsBean>();
			
			try {
				listBean = jdbcTemplate.query(RankTrainingsQueryUtil.getList,new BeanPropertyRowMapper<RankTrainingsBean>(RankTrainingsBean.class));
				resultBean.setList(listBean);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return resultBean;
		}
		
		
		@Override
		public RankTrainingsResultBean getsavelist() {
			RankTrainingsResultBean resultBean = new RankTrainingsResultBean();
			List<RankTrainingsBean> listBean = new ArrayList<RankTrainingsBean>();
			
			try {
				listBean = jdbcTemplate.query(RankTrainingsQueryUtil.getListALL,new BeanPropertyRowMapper<RankTrainingsBean>(RankTrainingsBean.class));
				resultBean.setList(listBean);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return resultBean;
		}
		
		@Override
		public RankTrainingsResultBean save(List<RankTrainingsBean> selectedCertificates) {
			RankTrainingsResultBean resultBean = new RankTrainingsResultBean();

		    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		    try {
		    	 for (RankTrainingsBean listBean : selectedCertificates) {
	            jdbcTemplate.update(RankTrainingsQueryUtil.DELETE_trainings, new Object[]{listBean.getRankcode()});
		    	 }
		        for (RankTrainingsBean listBean1 : selectedCertificates) {
		            Map<String, Object> certificate = new HashMap<>();
		            certificate.put("code", listBean1.getTrainingcode());
		            certificate.put("desc", listBean1.getRankcode());
		            certificate.put("userName", userDetails.getUsername());

		            Integer rankCertificateId = jdbcTemplate.queryForObject(RankTrainingsQueryUtil.checkDelete,
		                new Object[]{listBean1.getTrainingcode(), listBean1.getRankcode()}, Integer.class);

		            if (rankCertificateId == 0) {
		                namedParameterJdbcTemplate.update(RankTrainingsQueryUtil.SAVE_trainings, certificate);
		            } else {

		                namedParameterJdbcTemplate.update(RankTrainingsQueryUtil.SAVE_trainings, certificate);
		            
		            }
		        }

		        resultBean.setSuccess(true);
		    } catch (DataAccessException e) {
		        e.printStackTrace(); // Log the error instead of just printing stack trace
		        resultBean.setSuccess(false);
		    }
		    return resultBean;
		}

		@Override
		public List<RankTrainingsBean> getrank() {
			List<RankTrainingsBean> getrank = new ArrayList<>();

			try {
				getrank = jdbcTemplate.query(RankTrainingsQueryUtil.getrank, new Object[] {},new BeanPropertyRowMapper<>(RankTrainingsBean.class));

					

			} catch (Exception e) {
			}
			return getrank;
		}
}
