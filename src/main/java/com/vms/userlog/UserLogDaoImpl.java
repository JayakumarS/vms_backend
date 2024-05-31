package com.vms.userlog;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vms.common.Selectivity;


@Repository
public class UserLogDaoImpl implements UserLogDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<UserLogBean> getUserLogList(UserLogBean bean) throws Exception {
		List<UserLogBean> userBean = new ArrayList<UserLogBean>();
		try {
			
			String whereCode="";
			if(!bean.getFromDate().equals("")) {
				whereCode+=" and date >= to_date('"+bean.getFromDate()+"','dd-MM-yyyy')";
			} 
			
			if(!bean.getToDate().equals("")) {
				whereCode+=" and date <= to_date('"+bean.getToDate()+"','dd-MM-yyyy')";
			}
			
			if(!bean.getStatus().equals("")) {
				whereCode+=" and status='"+bean.getStatus()+"'";
			}
			
			if(!bean.getUserName().equals("")) {
				whereCode+=" and user_name='"+bean.getUserName()+"'";
			}
			
	     userBean = jdbcTemplate.query(UserLogQueryUtil.getUserLogList+whereCode+"order by audit_log_id desc",new BeanPropertyRowMapper<UserLogBean>(UserLogBean.class));
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return userBean;
	}

	@Override
	public UserLogResultBean getUserName() {
		// TODO Auto-generated method stub
		UserLogResultBean rb = new UserLogResultBean();
		List<Selectivity> userList = null;
		try {
			userList = jdbcTemplate.query(new UserLogQueryUtil().Get_UserName_List,
					new BeanPropertyRowMapper<Selectivity>(Selectivity.class));
			rb.setUserNameList(userList);
		}catch(Exception e){
			e.printStackTrace();
		}
		return rb;
	}
	
	
	@Override
	public UserLogResultBean getemployeelist() {
		// TODO Auto-generated method stub
		UserLogResultBean rb = new UserLogResultBean();
		List<Selectivity> userList = null;
		try {
			userList = jdbcTemplate.query(new UserLogQueryUtil().get_employee_list,
					new BeanPropertyRowMapper<Selectivity>(Selectivity.class));
			rb.setUserNameList(userList);
		}catch(Exception e){
			e.printStackTrace();
		}
		return rb;
	}
	public UserLogResultBean getEmployeepuncheslist(UserLogBean bean) throws Exception {
		
		UserLogResultBean resultBean = new UserLogResultBean();
		String whereCondition=" ";
		
		
		if(bean.getName()!=null && !bean.getName().isEmpty() ) {
			whereCondition+=" and (bu1.user_id='"+bean.getName()+"') ";
		}
		
		if(bean.getFromDate()!=null && !bean.getFromDate().isEmpty() ) {
			whereCondition+=" and (bc1.checktime::date >= to_date('"+bean.getFromDate()+"', 'dd/mm/yyyy'))";
		}
		
		if(bean.getToDate()!=null && !bean.getToDate().isEmpty() ) {
			whereCondition+=" and (bc1.checktime::date <= to_date('"+bean.getToDate()+"', 'dd/mm/yyyy'))";
		}
		
		try {
			List<UserLogBean> list = jdbcTemplate.query(UserLogQueryUtil.get_Employeepunches_list+whereCondition+"group by bc1.checktime::date,bc1.user_id,bc1.sensor_id,bu1.name,bc1.checktime,bc2.checktime", new BeanPropertyRowMapper<UserLogBean> (UserLogBean.class));
		
			resultBean.setUserLogDetails(list);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return resultBean;
	}
	
	
}
