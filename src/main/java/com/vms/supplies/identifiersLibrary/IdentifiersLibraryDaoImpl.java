package com.vms.supplies.identifiersLibrary;

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

import com.vms.crew.certificates.CertificatesQueryutil;
import com.vms.crew.trainings.TrainingsBean;
import com.vms.crew.trainings.TrainingsQueryUtil;
import com.vms.crew.trainings.TrainingsResultBean;
import com.vms.supplies.freightType.FreightTypeBean;
import com.vms.supplies.freightType.FreightTypeQueryUtil;
import com.vms.supplies.freightType.FreightTypeResultBean;





@Repository
public class IdentifiersLibraryDaoImpl implements IdentifiersLibraryDao {
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public IdentifiersLibraryBean getSequenceCode() {
	    IdentifiersLibraryBean storage = new IdentifiersLibraryBean();

	    try {
	        String storageId = jdbcTemplate.queryForObject(IdentifiersLibraryQueryUtil.get_storage_id, String.class);
	        storage.setCode1(storageId);
	    } catch (Exception e) {
	        // Log the exception
	        e.printStackTrace();
	    }

	    return storage;
	}
	
	@Override
	public IdentifiersLibraryResultBean save(IdentifiersLibraryBean bean) {
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			 
			Map<String, Object> freighttype = new HashMap<String, Object>();

				
				freighttype.put("userName", userDetails.getUsername());
				freighttype.put("code", bean.getCode());
				freighttype.put("desc", bean.getDescription());
				namedParameterJdbcTemplate.update(IdentifiersLibraryQueryUtil.SAVE_freight_type,freighttype);
		
			
			 resultBean.setSuccess(true);
			 
			 
		   
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
			resultBean.setMessage("Not Updated");
		}
		return resultBean;
	}
	
	
	@Override
	public IdentifiersLibraryResultBean delete(int id) {
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		String code = null; 
		try {

			
			jdbcTemplate.update(IdentifiersLibraryQueryUtil.delete,id);
			resultBean.setSuccess(true);
		}
	  catch (DataAccessException e) {
	     
	            e.printStackTrace();
	            resultBean.setSuccess(false);
	            resultBean.setMessage("error in delete");
	        
	    }	
		return resultBean;
	}
	
	@Override
	public IdentifiersLibraryResultBean deletestorage(int id) {
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		String code = null; 
		try {

			
			jdbcTemplate.update(IdentifiersLibraryQueryUtil.deletestorage,id);
			resultBean.setSuccess(true);
		}
	  catch (DataAccessException e) {
	     
	            e.printStackTrace();
	            resultBean.setSuccess(false);
	            resultBean.setMessage("error in delete");
	        
	    }	
		return resultBean;
	}
	
	@Override
	public IdentifiersLibraryResultBean deletefunction(int id) {
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		String code = null; 
		try {

			
			jdbcTemplate.update(IdentifiersLibraryQueryUtil.deletefunction,id);
			resultBean.setSuccess(true);
		}
	  catch (DataAccessException e) {
	     
	            e.printStackTrace();
	            resultBean.setSuccess(false);
	            resultBean.setMessage("error in delete");
	        
	    }	
		return resultBean;
	}
	@Override
	public IdentifiersLibraryResultBean deletedelivery(int id) {
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		String code = null; 
		try {

			
			jdbcTemplate.update(IdentifiersLibraryQueryUtil.deletedelivery,id);
			resultBean.setSuccess(true);
		}
	  catch (DataAccessException e) {
	     
	            e.printStackTrace();
	            resultBean.setSuccess(false);
	            resultBean.setMessage("error in delete");
	        
	    }	
		return resultBean;
	}
	
	@Override
	public IdentifiersLibraryResultBean deletelocation(int id) {
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		String code = null; 
		try {

			
			jdbcTemplate.update(IdentifiersLibraryQueryUtil.deletelocation,id);
			resultBean.setSuccess(true);
		}
	  catch (DataAccessException e) {
	     
	            e.printStackTrace();
	            resultBean.setSuccess(false);
	            resultBean.setMessage("error in delete");
	        
	    }	
		return resultBean;
	}
	
	@Override
	public IdentifiersLibraryResultBean deleteluboil(int id) {
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		String code = null; 
		try {

			
			jdbcTemplate.update(IdentifiersLibraryQueryUtil.deleteluboil,id);
			resultBean.setSuccess(true);
		}
	  catch (DataAccessException e) {
	     
	            e.printStackTrace();
	            resultBean.setSuccess(false);
	            resultBean.setMessage("error in delete");
	        
	    }	
		return resultBean;
	}
	
	@Override
	public IdentifiersLibraryResultBean deletepayment(int id) {
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		String code = null; 
		try {

			
			jdbcTemplate.update(IdentifiersLibraryQueryUtil.deletepayment,id);
			resultBean.setSuccess(true);
		}
	  catch (DataAccessException e) {
	     
	            e.printStackTrace();
	            resultBean.setSuccess(false);
	            resultBean.setMessage("error in delete");
	        
	    }	
		return resultBean;
	}
	
	@Override
	public IdentifiersLibraryResultBean deleteoffice(int id) {
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		String code = null; 
		try {

			
			jdbcTemplate.update(IdentifiersLibraryQueryUtil.deleteoffice,id);
			resultBean.setSuccess(true);
		}
	  catch (DataAccessException e) {
	     
	            e.printStackTrace();
	            resultBean.setSuccess(false);
	            resultBean.setMessage("error in delete");
	        
	    }	
		return resultBean;
	}
	@Override
	public IdentifiersLibraryResultBean update(IdentifiersLibraryBean bean) {
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
		
			Map<String, Object> freighttype = new HashMap<String, Object>();
			
		
			freighttype.put("userName", userDetails.getUsername());
			freighttype.put("code", bean.getCode());
			freighttype.put("desc", bean.getDescription());
				
			
				namedParameterJdbcTemplate.update(IdentifiersLibraryQueryUtil.UPDATE_freight_type,freighttype);
			
		
		   resultBean.setSuccess(true);
		  
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
			resultBean.setMessage("Not Updated");
		}
		return resultBean;
	}
	@Override
	public IdentifiersLibraryResultBean updatestorage(IdentifiersLibraryBean bean) {
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
		
			Map<String, Object> storageplaces = new HashMap<String, Object>();
			
		
			storageplaces.put("userName", userDetails.getUsername());
			storageplaces.put("code1", bean.getCode1());
			storageplaces.put("description", bean.getDescription());
			storageplaces.put("storageId", bean.getStorageId());

			
				namedParameterJdbcTemplate.update(IdentifiersLibraryQueryUtil.UPDATE_storage_places,storageplaces);
			
		
		   resultBean.setSuccess(true);
		  
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
			resultBean.setMessage("Not Updated");
		}
		return resultBean;
	}
	
	@Override
	public IdentifiersLibraryResultBean updatefunction(IdentifiersLibraryBean bean) {
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
		
			Map<String, Object> storageplaces = new HashMap<String, Object>();
			
		
			storageplaces.put("userName", userDetails.getUsername());
			storageplaces.put("code2", bean.getCode2());
			storageplaces.put("description", bean.getDescription());
			storageplaces.put("functionId", bean.getFunctionId());

			
				namedParameterJdbcTemplate.update(IdentifiersLibraryQueryUtil.UPDATE_function,storageplaces);
			
		
		   resultBean.setSuccess(true);
		  
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
			resultBean.setMessage("Not Updated");
		}
		return resultBean;
	}
	
	@Override
	public IdentifiersLibraryResultBean updatedelivery(IdentifiersLibraryBean bean) {
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
		
			Map<String, Object> delivery = new HashMap<String, Object>();
			
		
			delivery.put("userName", userDetails.getUsername());
			delivery.put("code1", bean.getCode1());
			delivery.put("description", bean.getDescription());
			delivery.put("scale", bean.getScale());
			delivery.put("itemId", bean.getItemId());

			
				namedParameterJdbcTemplate.update(IdentifiersLibraryQueryUtil.UPDATE_delivery,delivery);
			
		
		   resultBean.setSuccess(true);
		  
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
			resultBean.setMessage("Not Updated");
		}
		return resultBean;
	}
	
	@Override
	public IdentifiersLibraryResultBean updatelocation(IdentifiersLibraryBean bean) {
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
		
			Map<String, Object> location = new HashMap<String, Object>();
			
		
			location.put("userName", userDetails.getUsername());
			location.put("code2", bean.getCode2());
			location.put("description", bean.getDescription());
			
			location.put("locationId", bean.getLocationId());

			
				namedParameterJdbcTemplate.update(IdentifiersLibraryQueryUtil.UPDATE_location,location);
			
		
		   resultBean.setSuccess(true);
		  
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
			resultBean.setMessage("Not Updated");
		}
		return resultBean;
	}
	
	@Override
	public IdentifiersLibraryResultBean updateluboil(IdentifiersLibraryBean bean) {
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
		
			Map<String, Object> luboil = new HashMap<String, Object>();
			
		
			luboil.put("userName", userDetails.getUsername());
			luboil.put("code1", bean.getCode1());
			luboil.put("description", bean.getDescription());
			
			luboil.put("luboilId", bean.getLuboilId());

			
				namedParameterJdbcTemplate.update(IdentifiersLibraryQueryUtil.UPDATE_luboil,luboil);
			
		
		   resultBean.setSuccess(true);
		  
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
			resultBean.setMessage("Not Updated");
		}
		return resultBean;
	}
	
	@Override
	public IdentifiersLibraryResultBean updatepayment(IdentifiersLibraryBean bean) {
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
		
			Map<String, Object> payment = new HashMap<String, Object>();
			
		
			payment.put("userName", userDetails.getUsername());
			payment.put("code2", bean.getCode2());
			payment.put("description", bean.getDescription());
			payment.put("scale", bean.getScale());
			payment.put("advpayment", bean.getAdvancePayment());
			payment.put("paymentId", bean.getPaymentId());

			
				namedParameterJdbcTemplate.update(IdentifiersLibraryQueryUtil.UPDATE_payment,payment);
			
		
		   resultBean.setSuccess(true);
		  
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
			resultBean.setMessage("Not Updated");
		}
		return resultBean;
	}
	
	@Override
	public IdentifiersLibraryResultBean updateoffice(IdentifiersLibraryBean bean) {
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
		
			Map<String, Object> supplieroffice = new HashMap<String, Object>();
			
		
			supplieroffice.put("userName", userDetails.getUsername());
			supplieroffice.put("code2", bean.getCode2());
			supplieroffice.put("description", bean.getDescription());
			supplieroffice.put("supplierofficeId", bean.getSupplierofficeId());

			
				namedParameterJdbcTemplate.update(IdentifiersLibraryQueryUtil.UPDATE_office,supplieroffice);
			
		
		   resultBean.setSuccess(true);
		  
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
			resultBean.setMessage("Not Updated");
		}
		return resultBean;
	}
	
	
	@Override
	public IdentifiersLibraryResultBean savestorage(IdentifiersLibraryBean bean) {
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			 
			Map<String, Object> storage = new HashMap<String, Object>();

				
				storage.put("userName", userDetails.getUsername());
				storage.put("code1", bean.getCode1());
				storage.put("desc", bean.getDescription());
				namedParameterJdbcTemplate.update(IdentifiersLibraryQueryUtil.SAVE_storage,storage);
		
			 resultBean.setSuccess(true);
			 
			 
		   
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
			resultBean.setMessage("Not Updated");
		}
		return resultBean;
	}
	
	@Override
	public IdentifiersLibraryResultBean savefunction(IdentifiersLibraryBean bean) {
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			 
			Map<String, Object> function = new HashMap<String, Object>();

				
					function.put("userName", userDetails.getUsername());
					function.put("code2", bean.getCode2());
					function.put("desc", bean.getDescription());
				namedParameterJdbcTemplate.update(IdentifiersLibraryQueryUtil.SAVE_function,function);
		
			 resultBean.setSuccess(true);
			 
			 
		   
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
			resultBean.setMessage("Not Updated");
		}
		return resultBean;
	}
	
	@Override
	public IdentifiersLibraryResultBean saveitemdelilvery(IdentifiersLibraryBean bean) {
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			 
			Map<String, Object> delivery = new HashMap<String, Object>();

				
			delivery.put("userName", userDetails.getUsername());
			delivery.put("code1", bean.getCode1());
			delivery.put("desc", bean.getDescription());
			delivery.put("scale", bean.getScale());
					
				namedParameterJdbcTemplate.update(IdentifiersLibraryQueryUtil.SAVE_delivery,delivery);
		
			 resultBean.setSuccess(true);
			 
			 
		   
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
			resultBean.setMessage("Not Updated");
		}
		return resultBean;
	}
	
	@Override
	public IdentifiersLibraryResultBean savelocation(IdentifiersLibraryBean bean) {
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			 
			Map<String, Object> location = new HashMap<String, Object>();

				
			location.put("userName", userDetails.getUsername());
			location.put("code2", bean.getCode2());
			location.put("desc", bean.getDescription());
			
					
				namedParameterJdbcTemplate.update(IdentifiersLibraryQueryUtil.SAVE_location,location);
		
			 resultBean.setSuccess(true);
			 
			 
		   
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
			resultBean.setMessage("Not Updated");
		}
		return resultBean;
	}
	
	@Override
	public IdentifiersLibraryResultBean saveluboil(IdentifiersLibraryBean bean) {
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			 
			Map<String, Object> luboil = new HashMap<String, Object>();

				
			luboil.put("userName", userDetails.getUsername());
			luboil.put("code1", bean.getCode1());
			luboil.put("desc", bean.getDescription());
			
					
				namedParameterJdbcTemplate.update(IdentifiersLibraryQueryUtil.SAVE_luboil,luboil);
		
			 resultBean.setSuccess(true);
			 
			 
		   
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
			resultBean.setMessage("Not Updated");
		}
		return resultBean;
	}
	
	@Override
	public IdentifiersLibraryResultBean savepayment(IdentifiersLibraryBean bean) {
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			 
			Map<String, Object> payment = new HashMap<String, Object>();

				
			payment.put("userName", userDetails.getUsername());
			payment.put("code2", bean.getCode2());
			payment.put("desc", bean.getDescription());
			payment.put("scale", bean.getScale());
			payment.put("advpayment", bean.getAdvancePayment());
			
					
				namedParameterJdbcTemplate.update(IdentifiersLibraryQueryUtil.SAVE_payment,payment);
		
			 resultBean.setSuccess(true);
			 
			 
		   
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
			resultBean.setMessage("Not Updated");
		}
		return resultBean;
	}
	
	@Override
	public IdentifiersLibraryResultBean saveoffice(IdentifiersLibraryBean bean) {
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			 
			Map<String, Object> supplieroffice = new HashMap<String, Object>();

				
			supplieroffice.put("userName", userDetails.getUsername());
			supplieroffice.put("code2", bean.getCode2());
			supplieroffice.put("desc", bean.getDescription());
			
			namedParameterJdbcTemplate.update(IdentifiersLibraryQueryUtil.SAVE_office,supplieroffice);
		
			 resultBean.setSuccess(true);
			 
			 
		   
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
			resultBean.setMessage("Not Updated");
		}
		return resultBean;
	}
	@Override
	public IdentifiersLibraryResultBean getList() {
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		List<IdentifiersLibraryBean> listBean = new ArrayList<IdentifiersLibraryBean>();
		
		try {
			listBean = jdbcTemplate.query(IdentifiersLibraryQueryUtil.getList,new BeanPropertyRowMapper<IdentifiersLibraryBean>(IdentifiersLibraryBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}
	
	@Override
	public IdentifiersLibraryResultBean getList1() {
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		List<IdentifiersLibraryBean> listBean = new ArrayList<IdentifiersLibraryBean>();
		
		try {
			listBean = jdbcTemplate.query(IdentifiersLibraryQueryUtil.getListstorage,new BeanPropertyRowMapper<IdentifiersLibraryBean>(IdentifiersLibraryBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}
	@Override
	public IdentifiersLibraryResultBean getList2() {
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		List<IdentifiersLibraryBean> listBean = new ArrayList<IdentifiersLibraryBean>();
		
		try {
			listBean = jdbcTemplate.query(IdentifiersLibraryQueryUtil.getListfunction,new BeanPropertyRowMapper<IdentifiersLibraryBean>(IdentifiersLibraryBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}
	
	@Override
	public IdentifiersLibraryResultBean getList3() {
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		List<IdentifiersLibraryBean> listBean = new ArrayList<IdentifiersLibraryBean>();
		
		try {
			listBean = jdbcTemplate.query(IdentifiersLibraryQueryUtil.getListdelivery,new BeanPropertyRowMapper<IdentifiersLibraryBean>(IdentifiersLibraryBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}
	
	@Override
	public IdentifiersLibraryResultBean getLocationlist() {
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		List<IdentifiersLibraryBean> listBean = new ArrayList<IdentifiersLibraryBean>();
		
		try {
			listBean = jdbcTemplate.query(IdentifiersLibraryQueryUtil.getListlocation,new BeanPropertyRowMapper<IdentifiersLibraryBean>(IdentifiersLibraryBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}
	
	@Override
	public IdentifiersLibraryResultBean getLuboillist() {
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		List<IdentifiersLibraryBean> listBean = new ArrayList<IdentifiersLibraryBean>();
		
		try {
			listBean = jdbcTemplate.query(IdentifiersLibraryQueryUtil.getListluboil,new BeanPropertyRowMapper<IdentifiersLibraryBean>(IdentifiersLibraryBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}
	
	@Override
	public IdentifiersLibraryResultBean getPaymentlist() {
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		List<IdentifiersLibraryBean> listBean = new ArrayList<IdentifiersLibraryBean>();
		
		try {
			listBean = jdbcTemplate.query(IdentifiersLibraryQueryUtil.getListpayment,new BeanPropertyRowMapper<IdentifiersLibraryBean>(IdentifiersLibraryBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}
	
	@Override
	public IdentifiersLibraryResultBean getOfficelist() {
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		List<IdentifiersLibraryBean> listBean = new ArrayList<IdentifiersLibraryBean>();
		
		try {
			listBean = jdbcTemplate.query(IdentifiersLibraryQueryUtil.getListoffice,new BeanPropertyRowMapper<IdentifiersLibraryBean>(IdentifiersLibraryBean.class));
			resultBean.setList(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}
	
	@Override
	public IdentifiersLibraryBean getCodemax() {
		IdentifiersLibraryBean bean = new IdentifiersLibraryBean();
		
		try {
			int listBean = jdbcTemplate.queryForObject(IdentifiersLibraryQueryUtil.getmax,Integer.class);
			bean.setCode(listBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	@Override
	public IdentifiersLibraryResultBean edit(Integer id) {		
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(IdentifiersLibraryQueryUtil.getEdit,new Object[] { id }, new BeanPropertyRowMapper<IdentifiersLibraryBean>(IdentifiersLibraryBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}
	
	@Override
	public IdentifiersLibraryResultBean editstorage(Integer id) {		
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(IdentifiersLibraryQueryUtil.getEditStorage,new Object[] { id }, new BeanPropertyRowMapper<IdentifiersLibraryBean>(IdentifiersLibraryBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}
	
	@Override
	public IdentifiersLibraryResultBean editfunction(Integer id) {		
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(IdentifiersLibraryQueryUtil.getEditfunction,new Object[] { id }, new BeanPropertyRowMapper<IdentifiersLibraryBean>(IdentifiersLibraryBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}
	
	@Override
	public IdentifiersLibraryResultBean editdelivery(Integer id) {		
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(IdentifiersLibraryQueryUtil.getEditdelivery,new Object[] { id }, new BeanPropertyRowMapper<IdentifiersLibraryBean>(IdentifiersLibraryBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}
	
	@Override
	public IdentifiersLibraryResultBean editlocation(Integer id) {		
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(IdentifiersLibraryQueryUtil.getEditlocation,new Object[] { id }, new BeanPropertyRowMapper<IdentifiersLibraryBean>(IdentifiersLibraryBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}
	
	@Override
	public IdentifiersLibraryResultBean editluboil(Integer id) {		
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(IdentifiersLibraryQueryUtil.getEditluboil,new Object[] { id }, new BeanPropertyRowMapper<IdentifiersLibraryBean>(IdentifiersLibraryBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}
	
	@Override
	public IdentifiersLibraryResultBean editpayment(Integer id) {		
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(IdentifiersLibraryQueryUtil.getEditpayment,new Object[] { id }, new BeanPropertyRowMapper<IdentifiersLibraryBean>(IdentifiersLibraryBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}
	
	@Override
	public IdentifiersLibraryResultBean editoffice(Integer id) {		
		IdentifiersLibraryResultBean resultBean = new IdentifiersLibraryResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setList(jdbcTemplate.query(IdentifiersLibraryQueryUtil.getEditoffice,new Object[] { id }, new BeanPropertyRowMapper<IdentifiersLibraryBean>(IdentifiersLibraryBean.class)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean; 
	}



}
