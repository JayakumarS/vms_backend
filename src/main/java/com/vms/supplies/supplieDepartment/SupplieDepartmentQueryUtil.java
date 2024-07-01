package com.vms.supplies.supplieDepartment;

public class SupplieDepartmentQueryUtil {
	
	public static final String SAVE_SUPPLIE_DEPARTMENT = "Insert into supplie_department "
			+ "(supplie_department_code, supplie_department_name, form_type, item_order_comment, item_not_order_comment, tolerance, "
			+ "min_item, lsc_inv_date, available_office, available_vessel, office_undefine_items, vessel_undefine_items, proposed_item, "
			+ "created_dt, created_by) "
			+ "values(:code,:depName,:formType,:itemOrder,:itemNotOrder,:tol,:minItem,to_date(:lscInv,'dd/mm/yyyy'),:availOff,:availVsl,:offUndefine,:vslUndefine,:pItems,now(),:userName) ";
	
	public static final String UPDATE_SUPPLIE_DEPARTMENT = "update supplie_department "
			+ "set supplie_department_name=:depName, form_type=:formType, item_order_comment=:itemOrder, "
			+ "item_not_order_comment=:itemNotOrder, tolerance=:tol, "
			+ "min_item=:minItem, lsc_inv_date= to_date(:lscInv,'dd/mm/yyyy'), available_office=:availOff, available_vessel=:availVsl, office_undefine_items=:offUndefine, "
			+ "vessel_undefine_items=:vslUndefine,proposed_item=:pItems,modify_dt=now(), modify_by=:userName "
			+ "where  supplie_department_code = :code";

	public static final String GET_SUPP_DEPT_DTLS="select supplie_department_code as code,supplie_department_name as department,form_type as formType,item_order_comment as itemsToOrderComments, "
			+ "item_not_order_comment as itemsNotToOrderComments,available_office as availableOffice,available_vessel as availableVessel, "
			+ "office_undefine_items as officeUndefinedItemS,vessel_undefine_items as vesselUndefinedItemS,proposed_item as proposedItems, "
			+ "tolerance as tolerance,min_item as minimumItems,to_char(lsc_inv_date,'dd/mm/yyyy') as lscInvoiceDate from supplie_department where supplie_department_code = ? ";
	
	public static final String GET_CODE = "SELECT CASE WHEN MAX(supplie_department_code) IS NULL THEN 'SD0001' "
			+ " ELSE rpad(MAX(supplie_department_code),2,'SD')|| lpad(cast(cast((null_or_empty(SUBSTRING(MAX(supplie_department_code),3),'0')) as int)+1 as text),4,'0') "
			+ " END AS supplie_department_code  FROM supplie_department where supplie_department_code like 'SD%' ";
	
	public static final String GET_LIST = "select supplie_department_code as code,supplie_department_name as department,to_char(created_dt,'dd/mm/yyyy') as cDate,created_by as cBy from supplie_department order by supplie_department_code desc ";
	
	public static final String DELETE_SUPPLIE_DEPARTMENT = "delete from supplie_department where supplie_department_code = ? ";

}
