package com.vms.crew.crewVesselAssignment;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.stereotype.Repository;






@Repository

public class CrewVesselAssignmentDaoImpl implements CrewVesselAssignmentDao{
	
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<CrewVesselAssignmentBean> getvessel() {
		List<CrewVesselAssignmentBean> getvessel = new ArrayList<>();

		try {
			getvessel = jdbcTemplate.query(CrewVesselAssignmentQueryUtil.getvessel, new Object[] {},new BeanPropertyRowMapper<>(CrewVesselAssignmentBean.class));

				

		} catch (Exception e) {
		}
		return getvessel;
	}
	
	@Override
	public List<CrewVesselAssignmentBean> getrank() {
		List<CrewVesselAssignmentBean> getrank = new ArrayList<>();

		try {
			getrank = jdbcTemplate.query(CrewVesselAssignmentQueryUtil.getrank, new Object[] {},new BeanPropertyRowMapper<>(CrewVesselAssignmentBean.class));

				

		} catch (Exception e) {
		}
		return getrank;
	}
	
	@Override
	public List<CrewVesselAssignmentBean> getport() {
		List<CrewVesselAssignmentBean> getport = new ArrayList<>();

		try {
			getport = jdbcTemplate.query(CrewVesselAssignmentQueryUtil.getport, new Object[] {},new BeanPropertyRowMapper<>(CrewVesselAssignmentBean.class));

				

		} catch (Exception e) {
		}
		return getport;
	}
	
	@Override
	public CrewVesselAssignmentResultBean getList() {
		CrewVesselAssignmentResultBean resultBean = new CrewVesselAssignmentResultBean();
		List<CrewVesselAssignmentBean> listBean = new ArrayList<CrewVesselAssignmentBean>();
		
		try {
			listBean = jdbcTemplate.query(CrewVesselAssignmentQueryUtil.getList,new BeanPropertyRowMapper<CrewVesselAssignmentBean>(CrewVesselAssignmentBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}
//	@Override
//	public List<CrewVesselAssignmentBean> showlist(CrewVesselAssignmentBean bean) {
//
//		List<CrewVesselAssignmentBean> CrewVesselAssignmentBean = new ArrayList<>();
//		
//		
//		try {
//		
//		} catch (Exception e) {
//		}
//		return CrewVesselAssignmentBean;
//	}
	
//	@Override
//	public boolean savelist(CrewVesselAssignmentBean alPaymentInformationList) {
//
//		
//	
//	
//
//		try {
//			
//		} catch (Exception e) {
//		}
//		return true;
//	}

//	@Override
//	public List<CrewVesselAssignmentBean> showlist(CrewVesselAssignmentBean Bean) throws Exception {
//		List<CrewVesselAssignmentBean> vslDtlList = new ArrayList<CrewVesselAssignmentBean>();
//		try {
//			String sql = CrewVesselAssignmentQueryUtil.SEARCH_VSL_DTL;
//
//			if (Bean.getVessel() != null && !Bean.getVessel().isEmpty()) {
//				sql += " and vessel ='" + Bean.getVessel().trim() + "'";
//			}
//			
//			if (Bean.getRankcode() != null && !Bean.getRankcode().isEmpty()) {
//				sql += " and rankcode='" + Bean.getRankcode().trim() + "'";
//			}
//			if (Bean.getDate() != null && !Bean.getDate().isEmpty()) {
//				sql += " and date='" + Bean.getDate().trim() + "'";
//			}
//			
////			sql += " order by a.created_dt desc) temp limit 1000";
//			System.out.println("Search = " + sql);
//			vslDtlList = jdbcTemplate.query(sql, new Object[] {}, new BeanPropertyRowMapper<CrewVesselAssignmentBean>(
//					CrewVesselAssignmentBean.class));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return vslDtlList;
//	}
	
	

	        @Override
	        public List<CrewVesselAssignmentBean> showlist(CrewVesselAssignmentBean Bean) throws Exception {
	            List<CrewVesselAssignmentBean> vslDtlList = new ArrayList<CrewVesselAssignmentBean>();
	            try {
	                // Base SQL query
	             
	    	        String sql = CrewVesselAssignmentQueryUtil.SEARCH_VSL_DTL;

	                Map<String, Object> params = new HashMap<>();

	                // Add conditions based on Bean properties
	                if (Bean.getVessel() != null && !Bean.getVessel().isEmpty()) {
	                    List<String> vesselIds = Bean.getVessel().stream()
	                        .map(v -> (String) v.get("id")).collect(Collectors.toList());

	                    sql += " AND hdr.m_seamen_vessel_code IN (:vesselIds)";
	                    params.put("vesselIds", vesselIds);
	                }

	                if (Bean.getRankcode() != null && !Bean.getRankcode().isEmpty()) {
	                    List<Integer> rankIds = Bean.getRankcode().stream()
	                            .map(v -> Integer.parseInt((String) v.get("id")))
	                            .collect(Collectors.toList());

	                    sql += " AND dtl.m_seamen_rank_code IN (:rankcode)";
	                    params.put("rankcode", rankIds);
	                }

	                if (Bean.getDate() != null && !Bean.getDate().isEmpty()) {
	                    String dateString = Bean.getDate().trim();
	                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	                    try {
	                        Date parsedDate = dateFormat.parse(dateString);
	                        Timestamp startDateTimestamp = new Timestamp(parsedDate.getTime());

	                        sql += " AND hdr.m_seamen_starting_date = :startDate";
	                        params.put("startDate", startDateTimestamp);
	                    } catch (ParseException e) {
	                        e.printStackTrace();
	                    }
	                }

	                // Add ordering by rank and vessel
	                sql += " ORDER BY rank_master.rank_name, hdr.m_seamen_vessel_code ASC";

	                System.out.println("Search = " + sql);

	                // Execute query
	                vslDtlList = namedParameterJdbcTemplate.query(sql, params, 
	                                new BeanPropertyRowMapper<>(CrewVesselAssignmentBean.class));
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            return vslDtlList;
	        }

	        
	
	    	

}
