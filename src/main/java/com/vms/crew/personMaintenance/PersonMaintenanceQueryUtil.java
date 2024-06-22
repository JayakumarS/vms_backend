package com.vms.crew.personMaintenance;

public class PersonMaintenanceQueryUtil {
	
	public static final String SAVE_PERSON_MAINTENANCE = "Insert into person_maintenance "
			+ "(person_maintenance_code, surname, name, middle_name, nationality, rank, birth_date, gender, father_name, mother_name, place, license, "
			+ "health_status, decision_c, work_status, religion, agent, exp_month, no_voyages, vessel_type, last_sign_off, available_from, remarks_one, "
			+ "remarks_two, recom_by, status, file_path, file_name, created_by, created_dt) "
			+ "values(:code,:surname,:name,:middle,:nationality,:rank,to_date(:bDate,'dd/mm/yyyy'),:gender,:father,:mother,:place,:licence,:healthSt,:decisionC,:workStatus,:religion, "
			+ ":agent,:expMonth,:noVoyage,:vslType,to_date(:lastSignOff,'dd/mm/yyyy'),to_date(:available,'dd/mm/yyyy'),:remarksOne,:remarksTwo,:reCom,:active,'','',:userName,now()) ";
	
	public static final String GET_CODE = "SELECT CASE WHEN MAX(person_maintenance_code) IS NULL THEN 'PM0001' "
			+ "ELSE rpad(MAX(person_maintenance_code),2,'PM')|| lpad(cast(cast((null_or_empty(SUBSTRING(MAX(person_maintenance_code),3),'0')) as int)+1 as text),4,'0') "
			+ "END AS person_maintenance_code  FROM person_maintenance where person_maintenance_code like 'PM%' ";
	
	public static final String GET_LIST = "select person_maintenance_code as code,surname as surname,name as name,status as active,cm.country_name as nationality, "
			+ "gender as gender,am.agent_code_name as agent,w.work_status_name as workStatus,rm.rank_name as rank "
			+ "from person_maintenance pm "
			+ "left join rank_master rm on rm.rank_code = pm.rank "
			+ "left join agent_master am on am.agent_code = pm.agent "
			+ "left join work_status w on w.work_status_code  = pm.work_status "
			+ "left join country_master cm on cm.country_code = pm.nationality "
			+ "order by person_maintenance_code desc ";
	
	public static final String GET_DETAILS="SELECT crew_master_id as id, crew_master_code as code, crew_master_surname as surname, crew_master_name as name,"
			+"crew_master_middle_name as middle, crew_master_nationality as nationality, crew_master_rank as rank, to_char(crew_master_birth_date,'dd/mm/yyyy') as birthDate,"
			+"crew_master_gender as gender, crew_master_father_name as father, crew_master_mother_name as mother, crew_master_place as place,"
			+"crew_master_license as licence, crew_master_health_status as health, crew_master_decision_c as decision, crew_master_work_status as workStatus,"
			+"crew_master_religion as religion, crew_master_agent as agent, exp_month as expMonth, no_voyages as noVoyage,"
			+"to_char(crew_master_last_sign_off,'dd/mm/yyyy') as signedOff, to_char(crew_master_available_from,'dd/mm/yyyy') as availableFrom, remarks_one as remarksOne, status as active FROM crew_master"
			+ " WHERE crew_master_code = ? ";
	
}
