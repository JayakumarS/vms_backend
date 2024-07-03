package com.vms.supplies.vesselCounters;

public class VesselCountersQueryUtil {
	
	public static final String SAVE_VESSEL_COUNTERS = "Insert into vessel_counters "
			+ "(vessel_code,option,start_from,type,department_code,created_dt,created_by) "
			+ "values(:vessel,:option,:startFrom,:type,:dep,now(),:userName) ";
	
	public static final String UPDATE_SUPPLIE_DEPARTMENT = "update vessel_counters "
			+ "set vessel_code=:vessel,option=:option,start_from=:startFrom,type=:type,department_code=:dep, "
			+ "modify_dt=now(),modify_by=:userName "
			+ "where vessel_counters_id = :id ";

	public static final String GET_SUPP_DEPT_DTLS="select supplie_dep_code as depCode,supplie_department_name as department,form_type as formType,item_order_comment as itemsToOrderComments, "
			+ "item_not_order_comment as itemsNotToOrderComments,available_office as availableOffice,available_vessel as availableVessel, "
			+ "office_undefine_items as officeUndefinedItemS,vessel_undefine_items as vesselUndefinedItemS,proposed_item as proposedItems, "
			+ "tolerance as tolerance,min_item as minimumItems,to_char(lsc_inv_date,'dd/mm/yyyy') as lscInvoiceDate from supplie_department where supplie_department_code = ? ";
	
	public static final String GET_CODE = "SELECT CASE WHEN MAX(supplie_department_code) IS NULL THEN 'SD0001' "
			+ " ELSE rpad(MAX(supplie_department_code),2,'SD')|| lpad(cast(cast((null_or_empty(SUBSTRING(MAX(supplie_department_code),3),'0')) as int)+1 as text),4,'0') "
			+ " END AS supplie_department_code  FROM supplie_department where supplie_department_code like 'SD%' ";
	
	public static final String GET_LIST = "select supplie_department_code as code,supplie_dep_code as depCode,supplie_department_name as department,to_char(created_dt,'dd/mm/yyyy') as cDate,created_by as cBy from supplie_department order by supplie_department_code desc ";
	
	public static final String DELETE_SUPPLIE_DEPARTMENT = "delete from supplie_department where supplie_department_code = ? ";

}
