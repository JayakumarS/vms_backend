package com.vms.companyMaster;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;


@Repository
public class CompanyMasterDaoImpl implements CompanyMasterDao {
	
	@Value("${secret-key}")
	private String secretKey;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public CompanyMasterResultBean save(CompanyMasterBean bean) throws Exception {
		CompanyMasterResultBean resultBean = new CompanyMasterResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			Map<String, Object> companyMasterMap = new HashMap<String, Object>();
			
			companyMasterMap.put("userName", userDetails.getUsername());
			companyMasterMap.put("companyName",bean.getCompanyName());
			companyMasterMap.put("companyLogo", bean.getCompanyLogo());
			companyMasterMap.put("companyLogo", bean.getLogoUpload());
			companyMasterMap.put("backGroundImg", bean.getBackGroundImg());
			companyMasterMap.put("backGroundImg", bean.getBgUpload());
//			companyMasterMap.put("deptStatus", bean.isDeptStatus());
	
			namedParameterJdbcTemplate.update(CompanyMasterQueryUtil.INSERT_COMPANY_MASTER,companyMasterMap);
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		
		return resultBean;
	}

	@Override
	public CompanyMasterResultBean getCompanyList() throws Exception {
		// TODO Auto-generated method stub
		CompanyMasterResultBean resultBean = new CompanyMasterResultBean();
		String logo = jdbcTemplate.queryForObject(CompanyMasterQueryUtil.Get_Company_Logo,String.class);
		resultBean.setCompanyLogo(logo);
	    return resultBean;
	}

}
