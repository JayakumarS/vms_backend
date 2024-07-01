package com.vms.common.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.vms.common.Email;
import com.vms.common.EmailService;

@Repository
public class CommonServiceDaoImpl implements CommonServiceDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	PasswordEncoder encoder;
	
	
	@Autowired
	EmailService emailService;
	
	
	@Override
	public boolean validateUnique(String tableName, String columnName, String columnValue) {
		boolean count =  jdbcTemplate.queryForObject(CommonServiceQueryUtil.VALIDATE_UNIQUE,new Object[] { tableName,columnName,columnValue }, Boolean.class);
		return count;
	}


	@Override
	public HashMap<String, Object> forgotPassword(String emailId, String otpForForgotPassword) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<CommonServiceBean> getFleetList() {
		List<CommonServiceBean> lCommonUtilityBean = new ArrayList<CommonServiceBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(CommonServiceQueryUtil.FLEET_LIST,new Object[]{},new BeanPropertyRowMapper<CommonServiceBean>(CommonServiceBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lCommonUtilityBean;
	}


	@Override
	public List<CommonServiceBean> getClassList() {
		List<CommonServiceBean> lCommonUtilityBean = new ArrayList<CommonServiceBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(CommonServiceQueryUtil.CLASS_LIST,new Object[]{},new BeanPropertyRowMapper<CommonServiceBean>(CommonServiceBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lCommonUtilityBean;
	}


	@Override
	public List<CommonServiceBean> getVesselType() {
		List<CommonServiceBean> lCommonUtilityBean = new ArrayList<CommonServiceBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(CommonServiceQueryUtil.VESSEL_TYPE,new Object[]{},new BeanPropertyRowMapper<CommonServiceBean>(CommonServiceBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lCommonUtilityBean;
	}


	@Override
	public List<CommonServiceBean> getVesselInsurance() {
		List<CommonServiceBean> lCommonUtilityBean = new ArrayList<CommonServiceBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(CommonServiceQueryUtil.VESSEL_INSURANCE,new Object[]{},new BeanPropertyRowMapper<CommonServiceBean>(CommonServiceBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lCommonUtilityBean;
	}


	@Override
	public List<CommonServiceBean> getWageScale() {
		List<CommonServiceBean> lCommonUtilityBean = new ArrayList<CommonServiceBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(CommonServiceQueryUtil.WAGE_SCALE,new Object[]{},new BeanPropertyRowMapper<CommonServiceBean>(CommonServiceBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lCommonUtilityBean;
	}


	@Override
	public List<CommonServiceBean> getPort() {
		List<CommonServiceBean> lCommonUtilityBean = new ArrayList<CommonServiceBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(CommonServiceQueryUtil.GET_PORT,new Object[]{},new BeanPropertyRowMapper<CommonServiceBean>(CommonServiceBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lCommonUtilityBean;
	}


	@Override
	public List<CommonServiceBean> getCountry() {
		List<CommonServiceBean> lCommonUtilityBean = new ArrayList<CommonServiceBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(CommonServiceQueryUtil.GET_COUNTRY,new Object[]{},new BeanPropertyRowMapper<CommonServiceBean>(CommonServiceBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lCommonUtilityBean;
	}


	@Override
	public List<CommonServiceBean> getVesselOwner() {
		List<CommonServiceBean> lCommonUtilityBean = new ArrayList<CommonServiceBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(CommonServiceQueryUtil.GET_VESSEL_OWNER,new Object[]{},new BeanPropertyRowMapper<CommonServiceBean>(CommonServiceBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lCommonUtilityBean;
	}


	@Override
	public List<CommonServiceBean> getOfficialManagers() {
		List<CommonServiceBean> lCommonUtilityBean = new ArrayList<CommonServiceBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(CommonServiceQueryUtil.GET_OFFICIAL_MANAGERS,new Object[]{},new BeanPropertyRowMapper<CommonServiceBean>(CommonServiceBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lCommonUtilityBean;
	}


	@Override
	public List<CommonServiceBean> getShipManagers() {
		List<CommonServiceBean> lCommonUtilityBean = new ArrayList<CommonServiceBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(CommonServiceQueryUtil.GET_SHIP_MANAGERS,new Object[]{},new BeanPropertyRowMapper<CommonServiceBean>(CommonServiceBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lCommonUtilityBean;
	}
	
	@Override
	public List<CommonServiceBean> getCurrency() {
		List<CommonServiceBean> lCommonUtilityBean = new ArrayList<CommonServiceBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(CommonServiceQueryUtil.GET_CURRENCY,new Object[]{},new BeanPropertyRowMapper<CommonServiceBean>(CommonServiceBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lCommonUtilityBean;
	}

	@Override
	public List<CommonServiceBean> getphoneCode() {
		List<CommonServiceBean> lCommonUtilityBean = new ArrayList<CommonServiceBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(CommonServiceQueryUtil.GET_PHONECODE,new Object[]{},new BeanPropertyRowMapper<CommonServiceBean>(CommonServiceBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lCommonUtilityBean;
	}
	
	@Override
	public List<CommonServiceBean> getVessel() {
		List<CommonServiceBean> lCommonUtilityBean = new ArrayList<CommonServiceBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(CommonServiceQueryUtil.GET_VESSEL,new Object[]{},new BeanPropertyRowMapper<CommonServiceBean>(CommonServiceBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lCommonUtilityBean;
	}

	@Override
	public List<CommonServiceBean> getRankMasters() {
		List<CommonServiceBean> lCommonUtilityBean = new ArrayList<CommonServiceBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(CommonServiceQueryUtil.GET_RANK_MASTERS,new Object[]{},new BeanPropertyRowMapper<CommonServiceBean>(CommonServiceBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lCommonUtilityBean;
	}
 
	@Override
	public List<CommonServiceBean> getjoinport() {
		List<CommonServiceBean> lCommonUtilityBean = new ArrayList<CommonServiceBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(CommonServiceQueryUtil.GET_JOINPORT,new Object[]{},new BeanPropertyRowMapper<CommonServiceBean>(CommonServiceBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lCommonUtilityBean;
	}


	@Override
	public List<CommonServiceBean> getAgents() {
		List<CommonServiceBean> lCommonUtilityBean = new ArrayList<CommonServiceBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(CommonServiceQueryUtil.GET_AGENTS,new Object[]{},new BeanPropertyRowMapper<CommonServiceBean>(CommonServiceBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lCommonUtilityBean;
	}


	@Override
	public List<CommonServiceBean> getReligion() {
		List<CommonServiceBean> lCommonUtilityBean = new ArrayList<CommonServiceBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(CommonServiceQueryUtil.GET_RELIGION,new Object[]{},new BeanPropertyRowMapper<CommonServiceBean>(CommonServiceBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lCommonUtilityBean;
	}


	@Override
	public List<CommonServiceBean> getLicense() {
		List<CommonServiceBean> lCommonUtilityBean = new ArrayList<CommonServiceBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(CommonServiceQueryUtil.GET_WORK_LICENSE,new Object[]{},new BeanPropertyRowMapper<CommonServiceBean>(CommonServiceBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lCommonUtilityBean;
	}


	@Override
	public List<CommonServiceBean> getWorkStatus() {
		List<CommonServiceBean> lCommonUtilityBean = new ArrayList<CommonServiceBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(CommonServiceQueryUtil.GET_WORK_STATUS,new Object[]{},new BeanPropertyRowMapper<CommonServiceBean>(CommonServiceBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lCommonUtilityBean;
	}


	@Override
	public List<CommonServiceBean> getHealthStatus() {
		List<CommonServiceBean> lCommonUtilityBean = new ArrayList<CommonServiceBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(CommonServiceQueryUtil.GET_HEALTH_STATUS,new Object[]{},new BeanPropertyRowMapper<CommonServiceBean>(CommonServiceBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lCommonUtilityBean;
	}
	
	@Override
	public List<CommonServiceBean> getSeamenName() {
		List<CommonServiceBean> lCommonUtilityBean = new ArrayList<CommonServiceBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(CommonServiceQueryUtil.GET_SEAMEN_NAME,new Object[]{},new BeanPropertyRowMapper<CommonServiceBean>(CommonServiceBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lCommonUtilityBean;
	}
	
	@Override
	public List<CommonServiceBean>  getExpEngine() {
		List<CommonServiceBean> lCommonUtilityBean = new ArrayList<CommonServiceBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(CommonServiceQueryUtil.GET_EXP_ENGINE,new Object[]{},new BeanPropertyRowMapper<CommonServiceBean>(CommonServiceBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lCommonUtilityBean;
	}
	
	@Override
	public List<CommonServiceBean>  getgrouppage() {
		List<CommonServiceBean> lCommonUtilityBean = new ArrayList<CommonServiceBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(CommonServiceQueryUtil.GET_RANK_GROUP,new Object[]{},new BeanPropertyRowMapper<CommonServiceBean>(CommonServiceBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lCommonUtilityBean;
	}
	
	@Override
	public List<CommonServiceBean>  getdepartment() {
		List<CommonServiceBean> lCommonUtilityBean = new ArrayList<CommonServiceBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(CommonServiceQueryUtil.GET_DEPARTMENT,new Object[]{},new BeanPropertyRowMapper<CommonServiceBean>(CommonServiceBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lCommonUtilityBean;
	}
	
	
	@Override
	public List<CommonServiceBean>  getNationality() {
		List<CommonServiceBean> lCommonUtilityBean = new ArrayList<CommonServiceBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(CommonServiceQueryUtil.GET_NATIONALITY,new Object[]{},new BeanPropertyRowMapper<CommonServiceBean>(CommonServiceBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lCommonUtilityBean;
	}


	@Override
	public List<CommonServiceBean> getUom() {
		List<CommonServiceBean> lCommonUtilityBean = new ArrayList<CommonServiceBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(CommonServiceQueryUtil.GET_UOM,new Object[]{},new BeanPropertyRowMapper<CommonServiceBean>(CommonServiceBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lCommonUtilityBean;
	}
	
	
}
