package com.vms.master.department;

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
public class DepartmentDaoImpl implements DepartmentDao {
	

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired 
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public DepartmentResultBean save(DepartmentBean bean) {
		// TODO Auto-generated method stub
		DepartmentResultBean resultBean = new DepartmentResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			Map<String, Object> department = new HashMap<String, Object>();
				
				if(bean.getActive()!=null && bean.getActive().equalsIgnoreCase("true")) {
					bean.setActive("Y");
				} else {
					bean.setActive("N");
				}
				
				Integer i = jdbcTemplate.queryForObject(DepartmentQueryUtil.check_code_exists, new Object[] { bean.getCode() },Integer.class);
				Integer j=  jdbcTemplate.queryForObject(DepartmentQueryUtil.check_name_exists, new Object[] { bean.getName() },Integer.class);
				
				if(i==0 && j==0) {
					department.put("userName", userDetails.getUsername());
					department.put("code", bean.getCode());
					department.put("name", bean.getName());
					department.put("head", bean.getHead());
					department.put("active", bean.getActive());
					
					namedParameterJdbcTemplate.update(DepartmentQueryUtil.department_save,department);
				
			   resultBean.setSuccess(true);
					}
				else{
					resultBean.setMsg("These details already exist");
				 }
				
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
			resultBean.setMsg("Not Updated");
		}
		return resultBean;
	}
	
	@Override
	public DepartmentResultBean getList() {
		// TODO Auto-generated method stub
		DepartmentResultBean resultBean = new DepartmentResultBean();
		List<DepartmentBean> listBean = new ArrayList<DepartmentBean>();
		
		try {
			listBean = jdbcTemplate.query(DepartmentQueryUtil.department_list,new BeanPropertyRowMapper<DepartmentBean>(DepartmentBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public DepartmentResultBean edit(Integer id) {
		// TODO Auto-generated method stub
		DepartmentResultBean resultBean = new DepartmentResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setDepartmentBean(jdbcTemplate.queryForObject(DepartmentQueryUtil.department_edit,new Object[] { id }, new BeanPropertyRowMapper<DepartmentBean>(DepartmentBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public DepartmentResultBean delete(Integer id) {
		// TODO Auto-generated method stub
		DepartmentResultBean resultBean = new DepartmentResultBean();
		String code=null;
		
		try {
			code = jdbcTemplate.queryForObject(DepartmentQueryUtil.getCodeById, new Object[]{id}, String.class);
			
			jdbcTemplate.update(DepartmentQueryUtil.department_delete,id);
			resultBean.setSuccess(true);
		}
		catch (DataAccessException e) {
			String errorMessage = e.getMessage();
	        if (errorMessage.contains("violates foreign key constraint")) {
	            resultBean.setSuccess(false);
	            resultBean.setMsg(code + " code cannot be deleted as it is already used in system.");
	        } else {
	            e.printStackTrace();
	            resultBean.setSuccess(false);
	            resultBean.setMsg("Error in Delete");
	        }
	    }
		return resultBean;
	}

	@Override
	public DepartmentResultBean update(DepartmentBean bean) {
		// TODO Auto-generated method stub
		DepartmentResultBean resultBean = new DepartmentResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
           try {
        	   
        	//String deptcode =  jdbcTemplate.queryForObject(DepartmentQueryUtil.dept_code,new Object[] { bean.getDeptId() },String.class);
			String deptname =  jdbcTemplate.queryForObject(DepartmentQueryUtil.dept_name,new Object[] { bean.getDeptId() },String.class);

			
			
			//int code =  jdbcTemplate.queryForObject(DepartmentQueryUtil.get_code_edit,new Object[] { bean.getCode(),deptcode },Integer.class);

		    int name =  jdbcTemplate.queryForObject(DepartmentQueryUtil.get_name_edit,new Object[] { bean.getName(),deptname },Integer.class);

			
            if(name==0) {
		    
			Map<String, Object> department = new HashMap<String, Object>();
			
			 if(bean.getActive()!=null && bean.getActive().equalsIgnoreCase("true")) {
                 bean.setActive("Y");
                }
              else {
                      bean.setActive("N");
                }
			
			department.put("userName", userDetails.getUsername());
			department.put("deptId",bean.getDeptId());
			department.put("code", bean.getCode());
			department.put("name", bean.getName());
			department.put("head", bean.getHead());
			department.put("active", bean.getActive());

				namedParameterJdbcTemplate.update(DepartmentQueryUtil.department_update,department);
		
		   resultBean.setSuccess(true);
            }
            else {
     		   resultBean.setMsg("These details already exist");

            }
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
	 		   resultBean.setMsg("Not Updated");

		}
		return resultBean;
		
	}
	@Override
	public DepartmentBean getSequenceCode() {
	    DepartmentBean department = new DepartmentBean();

	    try {
	        String dept_id = jdbcTemplate.queryForObject(DepartmentQueryUtil.get_dept_id, String.class);
	        department.setCode(dept_id);
	    } catch (Exception e) {
	        // Log the exception
	        e.printStackTrace();
	    }

	    return department;
	}
}
	
	
